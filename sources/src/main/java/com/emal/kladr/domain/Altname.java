package com.emal.kladr.domain;

/**
 * User: admin
 * Date: 19.10.11 23:30
 */
public class Altname extends EntityMetadata {
    public static final String tableName = "ALTNAMES";
    private static final String[] COLUMNS = new String[]{"id", "oldCode", "newCode", "level"};

    private String oldCode;
    private String newCode;
    private String level;

    public Altname() {
    }

    public Altname(String oldCode, String newCode, String level) {
        this.oldCode = oldCode;
        this.newCode = newCode;
        this.level = level;
    }

    public Altname(Long id, String oldCode, String newCode, String level) {
        super(id);
        this.oldCode = oldCode;
        this.newCode = newCode;
        this.level = level;
    }

    public String getOldCode() {
        return oldCode;
    }

    public void setOldCode(String oldCode) {
        this.oldCode = oldCode;
    }

    public String getNewCode() {
        return newCode;
    }

    public void setNewCode(String newCode) {
        this.newCode = newCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public Object[] getValues() {
        return new Object[]{id, oldCode, newCode, level};
    }

    public static Altname build(Object[] rowObjects) {
        if (rowObjects.length != Altname.COLUMNS.length) {
            throw new IllegalArgumentException("Wrong column number");
        }
        Long id = (Long) rowObjects[0];
        String oldCode = (String) rowObjects[1];
        String newCode = (String) rowObjects[2];
        String level = (String) rowObjects[3];
        return new Altname(id, oldCode, newCode, level);
    }
}
