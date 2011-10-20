package com.app.domain;

/**
 * User: admin
 * Date: 19.10.11 23:29
 */
public class Kladr extends EntityMetadata{
    private String name;
    private String socr;
    private String code;
    private String postIndex;
    private String gninmb;
    private String uno;
    private String ocatd;
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
    public String getTableName() {
        return "KLADR";
    }

    @Override
    public String[] getColumns() {
        return new String[]{"name", "socr", "code", "postIndex", "gninmb", "uno", "ocatd", "status"};
    }

    @Override
    public Object[] getValues() {
        return new String[]{name, socr, code, postIndex, gninmb, uno, ocatd, status};
    }
}
