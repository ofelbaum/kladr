package com.emal.kladr.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * User: admin
 * Date: 19.10.11 23:29
 * <p/>
 * Структура кодового обозначения в блоке "Код":
 * СС РРР ГГГ ППП УУУУ АА, где
 * СС – код субъекта Российской Федерации (региона), коды регионов представлены в Приложении 2 к Описанию классификатора адресов Российской Федерации (КЛАДР);
 * РРР – код района;
 * ГГГ – код города;
 * ППП – код населенного пункта;
 * УУУУ – код улицы;
 * АА – признак актуальности наименования адресного объекта.
 */
public class Street extends EntityMetadata{
    public static final String tableName = "STREET";
    private static final String[] COLUMNS = new String[]{"id", "name", "socr", "code", "postIndex", "gninmb", "uno", "ocatd"};

    private String name;
    private String socr;
    private String code;
    private String postIndex;
    private String gninmb;
    private String uno;
    private String ocatd;

    public Street() {
    }

    public Street(String name, String socr, String code, String postIndex, String gninmb, String uno, String ocatd) {
        this.name = name;
        this.socr = socr;
        this.code = code;
        this.postIndex = postIndex;
        this.gninmb = gninmb;
        this.uno = uno;
        this.ocatd = ocatd;
    }

    public Street(Integer id, String name, String socr, String code, String postIndex, String gninmb, String uno, String ocatd) {
        super(id);
        this.name = name;
        this.socr = socr;
        this.code = code;
        this.postIndex = postIndex;
        this.gninmb = gninmb;
        this.uno = uno;
        this.ocatd = ocatd;
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

    @Override
    @JsonIgnore
    public String getTableName() {
        return tableName;
    }

    @Override
    @JsonIgnore
    public Object[] getValues() {
        return new Object[]{id, name, socr, code, postIndex, gninmb, uno, ocatd};
    }

    @Override
    @JsonIgnore
    public String toString() {
        return new StringBuffer(name)
                .append(" ")
                .append(socr)
                .toString();
    }

    public static Street build(Object[] rowObjects) {
        if (rowObjects.length != Street.COLUMNS.length) {
            throw new IllegalArgumentException("Wrong column number");
        }
        Integer id = (Integer) rowObjects[0];
        String name = (String) rowObjects[1];
        String socr = (String) rowObjects[2];
        String code = (String) rowObjects[3];
        String postIndex = (String) rowObjects[4];
        String gninmb = (String) rowObjects[5];
        String uno = (String) rowObjects[6];
        String ocatd = (String) rowObjects[7];
        return new Street(id, name, socr, code, postIndex, gninmb, uno, ocatd);
    }
}
