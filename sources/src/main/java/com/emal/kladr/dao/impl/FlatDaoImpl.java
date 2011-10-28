package com.emal.kladr.dao.impl;

import com.emal.kladr.dao.AbstractDaoImpl;
import com.emal.kladr.dao.FlatDao;
import com.emal.kladr.domain.Flat;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: alexey.emelyanenko@gmail.com
 * Date: 10/28/11 12:07 AM
 */
@Component
public class FlatDaoImpl extends AbstractDaoImpl<Flat> implements FlatDao{
    @Override
    protected String getDaoTable() {
        return Flat.tableName;
    }

    @Override
    protected RowMapper<Flat> getRowMapper() {
        return new RowMapper<Flat>() {
            @Override
            public Flat mapRow(ResultSet rs, int rowIndex) throws SQLException {
                return Flat.build(convertResultSet(rs));
            }
        };
    }

    @Override
    protected Flat buildEntity(Object[] rowObjects) {
        return Flat.build(rowObjects);
    }
}
