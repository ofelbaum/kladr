package com.emal.kladr.domain;

/**
 * User: admin
 * Date: 20.10.11 0:01
 */
public abstract class EntityMetadata {

    protected Integer id;

    public abstract String getTableName();
    public abstract Object[] getValues();

    protected EntityMetadata() {
    }

    protected EntityMetadata(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
