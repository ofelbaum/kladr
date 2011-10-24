package com.emal.kladr.web;

import com.emal.kladr.domain.Kladr;
import com.emal.kladr.service.AddressService;
import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

/**
 * User: admin
 * Date: 22.10.11 15:24
 */
@Component("application")
public class KladrWebApplication extends Application {
    private static final Logger log = LoggerFactory.getLogger(KladrWebApplication.class);

    private Window window;
    private TextField textField;
    private ComboBox subjects;
    private ComboBox districts;
    private ComboBox cities;
    private ComboBox countries;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private AddressService addressService;

    @Override
    public void init() {
        window = new Window("MainApplicationWindow");
        window.setLocale(Locale.getDefault());
        window.setCaption(messageSource.getMessage("application.title", null, Locale.getDefault()));
        setMainWindow(window);

        subjects = new ComboBox("Субъекты РФ");
        subjects.setFilteringMode(AbstractSelect.Filtering.FILTERINGMODE_OFF);
        subjects.setImmediate(true);
        subjects.setInputPrompt("Выберите субъект");

        List<Kladr> rfSubjects = addressService.getRFSubjects();
        for (Kladr kladr : rfSubjects) {
            subjects.addItem(kladr);
        }
        subjects.addListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Kladr kladr = (Kladr) valueChangeEvent.getProperty().getValue();
                log.debug("Choose [" + kladr + "]");
                String area = kladr.getSubject();
                List<Kladr> list = addressService.getDistricts(area);
                districts.removeAllItems();
                Kladr emptyValue = Kladr.EMPTY_VALUE;
                districts.addItem(emptyValue);
                for (Kladr dist : list) {
                    districts.addItem(dist);
                }
            }
        });
        window.addComponent(subjects);

        districts = new ComboBox("Районы");
        districts.addListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Kladr kladr = (Kladr) valueChangeEvent.getProperty().getValue();
                log.debug("Choose [" + kladr + "]");

                String area = kladr.getSubject();
                String district = kladr.getDistrict();
                List<Kladr> list = addressService.getCities(area, district);
                cities.removeAllItems();
                cities.addItem(Kladr.EMPTY_VALUE);
                for (Kladr dist : list) {
                    cities.addItem(dist);
                }
            }
        });

        window.addComponent(districts);

        cities = new ComboBox("Города");
        cities.addListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Kladr kladr = (Kladr) valueChangeEvent.getProperty().getValue();
                log.debug("Choose [" + kladr + "]");
                String area = kladr.getSubject();
                String district = kladr.getDistrict();
                String city = kladr.getCity();
                List<Kladr> list = addressService.getCountries(area, district, city);
                countries.removeAllItems();
                countries.addItem(Kladr.EMPTY_VALUE);
                for (Kladr dist : list) {
                    countries.addItem(dist);
                }
            }
        });
        window.addComponent(cities);

        countries = new ComboBox("Населенные пункты");
        window.addComponent(countries);

        Button button = new Button("Сбросить");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                subjects.discard();
                districts.removeAllItems();
                cities.removeAllItems();
                countries.removeAllItems();

            }
        });
        window.addComponent(button);

    }
}
