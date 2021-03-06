
package com.emal.kladr.webservice.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="region" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="district" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="locality" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameStartWith" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "region",
    "district",
    "locality",
    "nameStartWith"
})
@XmlRootElement(name = "StreetRequest", namespace = "http://emal.com/kladr/schemas")
public class StreetRequest {

    @XmlElement(namespace = "http://emal.com/kladr/schemas", required = true)
    protected String region;
    @XmlElement(namespace = "http://emal.com/kladr/schemas", required = true)
    protected String district;
    @XmlElement(namespace = "http://emal.com/kladr/schemas", required = true)
    protected String locality;
    @XmlElement(namespace = "http://emal.com/kladr/schemas", required = true, nillable = true)
    protected String nameStartWith;

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the district property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrict(String value) {
        this.district = value;
    }

    /**
     * Gets the value of the locality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocality() {
        return locality;
    }

    /**
     * Sets the value of the locality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocality(String value) {
        this.locality = value;
    }

    /**
     * Gets the value of the nameStartWith property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameStartWith() {
        return nameStartWith;
    }

    /**
     * Sets the value of the nameStartWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameStartWith(String value) {
        this.nameStartWith = value;
    }

}
