package com.emal.kladr.service;

import com.emal.kladr.domain.Dom;
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

    public List<Kladr> getRegions();
    public List<Kladr> getDistricts(String region);
    public List<Kladr> getLocalities(String region, String district);
    public List<Street> getStreets(String region, String district, String locality);
    public List<Street> getStreets(String region, String district, String locality, String streetNamePrefix);
    public List<Dom> getBuildings(String region, String district, String locality, String street);
}
