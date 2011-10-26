package com.emal.kladr.dao.impl;

import com.emal.kladr.dao.AbstractDaoImpl;
import com.emal.kladr.dao.DomDao;
import com.emal.kladr.domain.Dom;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: alexey.emelyanenko@gmail.com
 * Date: 10/27/11 1:35 AM
 */
@Component
public class DomDaoImpl extends AbstractDaoImpl<Dom> implements DomDao {
    @Override
    protected String getDaoTable() {
        return Dom.tableName;
    }

    @Override
    protected RowMapper<Dom> getRowMapper() {
        return new RowMapper<Dom>() {
            @Override
            public Dom mapRow(ResultSet rs, int rowIndex) throws SQLException {
                return Dom.build(convertResultSet(rs));
            }
        };
    }

    @Override
    protected Dom buildEntity(Object[] rowObjects) {
        return Dom.build(rowObjects);
    }
}
