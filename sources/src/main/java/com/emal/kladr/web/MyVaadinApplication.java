package com.emal.kladr.web;

import com.emal.kladr.dao.KladrDao;
import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

/**
 * User: admin
 * Date: 22.10.11 15:24
 */
@Configurable(preConstruction = true)
public class MyVaadinApplication extends Application {
    private Window window;

    @Autowired
    private KladrDao kladrDao;

    @Override
    public void init() {
//        SpringContextHelper helper = new SpringContextHelper(this);
//        kladrDao = (KladrDao) helper.getBean(KladrDao.class);


        window = new Window("My Vaadin Application");
        setMainWindow(window);

        final TextField textField = new TextField();
        textField.setInputPrompt("Code");
        // configure & add to layout
        textField.setImmediate(true);
        window.addComponent(textField);

        Button button = new Button("Click Me");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                String code = (String) textField.getValue();
                String name = kladrDao.getByCode(code).getName();
                window.addComponent(new Label("Code [" + code + "] has value [" + name + "]"));
            }
        });
        window.addComponent(button);

    }
}
