package com.emal.kladr.xml;

import com.emal.kladr.webservice.HolidayEndpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * User: alexey.emelyanenko@gmail.com
 * Date: 24.10.11 1:29
 */
@XmlType(name = HolidayEndpoint.KLADR_REQUEST, namespace = HolidayEndpoint.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class KladrRequest {

    @XmlElement
    private String codePrefix;

    public String getCodePrefix() {
        return codePrefix;
    }

    public void setCodePrefix(String codePrefix) {
        this.codePrefix = codePrefix;
    }
}
