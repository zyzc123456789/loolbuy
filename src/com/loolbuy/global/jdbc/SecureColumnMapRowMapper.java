package com.loolbuy.global.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.support.JdbcUtils;

public class SecureColumnMapRowMapper extends ColumnMapRowMapper {
    @Override
    protected Object getColumnValue(ResultSet rs, int index)
            throws SQLException {
        String name = JdbcUtils.lookupColumnName(rs.getMetaData(), index);
        Object value = super.getColumnValue(rs, index);
        return EncryptFieldsManager.decryptIfNeed(name, value);
    }
}