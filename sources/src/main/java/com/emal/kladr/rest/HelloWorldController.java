package com.emal.kladr.rest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * User: admin
 * Date: 22.10.11 17:01
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {
    private static ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("")
    public void doAction(HttpServletResponse response) throws UnsupportedEncodingException {
        JSONOperationResponse jsonOperationResponse = new JSONOperationResponse();
        jsonOperationResponse.setData("Привет!!!");
        JSONHelper.fillResponse(objectMapper, response, jsonOperationResponse);
    }
}
