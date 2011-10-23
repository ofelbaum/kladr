package com.emal.kladr.service.impl;

import com.emal.kladr.dao.KladrDao;
import com.emal.kladr.domain.Kladr;
import com.emal.kladr.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: admin
 * Date: 23.10.11 14:24
 */
@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private KladrDao kladrDao;

    @Override
    public Kladr getKladrByCode(String code) {
        return kladrDao.getByCode(code);
    }

    @Override
    public List<Kladr> getKladrsByCode(String code) {
        return kladrDao.getListByCode(code);
    }

    @Override
    public List<Kladr> getRFSubjects() {
        return kladrDao.getRFSubjects();
    }
}
