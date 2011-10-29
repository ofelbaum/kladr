package com.emal.kladr.domain;

/**
 * User: admin
 * Date: 19.10.11 23:29
 * Структура кодового обозначения в блоке "Код":
 * СС РРР ГГГ ППП УУУУ ДДДД, где
 * СС – код субъекта Российской Федерации (региона), коды регионов представлены в Приложении 2 к Описанию классификатора адресов Российской Федерации (КЛАДР);
 * РРР – код района;
 * ГГГ – код города;
 * ППП – код населенного пункта;
 * УУУУ – код улицы (если адрес не содержит наименования улицы, т.е. дома привязаны непосредственно к городу или населенному пункту, то код улицы будет содержать нули – 0000);
 * ДДДД – порядковый номер позиции классификатора с обозначениями домов.
 */
public class Dom extends EntityMetadata{
    public static final String tableName = "DOMA";
    private static final String[] COLUMNS = new String[]{"id", "name", "korp", "socr", "code", "postIndex", "gninmb", "uno", "ocatd"};

    private String name;
    private String korp;
    private String socr;
    private String code;
    private String postIndex;
    private String gninmb;
    private String uno;
    private String ocatd;

    public Dom() {
    }

    public Dom(String name, String korp, String socr, String code, String postIndex, String gninmb, String uno, String ocatd) {
        this.name = name;
        this.korp = korp;
        this.socr = socr;
        this.code = code;
        this.postIndex = postIndex;
        this.gninmb = gninmb;
        this.uno = uno;
        this.ocatd = ocatd;
    }

    public Dom(Integer id, String name, String korp, String socr, String code, String postIndex, String gninmb, String uno, String ocatd) {
        super(id);
        this.name = name;
        this.korp = korp;
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

    public String getKorp() {
        return korp;
    }

    public void setKorp(String korp) {
        this.korp = korp;
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
    public String getTableName() {
        return tableName;
    }

    @Override
    public Object[] getValues() {
        return new Object[]{id, name, korp, socr, code, postIndex, gninmb, uno, ocatd};
    }

    public static Dom build(Object[] rowObjects) {
        if (rowObjects.length != Dom.COLUMNS.length) {
            throw new IllegalArgumentException("Wrong column number");
        }
        Integer id = (Integer) rowObjects[0];
        String name = (String) rowObjects[1];
        String korp = (String) rowObjects[2];
        String socr = (String) rowObjects[3];
        String code = (String) rowObjects[4];
        String postIndex = (String) rowObjects[5];
        String gninmb = (String) rowObjects[6];
        String uno = (String) rowObjects[7];
        String ocatd = (String) rowObjects[8];
        return new Dom(id, name, korp, socr, code, postIndex, gninmb, uno, ocatd);
    }
}
