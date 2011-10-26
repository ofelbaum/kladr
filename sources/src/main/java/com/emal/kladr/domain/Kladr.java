package com.emal.kladr.domain;

import com.emal.kladr.webservice.HolidayEndpoint;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * User: admin
 * Date: 19.10.11 23:29
 * Структура кодового обозначения в блоке "Код":
 * СС РРР ГГГ ППП АА, где
 * СС – код субъекта Российской Федерации (региона), коды регионов представлены в Приложении 2 к Описанию классификатора адресов Российской Федерации (КЛАДР);
 * РРР – код района;
 * ГГГ – код города;
 * ППП – код населенного пункта,
 * АА – признак актуальности адресного объекта.
 *
 */
@XmlType(name = "kladr", namespace = HolidayEndpoint.NAMESPACE_URI)
@XmlAccessorType(XmlAccessType.FIELD)
public class Kladr extends EntityMetadata{
    public static final Kladr EMPTY_VALUE = new Kladr("", "<<...>>", "0000000000000", "000000", "0000", "000", "000000", "00");
    public static final String tableName = "KLADR";
    private static final String[] COLUMNS = new String[]{"name", "socr", "code", "postIndex", "gninmb", "uno", "ocatd", "status"};

    @XmlElement(name = "name", namespace = HolidayEndpoint.NAMESPACE_URI)
    private String name;

    @XmlElement(name = "socr", namespace = HolidayEndpoint.NAMESPACE_URI)
    private String socr;

    @XmlElement(name = "code", namespace = HolidayEndpoint.NAMESPACE_URI)
    private String code;

    @XmlElement(name = "postIndex", namespace = HolidayEndpoint.NAMESPACE_URI)
    private String postIndex;

    @XmlElement(name = "gninmb", namespace = HolidayEndpoint.NAMESPACE_URI)
    private String gninmb;

    @XmlElement(name = "uno", namespace = HolidayEndpoint.NAMESPACE_URI)
    private String uno;

    @XmlElement(name = "ocatd", namespace = HolidayEndpoint.NAMESPACE_URI)
    private String ocatd;

    @XmlElement(name = "status", namespace = HolidayEndpoint.NAMESPACE_URI)
    private String status;

    public Kladr() {
    }

    public Kladr(String name, String socr, String code, String postIndex, String gninmb, String uno, String ocatd, String status) {
        this.name = name;
        this.socr = socr;
        this.code = code;
        this.postIndex = postIndex;
        this.gninmb = gninmb;
        this.uno = uno;
        this.ocatd = ocatd;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocr() {
        return socr;
    }

    public void setSocr(String socr) {
        this.socr = socr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public String getGninmb() {
        return gninmb;
    }

    public void setGninmb(String gninmb) {
        this.gninmb = gninmb;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getOcatd() {
        return ocatd;
    }

    public void setOcatd(String ocatd) {
        this.ocatd = ocatd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    @JsonIgnore
    public String getTableName() {
        return tableName;
    }

    @Override
    @JsonIgnore
    public Object[] getValues() {
        return new String[]{name, socr, code, postIndex, gninmb, uno, ocatd, status};
    }

    @Override
    @JsonIgnore
    public String toString() {
        return new StringBuffer(name)
                .append(" ")
                .append(socr).toString();
    }

    @JsonIgnore
    public String getRegion() {
        return code.substring(0, 2);
    }

    @JsonIgnore
    public String getDistrict() {
        return code.substring(2, 5);
    }

    @JsonIgnore
    public String getCity() {
        return code.substring(5, 8);
    }

    @JsonIgnore
    public String getCountry() {
        return code.substring(8, 11);
    }

    @JsonIgnore
    public String getLocality() {
        return code.substring(5, 11);
    }

    public static Kladr build(Object[] rowObjects) {
        if (rowObjects.length != Kladr.COLUMNS.length) {
            throw new IllegalArgumentException("Wrong column number");
        }
        String name = (String) rowObjects[0];
        String socr = (String) rowObjects[1];
        String code = (String) rowObjects[2];
        String postIndex = (String) rowObjects[3];
        String gninmb = (String) rowObjects[4];
        String uno = (String) rowObjects[5];
        String ocatd = (String) rowObjects[6];
        String status = (String) rowObjects[7];
        return new Kladr(name, socr, code, postIndex, gninmb, uno, ocatd, status);
    }
}
