package com.emal.kladr.domain;


/**
 * User: admin
 * Date: 19.10.11 23:29
 */
public class Flat extends EntityMetadata{
    public static final String tableName = "FLAT";
    private static final String[] COLUMNS = new String[]{"id", "name", "code", "postIndex", "gninmb", "uno", "np"};

    private String name;
    private String code;
    private String postIndex;
    private String gninmb;
    private String uno;
    private String np;

    public Flat() {
    }

    public Flat(String name, String code, String postIndex, String gninmb, String uno, String np) {
        this.name = name;
        this.code = code;
        this.postIndex = postIndex;
        this.gninmb = gninmb;
        this.uno = uno;
        this.np = np;
    }

    public Flat(Long id, String name, String code, String postIndex, String gninmb, String uno, String np) {
        super(id);
        this.name = name;
        this.code = code;
        this.postIndex = postIndex;
        this.gninmb = gninmb;
        this.uno = uno;
        this.np = np;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNp() {
        return np;
    }

    public void setNp(String np) {
        this.np = np;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public Object[] getValues() {
        return new Object[]{id, name, code, postIndex, gninmb, uno, np};
    }

    public static Flat build(Object[] rowObjects) {
        if (rowObjects.length != Flat.COLUMNS.length) {
            throw new IllegalArgumentException("Wrong column number");
        }
        Long id = (Long) rowObjects[0];
        String name = (String) rowObjects[1];
        String code = (String) rowObjects[2];
        String postIndex = (String) rowObjects[3];
        String gninmb = (String) rowObjects[4];
        String uno = (String) rowObjects[5];
        String np = (String) rowObjects[6];
        return new Flat(id, name, code, postIndex, gninmb, uno, np);
    }
}
