package com.emal.kladr.webservice;

import com.emal.kladr.domain.Kladr;
import com.emal.kladr.service.AddressService;
import com.emal.kladr.webservice.xml.DistrictsRequest;
import com.emal.kladr.webservice.xml.KladrResponse;
import com.emal.kladr.webservice.xml.LocalitiesRequest;
import com.emal.kladr.webservice.xml.ObjectFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

/**
 * User: alexey.emelyanenko@gmail.com
 * Date: 01.11.11 23:09
 */
@Endpoint
public class AddressServiceEndpoint {
    public static final String NAMESPACE_URI = "http://emal.com/kladr/schemas";
    private static ObjectFactory objectFactory = new ObjectFactory();

    @Autowired
    private AddressService addressService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RegionsRequest")
    @ResponsePayload
    public KladrResponse handleRegionRequest()
            throws Exception {
        List<Kladr> list = addressService.getRegions();
        return createKladrResponse(list);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DistrictsRequest")
    @ResponsePayload
    public KladrResponse handleDistrictsRequest(@RequestPayload DistrictsRequest districtsRequest)
            throws Exception {
        List<Kladr> list = addressService.getDistricts(districtsRequest.getRegion());
        return createKladrResponse(list);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LocalitiesRequest")
    @ResponsePayload
    public KladrResponse handleLocalitiesRequest(@RequestPayload LocalitiesRequest localitiesRequest)
            throws Exception {

        List<Kladr> list = addressService.getLocalities(localitiesRequest.getRegion(), localitiesRequest.getDistrict());
        return createKladrResponse(list);
    }

    private KladrResponse createKladrResponse(List<Kladr> list) {
        KladrResponse kladrResponse = objectFactory.createKladrResponse();
        List<com.emal.kladr.webservice.xml.Kladr> result = kladrResponse.getResult();
        for (Kladr kladr : list) {
            com.emal.kladr.webservice.xml.Kladr item = objectFactory.createKladr();
            BeanUtils.copyProperties(kladr, item);
            result.add(item);
        }
        return kladrResponse;
    }
}
