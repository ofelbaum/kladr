package com.emal.kladr.dao.impl;

import com.emal.kladr.dao.AbstractDaoImpl;
import com.emal.kladr.dao.StreetDao;
import com.emal.kladr.domain.Street;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: alexey.emelyanenko@gmail.com
 * Date: 10/27/11 12:52 AM
 */
@Component
public class StreetDaoImpl extends AbstractDaoImpl<Street> implements StreetDao {
    private static final Logger log = LoggerFactory.getLogger(StreetDaoImpl.class);

    @Override
    protected String getDaoTable() {
        return Street.tableName;
    }

    @Override
    protected RowMapper<Street> getRowMapper() {
        return new RowMapper<Street>() {
            @Override
            public Street mapRow(ResultSet rs, int rowIndex) throws SQLException {
                return Street.build(convertResultSet(rs));
            }
        };
    }

    @Override
    protected Street buildEntity(Object[] rowObjects) {
        return Street.build(rowObjects);
    }
}
