package com.emal.kladr.service;

import com.emal.kladr.dao.DomDao;
import com.emal.kladr.dao.KladrDao;
import com.emal.kladr.dao.StreetDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * User: admin
 * Date: 20.10.11 1:08
 */
@Service
public class ImportDBService {
    private static final Logger log = LoggerFactory.getLogger(ImportDBService.class);

    @Value("${import.enabled}")
    private Boolean importEnabled;

    @Value("${import.kladr.filename}")
    private String kladrFileName;

    @Value("${import.street.filename}")
    private String streetFileName;

    @Value("${import.altnames.filename}")
    private String altnamesFileName;

    @Value("${import.doma.filename}")
    private String domaFileName;

    @Value("${import.flat.filename}")
    private String flatFileName;

    @Value("${import.socrbase.filename}")
    private String socrbaseFileName;

    @Autowired
    private KladrDao kladrDao;

    @Autowired
    private StreetDao streetDao;

    @Autowired
    private DomDao domDao;

    @PostConstruct
    public void doImport() throws IOException {
        if (Boolean.FALSE.equals(importEnabled)) {
            log.debug("Import ignored");
            return;
        }
        long total = 0;
        log.debug("Import started for " + kladrFileName);
        log.debug("Processing: " + kladrFileName);
        kladrDao.deleteAll();
        total = kladrDao.importData(kladrFileName);
        log.debug("Imported [" + total + "] rows");

        total = 0;
        log.debug("Import started for " + streetFileName);
        log.debug("Processing: " + streetFileName);
        streetDao.deleteAll();
        total = streetDao.importData(streetFileName);
        log.debug("Imported [" + total + "] rows");
        log.debug("Import finished");

        total = 0;
        log.debug("Import started for " + domaFileName);
        log.debug("Processing: " + domaFileName);
        domDao.deleteAll();
        total = domDao.importData(domaFileName);
        log.debug("Imported [" + total + "] rows");
        log.debug("Import finished");
    }

    private boolean isSpbRegion(String code) {
        return Pattern.matches("^78\\d+$", code);
    }
}
