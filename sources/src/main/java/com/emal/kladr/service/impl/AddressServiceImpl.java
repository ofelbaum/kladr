package com.emal.kladr.service.impl;

import com.emal.kladr.dao.DomDao;
import com.emal.kladr.dao.KladrDao;
import com.emal.kladr.dao.StreetDao;
import com.emal.kladr.domain.Dom;
import com.emal.kladr.domain.Kladr;
import com.emal.kladr.domain.Street;
import com.emal.kladr.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: admin
 * Date: 23.10.11 14:24
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService{

    @Autowired
    private KladrDao kladrDao;

    @Autowired
    private StreetDao streetDao;

    @Autowired
    private DomDao domDao;

    @Override
    public Kladr getKladrByCode(String code) {
        return kladrDao.getByCode(code);
    }

    @Override
    public List<Kladr> getKladrsByCode(String code) {
        return kladrDao.getListByCode(code);
    }

    @Override
    public List<Kladr> getRegions() {
        return kladrDao.getRegions();
    }

    @Override
    public List<Kladr> getDistricts(String subject) {
        return kladrDao.getDistricts(subject);
    }

    @Override
    public List<Kladr> getLocalities(String subject, String district) {
        return kladrDao.getLocalities(subject, district);
    }

    @Override
    public List<Street> getStreets(String subject, String district, String locality) {
        return streetDao.getListByCode(subject + district + locality);
    }

    @Override
    public List<Street> getStreets(String subject, String district, String locality, String streetNamePrefix) {
        return streetDao.getListByCode(subject + district + locality, streetNamePrefix);
    }

    @Override
    public List<Dom> getBuildings(String subject, String district, String locality, String street) {
        return domDao.getListByCode(subject + district + locality + street);
    }
}
