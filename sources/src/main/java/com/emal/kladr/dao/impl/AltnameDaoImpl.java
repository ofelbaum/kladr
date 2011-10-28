package com.emal.kladr.dao.impl;

import com.emal.kladr.dao.AbstractDaoImpl;
import com.emal.kladr.dao.AltnameDao;
import com.emal.kladr.domain.Altname;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: alexey.emelyanenko@gmail.com
 * Date: 10/27/11 11:03 PM
 */
@Component
public class AltnameDaoImpl extends AbstractDaoImpl<Altname> implements AltnameDao{
    @Override
    protected String getDaoTable() {
        return Altname.tableName;
    }

    @Override
    protected RowMapper<Altname> getRowMapper() {
        return new RowMapper<Altname>() {
            @Override
            public Altname mapRow(ResultSet rs, int rowIndex) throws SQLException {
                return Altname.build(convertResultSet(rs));
            }
        };
    }

    @Override
    protected Altname buildEntity(Object[] rowObjects) {
        return Altname.build(rowObjects);
    }
}
