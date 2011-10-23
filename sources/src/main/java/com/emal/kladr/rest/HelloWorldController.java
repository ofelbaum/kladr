package com.emal.kladr.rest;

import com.emal.kladr.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: admin
 * Date: 22.10.11 17:01
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    @Autowired
    private AddressService addressService;

    @RequestMapping({"{codePrefix}"})
    @ResponseBody
    public Object getByCodePrefix(@PathVariable("codePrefix") String codePrefix) {
        return addressService.getKladrsByCode(codePrefix);
    }

    @RequestMapping("/subjects")
    @ResponseBody
    public Object getRFSubjects() {
        return addressService.getRFSubjects();
    }
}
