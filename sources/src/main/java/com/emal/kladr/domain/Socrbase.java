package com.emal.kladr.domain;

/**
 * User: admin
 * Date: 19.10.11 23:30
 */
public class Socrbase extends EntityMetadata{
    public static final String tableName = "SOCRBASE";
    private static final String[] COLUMNS = new String[]{"id", "level", "scname", "socrname", "kod_t_st"};

    private String level;
    private String scname;
    private String socrname;
    private String kod_t_st;

    public Socrbase() {
    }

    public Socrbase(String level, String scname, String socrname, String kod_t_st) {
        this.level = level;
        this.scname = scname;
        this.socrname = socrname;
        this.kod_t_st = kod_t_st;
    }

    public Socrbase(Long id, String level, String scname, String socrname, String kod_t_st) {
        super(id);
        this.level = level;
        this.scname = scname;
        this.socrname = socrname;
        this.kod_t_st = kod_t_st;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
    }

    public String getSocrname() {
        return socrname;
    }

    public void setSocrname(String socrname) {
        this.socrname = socrname;
    }

    public String getKod_t_st() {
        return kod_t_st;
    }

    public void setKod_t_st(String kod_t_st) {
        this.kod_t_st = kod_t_st;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public Object[] getValues() {
        return new Object[]{id, level, scname, socrname, kod_t_st};
    }

    public static Socrbase build(Object[] rowObjects) {
        if (rowObjects.length != Socrbase.COLUMNS.length) {
            throw new IllegalArgumentException("Wrong column number");
        }
        Long id = (Long) rowObjects[0];
        String level = (String) rowObjects[1];
        String scname = (String) rowObjects[2];
        String socrname = (String) rowObjects[3];
        String kod_t_st = (String) rowObjects[4];
        return new Socrbase(id, level, scname, socrname, kod_t_st);
    }
}
