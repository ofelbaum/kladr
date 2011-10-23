package com.emal.kladr.rest;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class JSONHelper {
    private static final Logger log = LoggerFactory.getLogger(JSONHelper.class);

    public static void fillResponse(ObjectMapper jsonObjectMapper,
                                    HttpServletResponse response,
                                    Object obj) {
        OutputStream os = null;
        try {
            String jsonAsString = jsonObjectMapper.writeValueAsString(obj);
            log.debug("Результат:");
            log.debug(jsonAsString);
            os = response.getOutputStream();
            os.write(jsonAsString.getBytes("UTF-8"));
            response.setContentType("application/json;charset=utf-8");
        } catch (Exception e) {
            log.error("Exception occured during writing response into stream. Error message is " + e.getMessage());
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {/*nothing to do*/}
            }
        }
    }
}
