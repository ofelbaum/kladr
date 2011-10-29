package com.emal.kladr.service;

import com.emal.kladr.domain.Kladr;
import com.emal.kladr.domain.Street;

import java.util.List;

/**
 * User: admin
 * Date: 23.10.11 14:22
 */
public interface AddressService {
    public Kladr getKladrByCode(String code);
    public List<Kladr> getKladrsByCode(String code);

    public List<Kladr> getRFSubjects();
    public List<Kladr> getDistricts(String subject);
    public List<Kladr> getLocalities(String subject, String district);
    public List<Street> getStreets(String subject, String district, String locality);
}
