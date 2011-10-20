package com.app.xml;

import com.app.webservice.HolidayEndpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: admin
 * Date: 14.10.11 0:17
 */
@XmlRootElement(name = HolidayEndpoint.NAME, namespace = HolidayEndpoint.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class HolidayRequest {

    @XmlElement(name = "holiday", namespace = HolidayEndpoint.NAMESPACE_URI)
    private HolidayType holiday;

    @XmlElement(name = "employee", namespace = HolidayEndpoint.NAMESPACE_URI)
    private EmployeeType employee;


    public HolidayType getHoliday() {
        return holiday;
    }

    public void setHoliday(HolidayType holiday) {
        this.holiday = holiday;
    }


    public EmployeeType getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeType employee) {
        this.employee = employee;
    }
}
