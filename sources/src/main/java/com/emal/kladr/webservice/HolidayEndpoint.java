package com.emal.kladr.webservice;

import java.util.Date;

import com.emal.kladr.dao.KladrDao;
import com.emal.kladr.domain.Kladr;
import com.emal.kladr.service.AddressService;
import com.emal.kladr.service.HumanResourceService;
import com.emal.kladr.xml.HolidayRequest;
import com.emal.kladr.xml.KladrRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.addressing.server.annotation.Action;

@Endpoint
public class HolidayEndpoint {

    public static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";
    public static final String NAME = "HolidayRequest";
    public static final String KLADR_REQUEST = "KladrRequest";

    private static final Logger log = LoggerFactory.getLogger(HolidayEndpoint.class);

    @Autowired
    private HumanResourceService humanResourceService;

    @Autowired
    private AddressService addressService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = NAME)
    public void handleHolidayRequest(@RequestPayload HolidayRequest holidayRequest)
            throws Exception {
        Date startDate = holidayRequest.getHoliday().getStartDate();
        Date endDate = holidayRequest.getHoliday().getEndDate();
        String name = holidayRequest.getEmployee().getFirstName() + " " + holidayRequest.getEmployee().getLastName();

        humanResourceService.bookHoliday(startDate, endDate, name);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = KLADR_REQUEST)
    @ResponsePayload
    public Kladr handleKladrRequest(@RequestPayload KladrRequest kladrRequest)
            throws Exception {
        String code = kladrRequest.getCodePrefix();
        return addressService.getKladrByCode(code);
    }
}