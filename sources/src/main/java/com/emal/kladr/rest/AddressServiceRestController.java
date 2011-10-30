package com.emal.kladr.rest;

import com.emal.kladr.domain.Dom;
import com.emal.kladr.domain.Kladr;
import com.emal.kladr.domain.Street;
import com.emal.kladr.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: admin
 * Date: 22.10.11 17:01
 */
@Controller
@RequestMapping("/address")
public class AddressServiceRestController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("")
    @ResponseBody
    public List<Kladr> getRegions() {
        return addressService.getRegions();
    }

    @RequestMapping("/{region}")
    @ResponseBody
    public List<Kladr> getDistricts(@PathVariable("region") String region) {
        return addressService.getDistricts(region);
    }

    @RequestMapping("/{region}/{district}")
    @ResponseBody
    public List<Kladr> getLocalities(@PathVariable("region") String region,
                                     @PathVariable("district") String district) {
        return addressService.getLocalities(region, district);
    }

    @RequestMapping("/{region}/{district}/{locality}")
    @ResponseBody
    public List<Street> getStreets(@PathVariable("region") String region,
                                      @PathVariable("district") String district,
                                      @PathVariable("locality") String locality,
                                      @RequestParam(value = "q", required = false) String namePrefix) {
        List<Street> streets;
        if (StringUtils.hasText(namePrefix)) {
            streets = addressService.getStreets(region, district, locality, namePrefix);
        } else {
            streets = addressService.getStreets(region, district, locality);
        }
        return streets;
    }

    @RequestMapping("/{region}/{district}/{locality}/{street}")
    @ResponseBody
    public List<Dom> getHouses(@PathVariable("region") String region,
                                      @PathVariable("district") String district,
                                      @PathVariable("locality") String locality,
                                      @PathVariable("street") String street) {
        return addressService.getBuildings(region, district, locality, street);
    }
}
