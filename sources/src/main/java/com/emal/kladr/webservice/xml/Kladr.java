//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.11.02 at 01:20:07 AM MSK 
//


package com.emal.kladr.webservice.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Kladr complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Kladr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="socr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gninmb" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ocatd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Kladr", propOrder = {
    "name",
    "socr",
    "code",
    "postIndex",
    "gninmb",
    "uno",
    "ocatd",
    "status"
})
public class Kladr {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String socr;
    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String postIndex;
    @XmlElement(required = true)
    protected String gninmb;
    @XmlElement(required = true)
    protected String uno;
    @XmlElement(required = true)
    protected String ocatd;
    @XmlElement(required = true)
    protected String status;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the socr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSocr() {
        return socr;
    }

    /**
     * Sets the value of the socr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSocr(String value) {
        this.socr = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the postIndex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostIndex() {
        return postIndex;
    }

    /**
     * Sets the value of the postIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostIndex(String value) {
        this.postIndex = value;
    }

    /**
     * Gets the value of the gninmb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGninmb() {
        return gninmb;
    }

    /**
     * Sets the value of the gninmb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGninmb(String value) {
        this.gninmb = value;
    }

    /**
     * Gets the value of the uno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUno() {
        return uno;
    }

    /**
     * Sets the value of the uno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUno(String value) {
        this.uno = value;
    }

    /**
     * Gets the value of the ocatd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOcatd() {
        return ocatd;
    }

    /**
     * Sets the value of the ocatd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOcatd(String value) {
        this.ocatd = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}