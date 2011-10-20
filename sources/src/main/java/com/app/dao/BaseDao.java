package com.app.dao;

import com.app.domain.EntityMetadata;

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
}
