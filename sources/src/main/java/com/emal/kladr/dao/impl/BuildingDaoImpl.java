package com.emal.kladr.dao.impl;

import com.emal.kladr.dao.AbstractDaoImpl;
import com.emal.kladr.dao.BuildingDao;
import com.emal.kladr.domain.Building;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: alexey.emelyanenko@gmail.com
 * Date: 10/27/11 1:35 AM
 */
@Component
public class BuildingDaoImpl extends AbstractDaoImpl<Building> implements BuildingDao {
    @Override
    protected String getDaoTable() {
        return Building.tableName;
    }

    @Override
    protected RowMapper<Building> getRowMapper() {
        return new RowMapper<Building>() {
            @Override
            public Building mapRow(ResultSet rs, int rowIndex) throws SQLException {
                return Building.build(convertResultSet(rs));
            }
        };
    }

    @Override
    protected Building buildEntity(Object[] rowObjects) {
        return Building.build(rowObjects);
    }
}
