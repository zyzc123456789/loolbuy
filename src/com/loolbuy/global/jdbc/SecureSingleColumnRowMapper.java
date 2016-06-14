package com.loolbuy.global.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.support.JdbcUtils;

class SecureSingleColumnRowMapper<T> extends SingleColumnRowMapper<T> {
    public SecureSingleColumnRowMapper(Class<T> requiredType) {
        super(requiredType);
    }

    @Override
    protected Object getColumnValue(ResultSet rs, int index,
            Class<?> requiredType) throws SQLException {
        String name = JdbcUtils.lookupColumnName(rs.getMetaData(), index);
        Object value = super.getColumnValue(rs, index, requiredType);
        return EncryptFieldsManager.decryptIfNeed(name, value);
    }

    @Override
    protected Object getColumnValue(ResultSet rs, int index)
            throws SQLException {
        String name = JdbcUtils.lookupColumnName(rs.getMetaData(), index);
        Object value = super.getColumnValue(rs, index);
        return EncryptFieldsManager.decryptIfNeed(name, value);
    }
    
    
}