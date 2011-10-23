package com.emal.kladr.dao;

import com.emal.kladr.domain.EntityMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * User: admin
 * Date: 19.10.11 23:44
 */
public abstract class AbstractDaoImpl<T extends EntityMetadata> implements BaseDao<T> {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    protected abstract String getDaoTable();

    protected abstract RowMapper<T> getRowMapper();

    @Override
    public List<T> findAll() {
        String sql = "SELECT * FROM " + getDaoTable() + ";";
        return jdbcTemplate.query(sql, getRowMapper());
    }

    @Override
    public void insert(List<T> ts) {
        List<String> batch = new ArrayList<String>();
        for (T t : ts) {
            String command = createInsertQuery(t);
            batch.add(command);
        }

        jdbcTemplate.batchUpdate(convert(batch));
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.execute("delete from " + getDaoTable() + ";");
    }

    @Override
    public T getByCode(String code) {
        Assert.hasText(code);
        List<T> results = jdbcTemplate.query("select * from " + getDaoTable() + " where code='" + code + "';", getRowMapper());
        if (results.size() != 1) {
            throw new IllegalStateException("Not unique result for code [" + code + "]");
        }
        return results.get(0);
    }

    private String[] convert(List<String> list) {
        int size = list.size();
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private String createInsertQuery(T entity) {
        StringBuffer query = new StringBuffer("INSERT INTO ")
                .append(entity.getTableName())
                .append(" VALUES (");

        Object[] values = entity.getValues();
        int size = values.length;
        for (int i = 0; i < size; i++) {
            Object value = values[i];
            query.append("'")
                    .append(value.toString().trim())
                    .append("'");
            if (i < size - 1) {
                query.append(",");
            }
        }
        query.append(");");
        return query.toString();
    }
}
