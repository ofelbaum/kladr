package com.app.webservice;

import java.util.Date;

import com.app.dao.KladrDao;
import com.app.service.HumanResourceService;
import com.app.xml.HolidayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class HolidayEndpoint {

    public static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";
    public static final String NAME = "HolidayRequest";

    @Autowired
    private HumanResourceService humanResourceService;

    @Autowired
    private KladrDao kladrDao;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = NAME)
    public void handleHolidayRequest(@RequestPayload HolidayRequest holidayRequest)
            throws Exception {
        Date startDate = holidayRequest.getHoliday().getStartDate();
        Date endDate = holidayRequest.getHoliday().getEndDate();
        String name = holidayRequest.getEmployee().getFirstName() + " " + holidayRequest.getEmployee().getLastName();

        humanResourceService.bookHoliday(startDate, endDate, name);
    }
}