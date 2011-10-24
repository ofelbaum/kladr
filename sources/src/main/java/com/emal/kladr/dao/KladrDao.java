package com.emal.kladr.dao;

import com.emal.kladr.domain.Kladr;

import java.util.List;

/**
 * User: admin
 * Date: 15.10.11 22:22
 */
public interface KladrDao extends BaseDao<Kladr>{
    public List<Kladr> getRFSubjects();

    List<Kladr> getDistricts(String subject);

    List<Kladr> getCities(String subject, String district);

    List<Kladr> getCountries(String subject, String district, String city);
}
