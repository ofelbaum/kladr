package com.emal.kladr.dao.impl;

import com.emal.kladr.dao.AbstractDaoImpl;
import com.emal.kladr.dao.SocrbaseDao;
import com.emal.kladr.domain.Socrbase;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: alexey.emelyanenko@gmail.com
 * Date: 10/28/11 12:16 AM
 */
@Component
public class SocrbaseDaoImpl extends AbstractDaoImpl<Socrbase> implements SocrbaseDao{
    @Override
    protected String getDaoTable() {
        return Socrbase.tableName;
    }

    @Override
    protected RowMapper<Socrbase> getRowMapper() {
        return new RowMapper<Socrbase>() {
            @Override
            public Socrbase mapRow(ResultSet rs, int rowIndex) throws SQLException {
                return Socrbase.build(convertResultSet(rs));
            }
        };
    }

    @Override
    protected Socrbase buildEntity(Object[] rowObjects) {
        return Socrbase.build(rowObjects);
    }
}
