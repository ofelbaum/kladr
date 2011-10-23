package com.emal.kladr.xml;

import com.emal.kladr.webservice.HolidayEndpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * User: admin
 * Date: 14.10.11
 */
@XmlType(name = "employee", namespace = HolidayEndpoint.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeType {

    @XmlElement(name = "number", namespace = HolidayEndpoint.NAMESPACE_URI)
    private Integer number;

    @XmlElement(name = "firstName", namespace = HolidayEndpoint.NAMESPACE_URI)
    private String firstName;

    @XmlElement(name = "lastName", namespace = HolidayEndpoint.NAMESPACE_URI)
    private String lastName;


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
