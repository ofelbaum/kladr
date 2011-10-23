package com.emal.kladr.dao;

import com.emal.kladr.domain.EntityMetadata;

import java.util.List;

/**
 * User: admin
 * Date: 19.10.11 23:43
 */
public interface BaseDao<T extends EntityMetadata> {
    public List<T> findAll();
    public void insert(List<T> list);
    public void deleteAll();
    public T getByCode(String code);
    public List<T> getListByCode(String codePrefix);
}
