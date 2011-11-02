package com.emal.kladr.service;

import com.emal.kladr.dao.*;
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
    private BuildingDao buildingDao;

    @Autowired
    private AltnameDao altnameDao;

    @Autowired
    private FlatDao flatDao;

    @Autowired
    private SocrbaseDao socrbaseDao;

    @PostConstruct
    public void doImport() throws IOException {
        if (Boolean.FALSE.equals(importEnabled)) {
            log.debug("Import ignored");
            return;
        }
        log.debug("Import [STARTED]");
        runImport(kladrDao, kladrFileName);
        runImport(streetDao, streetFileName);
        runImport(buildingDao, domaFileName);
        runImport(altnameDao, altnamesFileName);
        runImport(flatDao, flatFileName);
        runImport(socrbaseDao, socrbaseFileName);
        log.debug("Import [FINISHED]");
    }

    private boolean isSpbRegion(String code) {
        return Pattern.matches("^78\\d+$", code);
    }

    private void runImport(BaseDao baseDao, String fileName) throws IOException {
        long total = 0;

        log.debug("Processing: " + fileName);
        baseDao.deleteAll();
        total = baseDao.importData(fileName);
        log.debug("Imported [" + total + "] rows");
    }
}
