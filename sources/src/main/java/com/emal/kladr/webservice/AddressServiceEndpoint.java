package com.emal.kladr.webservice;

import com.emal.kladr.domain.Building;
import com.emal.kladr.domain.Kladr;
import com.emal.kladr.domain.Street;
import com.emal.kladr.service.AddressService;
import com.emal.kladr.webservice.xml.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StreetRequest")
    @ResponsePayload
    public StreetResponse handleStreetRequest(@RequestPayload StreetRequest streetRequest)
            throws Exception {

        List<Street> list;
        String nameStartWith = streetRequest.getNameStartWith();
        if (StringUtils.hasText(nameStartWith)) {
            list = addressService.getStreets(streetRequest.getRegion(), streetRequest.getDistrict(), streetRequest.getLocality(), nameStartWith);
        } else {
            list = addressService.getStreets(streetRequest.getRegion(), streetRequest.getDistrict(), streetRequest.getLocality());
        }
        StreetResponse streetResponse = objectFactory.createStreetResponse();
        List<com.emal.kladr.webservice.xml.Street> result = streetResponse.getResult();
        for (com.emal.kladr.domain.Street street : list) {
            com.emal.kladr.webservice.xml.Street item = objectFactory.createStreet();
            BeanUtils.copyProperties(street, item);
            result.add(item);
        }
        return streetResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "BuildingRequest")
    @ResponsePayload
    public BuildingResponse handleBuildingRequest(@RequestPayload BuildingRequest buildingRequest)
            throws Exception {

        List<Building> list = addressService.getBuildings(buildingRequest.getRegion(), buildingRequest.getDistrict(), buildingRequest.getLocality(), buildingRequest.getStreet());
        BuildingResponse buildingResponse = objectFactory.createBuildingResponse();
        List<com.emal.kladr.webservice.xml.Building> result = buildingResponse.getResult();
        for (Building building : list) {
            com.emal.kladr.webservice.xml.Building item = objectFactory.createBuilding();
            BeanUtils.copyProperties(building, item);
            result.add(item);
        }
        return buildingResponse;
    }
}
