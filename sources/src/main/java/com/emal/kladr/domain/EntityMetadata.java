package com.emal.kladr.domain;

/**
 * User: admin
 * Date: 20.10.11 0:01
 */
public abstract class EntityMetadata {
    public abstract String getTableName();
    public abstract String[] getColumns();
    public abstract Object[] getValues();
}
