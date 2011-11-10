package com.emal.kladr.web;

import java.io.*;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.vaadin.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.vaadin.Application;
import com.vaadin.ui.Button.ClickEvent;

@Component("adminApplication")
public class AdminWebApplication extends Application {
    private static final long serialVersionUID = 1L;
    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private static final Logger log = LoggerFactory.getLogger(AdminWebApplication.class);

    private Label state = new Label();
    private Label result = new Label();
    private Label fileName = new Label();
    private Label textualProgress = new Label();

    private ProgressIndicator pi = new ProgressIndicator();

    private LineBreakCounter counter = new LineBreakCounter();

    private Upload upload = new Upload(null, counter);

    private File file;


    @Override
    public void init() {
        Window window;
        Label label;
        Button logout;

        window = new Window("My Vaadin Application");

        setMainWindow(window);
        setLogoutURL("/admin/j_spring_security_logout");

        if (hasAnyRole(ROLE_ADMIN)) {
            label = new Label("You have admin role.");
        } else {
            label = new Label("You have user role.");
        }

        logout = new Button("logout");
        logout.addListener(new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
                getMainWindow().getApplication().close();
            }
        });

        window.addComponent(label);
        window.addComponent(logout);

        window.addComponent(new Label("Upload a file."));

        // make analyzing start immediatedly when file is selected
        upload.setImmediate(true);
        upload.setButtonCaption("Upload File");
        window.addComponent(upload);

        final Button cancelProcessing = new Button("Cancel");
        cancelProcessing.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                upload.interruptUpload();
            }
        });
        cancelProcessing.setVisible(false);
        cancelProcessing.setStyleName("small");

        Panel p = new Panel("Status");
        p.setSizeUndefined();
        FormLayout l = new FormLayout();
        l.setMargin(true);
        p.setContent(l);
        HorizontalLayout stateLayout = new HorizontalLayout();
        stateLayout.setSpacing(true);
        stateLayout.addComponent(state);
        stateLayout.addComponent(cancelProcessing);
        stateLayout.setCaption("Current state");
        state.setValue("Idle");
        l.addComponent(stateLayout);
        fileName.setCaption("File name");
        l.addComponent(fileName);
        result.setCaption("Uploaded file size");
        l.addComponent(result);
        pi.setCaption("Progress");
        pi.setVisible(false);
        l.addComponent(pi);
        textualProgress.setVisible(false);
        l.addComponent(textualProgress);

        window.addComponent(p);

        upload.addListener(new Upload.StartedListener() {
            public void uploadStarted(Upload.StartedEvent event) {
                pi.setValue(0f);
                pi.setVisible(true);
                pi.setPollingInterval(500); // hit server frequantly to get
                textualProgress.setVisible(true);
                // updates to client
                state.setValue("Uploading");
                fileName.setValue(event.getFilename());

                cancelProcessing.setVisible(true);
            }
        });

        upload.addListener(new Upload.ProgressListener() {
            public void updateProgress(long readBytes, long contentLength) {
                pi.setValue(new Float(readBytes / (float) contentLength));
                textualProgress.setValue("Processed " + readBytes + " bytes of " + contentLength);
                result.setValue(counter.getBytesCounter() + " (counting...)");
            }
        });

        upload.addListener(new Upload.SucceededListener() {
            public void uploadSucceeded(Upload.SucceededEvent event) {
//                File file = counter.getTempFile();
                result.setValue(counter.getBytesCounter() / 1024 + " kb (total)");
            }
        });

        upload.addListener(new Upload.FailedListener() {
            public void uploadFailed(Upload.FailedEvent event) {
                result.setValue(counter.getBytesCounter() + " (counting interrupted at " + Math.round(100 * (Float) pi.getValue()) + "%)");
            }
        });

        upload.addListener(new Upload.FinishedListener() {
            public void uploadFinished(Upload.FinishedEvent event) {
                state.setValue("Idle");
                pi.setVisible(false);
                textualProgress.setVisible(false);
                cancelProcessing.setVisible(false);
                File file = counter.getTempFile();
                try {
                    process(file);
                } catch (IOException e) {
                    log.debug("Processing fails. Reason: " + e.getLocalizedMessage());
                }
            }
        });

    }

    private void process(File file) throws IOException {
        ZipFile zip = new ZipFile(file);
        Enumeration entries = zip.entries();

        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            log.debug("Extracting:" + entry.getName());
        }
        zip.close();
    }

    private boolean hasAnyRole(String... roles) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            for (String role : roles) {
                if (role.equals(authority.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }

    public class LineBreakCounter implements Upload.Receiver {

        private String fileName;
        private String mtype;

        private int counter;
        private File tempFile;

        /**
         * return an OutputStream that simply counts lineends
         */
        public OutputStream receiveUpload(String filename, String MIMEType) {
            try {
                tempFile = File.createTempFile(filename, null);
                counter = 0;
                fileName = filename;
                mtype = MIMEType;
                return new FileOutputStream(tempFile) {
                    @Override
                    public void write(int b) throws IOException {
                        super.write(b);
                        counter++;
                    }
                };
            } catch (IOException e) {
                log.debug("Upload fails. Reason: " + e.getLocalizedMessage());
            }
            return null;
        }

        public File getTempFile() {
            return tempFile;
        }

        public String getFileName() {
            return fileName;
        }

        public String getMimeType() {
            return mtype;
        }

        public int getBytesCounter() {
            return counter;
        }
    }
}