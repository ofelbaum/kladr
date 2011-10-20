package com.app.dao.impl;

import com.app.dao.AbstractDaoImpl;
import com.app.dao.KladrDao;
import com.app.domain.Kladr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: admin
 * Date: 15.10.11 22:22
 */
@Component
public class KladrDaoImpl extends AbstractDaoImpl<Kladr> implements KladrDao{
    private static final Logger log = LoggerFactory.getLogger(KladrDaoImpl.class);

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
