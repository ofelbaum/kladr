package com.emal.kladr.rest;

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

    @RequestMapping("")
    @ResponseBody
    public Object doAction() {
        return "OK";
    }
}
