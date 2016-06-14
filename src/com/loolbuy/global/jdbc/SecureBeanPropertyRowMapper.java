package com.loolbuy.global.jdbc;

import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.support.JdbcUtils;

class SecureBeanPropertyRowMapper<T> extends
    BeanPropertyRowMapper<T> {
    public SecureBeanPropertyRowMapper(Class<T> mappedClass) {
        super(mappedClass);
    }
    
    @Override
    protected Object getColumnValue(ResultSet rs, int index,
        PropertyDescriptor pd) throws SQLException {
        String name = JdbcUtils.lookupColumnName(rs.getMetaData(), index);
        Object value = super.getColumnValue(rs, index, pd);
        return EncryptFieldsManager.decryptIfNeed(name, value);
    }
}