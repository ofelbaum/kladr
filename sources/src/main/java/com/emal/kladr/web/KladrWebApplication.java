package com.emal.kladr.web;

import com.emal.kladr.domain.Dom;
import com.emal.kladr.domain.Kladr;
import com.emal.kladr.domain.Street;
import com.emal.kladr.service.AddressService;
import com.emal.kladr.utils.KladrCodeBuilder;
import com.emal.kladr.utils.KladrCodeHelper;
import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private ComboBox regions;
    private ComboBox districts;
    private ComboBox localities;
    private ListSelect streetSelect;
    private Table table;

    @Autowired
    private MessageSource messageSource;

    @Qualifier("addressService")
    @Autowired
    private AddressService addressService;

    @Override
    public void init() {
        window = new Window("MainApplicationWindow");
        window.setLocale(Locale.getDefault());
        window.setCaption(messageSource.getMessage("application.title", null, Locale.getDefault()));
        setMainWindow(window);

        regions = new ComboBox("Регионы");
        regions.setFilteringMode(AbstractSelect.Filtering.FILTERINGMODE_STARTSWITH);
        regions.setImmediate(true);
        regions.setNullSelectionAllowed(false);
        regions.setInputPrompt("Выберите субъект");

        List<Kladr> rfSubjects = addressService.getRFSubjects();
        for (Kladr kladr : rfSubjects) {
            regions.addItem(kladr);
        }
        regions.addListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Kladr kladr = (Kladr) valueChangeEvent.getProperty().getValue();
                log.debug("Choose [" + kladr + "]");
                if (kladr == null) {
                    districts.setEnabled(false);
                    districts.removeAllItems();
                    districts.select(null);
                    return;
                }

                String area = KladrCodeHelper.getRegion(kladr.getCode());
                List<Kladr> list = addressService.getDistricts(area);
                districts.removeAllItems();
                String code = KladrCodeBuilder.getInstance().addRegion(area).build();
                Kladr emptyValue = Kladr.EMPTY_VALUE;
                emptyValue.setCode(code);
                districts.addItem(emptyValue);
                for (Kladr dist : list) {
                    districts.addItem(dist);
                }
                districts.setEnabled(true);
                localities.removeAllItems();
            }
        });
        window.addComponent(regions);

        districts = new ComboBox("Районы");
        districts.setInputPrompt("Выберите район");
        districts.setEnabled(false);
        districts.setImmediate(true);
        districts.setNullSelectionAllowed(false);
        districts.setFilteringMode(AbstractSelect.Filtering.FILTERINGMODE_STARTSWITH);
        districts.addListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Kladr kladr = (Kladr) valueChangeEvent.getProperty().getValue();
                log.debug("Choose [" + kladr + "]");
                if (kladr == null) {
                    localities.setEnabled(false);
                    localities.removeAllItems();
                    localities.select(null);
                    return;
                }

                String area = KladrCodeHelper.getRegion(kladr.getCode());
                String district = KladrCodeHelper.getDistrict(kladr.getCode());
                List<Kladr> list = addressService.getLocalities(area, district);
                localities.removeAllItems();

                String code = KladrCodeBuilder.getInstance().addRegion(area).addDistrict(district).build();
                Kladr emptyValue = Kladr.EMPTY_VALUE;
                emptyValue.setCode(code);
                localities.addItem(emptyValue);
                for (Kladr dist : list) {
                    localities.addItem(dist);
                }
                localities.setEnabled(true);
            }
        });

        window.addComponent(districts);

        localities = new ComboBox("Населенные пункты");
        localities.setInputPrompt("Выберите населенный пункт");
        localities.setEnabled(false);
        localities.setImmediate(true);
        localities.setNullSelectionAllowed(false);
        localities.setFilteringMode(AbstractSelect.Filtering.FILTERINGMODE_STARTSWITH);
        localities.addListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                long startTime = System.currentTimeMillis();

                Kladr kladr = (Kladr) valueChangeEvent.getProperty().getValue();
                log.debug("Choose [" + kladr + "]");
                if (kladr == null) {
                    streetSelect.removeAllItems();
                    streetSelect.setEnabled(false);
                    return;
                }
                String region = KladrCodeHelper.getRegion(kladr.getCode());
                String district = KladrCodeHelper.getDistrict(kladr.getCode());
                String locality = KladrCodeHelper.getLocality(kladr.getCode());
                List<Street> streetsList = addressService.getStreets(region, district, locality);

                streetSelect.removeAllItems();
                for (Street street : streetsList) {
                    streetSelect.addItem(street);
                }
                streetSelect.setEnabled(true);

                long processTime = (System.currentTimeMillis() - startTime) / 1000;
                log.debug("Streets loaded for " + processTime + " sec");
            }
        });
        window.addComponent(localities);

        streetSelect = new ListSelect("Выберите улицу");
        streetSelect.setRows(15);
        streetSelect.setNullSelectionAllowed(false);
        streetSelect.setImmediate(true);
        streetSelect.setEnabled(false);
        streetSelect.setWidth(100, Sizeable.UNITS_PERCENTAGE);
        streetSelect.addListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                Street street = (Street) event.getProperty().getValue();
                if (street == null) {
                    table.removeAllItems();
                    table.setEnabled(false);
                    return;
                }
                log.debug("Index [" + street.getPostIndex() + "]\t Code [" + street.getCode() + "]");
                String region = KladrCodeHelper.getRegion(street.getCode());
                String district = KladrCodeHelper.getDistrict(street.getCode());
                String locality = KladrCodeHelper.getLocality(street.getCode());
                String str = KladrCodeHelper.getStreet(street.getCode());
                List<Dom> doms = addressService.getDoms(region, district, locality, str);

                table.setContainerDataSource(new BeanItemContainer(Dom.class, doms));
                table.setVisibleColumns(new Object[]{"Номер", "Индекс", "КЛАДР"});
                table.setEnabled(true);
            }
        });
        window.addComponent(streetSelect);

        table = new Table("Дома");
        table.setPageLength(6);
        table.setWidth("100%");
        table.setImmediate(true);
        table.addGeneratedColumn("Номер", new Table.ColumnGenerator() {
            public com.vaadin.ui.Component generateCell(Table source, Object itemId,
                                                        Object columnId) {
                Item item = source.getItem(itemId);
                Object entityId = item.getItemProperty("name").getValue();
                return new Label(String.valueOf(entityId));
            }
        });
        table.addGeneratedColumn("КЛАДР", new Table.ColumnGenerator() {
            public com.vaadin.ui.Component generateCell(Table source, Object itemId,
                                                        Object columnId) {
                Item item = source.getItem(itemId);
                Object entityId = item.getItemProperty("code").getValue();
                return new Label(String.valueOf(entityId));
            }
        });
        table.addGeneratedColumn("Индекс", new Table.ColumnGenerator() {
            public com.vaadin.ui.Component generateCell(Table source, Object itemId,
                                                        Object columnId) {
                Item item = source.getItem(itemId);
                Object entityId = item.getItemProperty("postIndex").getValue();
                return new Label(String.valueOf(entityId));
            }
        });
        table.setColumnAlignments(new String[]{Table.ALIGN_CENTER, Table.ALIGN_CENTER, Table.ALIGN_CENTER});
        table.setEnabled(false);
        window.addComponent(table);

        Button button = new Button("Сбросить");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                regions.select(null);
            }
        });
        window.addComponent(button);

    }
}
