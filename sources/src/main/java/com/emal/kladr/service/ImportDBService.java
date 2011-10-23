package com.emal.kladr.service;

import com.emal.kladr.dao.KladrDao;
import com.emal.kladr.domain.Kladr;
import com.linuxense.javadbf.DBFReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * User: admin
 * Date: 20.10.11 1:08
 */
@Service
public class ImportDBService {
    private static final Logger log = LoggerFactory.getLogger(ImportDBService.class);
    private static final String kladrFileName = "D:\\java\\gitrepo\\ws\\kladr\\KLADR.DBF";
    private static final String streetFileName = "D:\\java\\gitrepo\\ws\\kladr\\STREET.DBF";

    @Value("${import.enabled}")
    private Boolean importEnabled;

    @Autowired
    private KladrDao kladrDao;

    @PostConstruct
    public void doImport() throws IOException {
        if (Boolean.FALSE.equals(importEnabled)) {
            log.debug("Import ignored");
            return;
        }
        log.debug("Import started");
        log.debug("Processing: " + kladrFileName);
        kladrDao.deleteAll();
        long total = doImport(kladrFileName);
        log.debug("Imported [" + total + "] rows");

        log.debug("Import finished");
    }

    private long doImport(String dbfFileName) throws IOException {
        InputStream inputStream = new FileInputStream(dbfFileName);

        DBFReader reader = new DBFReader(inputStream);
        reader.setCharactersetName("Cp866");

        List<Kladr> kladrs = new ArrayList<Kladr>();
        Object[] rowObjects;
        long total = 0;
        while ((rowObjects = reader.nextRecord()) != null) {
//            String code = (String) rowObjects[2];
//            if (!Pattern.matches("^78\\d+$", code)) {
//                continue;
//            }

            Kladr kladr = create(rowObjects);
            kladrs.add(kladr);
            total++;
            if (kladrs.size() > 50000) {
                kladrDao.insert(kladrs);
                log.debug("Flush batch [" + total + "]");
                kladrs.clear();
            }
        }
        inputStream.close();
        kladrDao.insert(kladrs);
        return total;
    }

    private Kladr create(Object[] rowObjects) {
        if (rowObjects.length != 8) {
            throw new IllegalArgumentException("Wrong column number");
        }
        String name = (String) rowObjects[0];
        String socr = (String) rowObjects[1];
        String code = (String) rowObjects[2];
        String postIndex = (String) rowObjects[3];
        String gninmb = (String) rowObjects[4];
        String uno = (String) rowObjects[5];
        String ocatd = (String) rowObjects[6];
        String status = (String) rowObjects[7];
        return new Kladr(name, socr, code, postIndex, gninmb, uno, ocatd, status);
    }
}
