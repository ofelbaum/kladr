package com.emal.kladr.domain;

/**
 * User: admin
 * Date: 20.10.11 0:01
 */
public abstract class EntityMetadata {

    protected Long id;

    public abstract String getTableName();
    public abstract Object[] getValues();

    protected EntityMetadata() {
    }

    protected EntityMetadata(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
