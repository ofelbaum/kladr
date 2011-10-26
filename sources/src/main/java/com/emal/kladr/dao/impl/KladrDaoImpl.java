package com.emal.kladr.dao.impl;

import com.emal.kladr.dao.AbstractDaoImpl;
import com.emal.kladr.dao.KladrDao;
import com.emal.kladr.domain.Kladr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * User: admin
 * Date: 15.10.11 22:22
 */
@Component
public class KladrDaoImpl extends AbstractDaoImpl<Kladr> implements KladrDao {
    private static final Logger log = LoggerFactory.getLogger(KladrDaoImpl.class);

    @Override
    public List<Kladr> getRegions() {
        String sql = "select * from " + getDaoTable() + " where code like '%00000000000' order by name ASC;";
        log.debug("Query [ " + sql +" ]");
        List<Kladr> list = jdbcTemplate.query(sql, getRowMapper());
        log.debug("Result set size [ " + list.size() + " ]");
        return list;
    }

    @Override
    public List<Kladr> getDistricts(String subject) {
        String sql = "select * from " + getDaoTable() + " where code like '" + subject + "%00000000' and code != '"+subject +"00000000000' order by name ASC;";
        log.debug("Query [ " + sql +" ]");
        List<Kladr> list = jdbcTemplate.query(sql, getRowMapper());
        log.debug("Result set size [ " + list.size() + " ]");
        return list;
    }

    @Override
    public List<Kladr> getLocalities(String subject, String district) {
        String sql = "select * from " + getDaoTable() + " where code like '" + subject + district + "%00' and code != '" + subject + "000%00' order by name ASC;";
        log.debug("Query [ " + sql +" ]");
        List<Kladr> list = jdbcTemplate.query(sql, getRowMapper());
        log.debug("Result set size [ " + list.size() + " ]");
        return list;
    }

    @Override
    protected String getDaoTable() {
        return Kladr.tableName;
    }


    @Override
    protected Kladr buildEntity(Object[] rowObjects) {
        return Kladr.build(rowObjects);
    }

    @Override
    protected RowMapper<Kladr> getRowMapper() {
        return new RowMapper<Kladr>() {
            @Override
            public Kladr mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Kladr.build(convertResultSet(rs));
            }
        };
    }
}
