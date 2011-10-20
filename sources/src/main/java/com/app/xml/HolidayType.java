package com.app.xml;

import com.app.webservice.HolidayEndpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * User: admin
 * Date: 14.10.11 0:16
 */
@XmlType(name = "holiday", namespace = HolidayEndpoint.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class HolidayType {

//    2005-06-30T19:30:00.000Z
    @XmlElement(name = "startDate", namespace = HolidayEndpoint.NAMESPACE_URI)
    private Date startDate;

    @XmlElement(namespace = HolidayEndpoint.NAMESPACE_URI)
    private Date endDate;


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
