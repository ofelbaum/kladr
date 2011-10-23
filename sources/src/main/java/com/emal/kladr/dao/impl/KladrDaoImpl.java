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
    public List<Kladr> getRFSubjects() {
        return jdbcTemplate.query("select * from " + getDaoTable() + " where code like '%00000000000' order by code ASC;", getRowMapper());
    }

    @Override
    protected String getDaoTable() {
        return "KLADR";
    }

    @Override
    protected RowMapper<Kladr> getRowMapper() {
        return new RowMapper<Kladr>() {
            @Override
            public Kladr mapRow(ResultSet rs, int rowNum) throws SQLException {
                if (rs.getMetaData().getColumnCount() != 8) {
                    throw new IllegalArgumentException("Wrong column number");
                }
                String name = rs.getString(1);
                String socr = rs.getString(2);
                String code = rs.getString(3);
                String postIndex = rs.getString(4);
                String gninmb = rs.getString(5);
                String uno = rs.getString(6);
                String ocatd = rs.getString(7);
                String status = rs.getString(8);
                return new Kladr(name, socr, code, postIndex, gninmb, uno, ocatd, status);
            }
        };
    }
}
