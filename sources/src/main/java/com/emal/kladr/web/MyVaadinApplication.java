package com.emal.kladr.web;

import com.emal.kladr.dao.KladrDao;
import com.emal.kladr.domain.Kladr;
import com.emal.kladr.service.AddressService;
import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Locale;

/**
 * User: admin
 * Date: 22.10.11 15:24
 */
@Configurable(preConstruction = true)
public class MyVaadinApplication extends Application {
    private Window window;
    private TextField textField;
    private ComboBox l;

    @Autowired
    private AddressService addressService;

    @Override
    public void init() {
        window = new Window("My Vaadin Application");
        window.setLocale(Locale.getDefault());
        window.setCaption("Мое приложение");
        setMainWindow(window);

        l = new ComboBox("Субъекты РФ");
        l.setFilteringMode(AbstractSelect.Filtering.FILTERINGMODE_OFF);
        l.setImmediate(true);
        l.setInputPrompt("Выберите субъект");

        List<Kladr> rfSubjects = addressService.getRFSubjects();
        for (Kladr kladr : rfSubjects) {
            l.addItem(kladr);
        }
        l.addListener(new com.vaadin.ui.Component.Listener() {
            @Override
            public void componentEvent(com.vaadin.ui.Component.Event event) {
                System.out.println(event);
            }
        });


//        window.addComponent(textField);
        window.addComponent(l);

        Button button = new Button("Click Me");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
//                window.addComponent(new Label("Code [" + code + "] has value [" + name + "]"));
            }
        });
        window.addComponent(button);

    }
}
