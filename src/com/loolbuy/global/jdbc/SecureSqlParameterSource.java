package com.loolbuy.global.jdbc;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;

class SecureSqlParameterSource implements SqlParameterSource {

    private final SqlParameterSource org;

    public SecureSqlParameterSource(SqlParameterSource org) {
        this.org = org;
    }

    @Override
    public boolean hasValue(String paramName) {
        return org.hasValue(paramName);
    }

    @Override
    public Object getValue(String paramName)
            throws IllegalArgumentException {
        Object value = org.getValue(paramName);

        return EncryptFieldsManager.encryptIfNeed(paramName, value);
    }

    @Override
    public int getSqlType(String paramName) {
        return org.getSqlType(paramName);
    }

    @Override
    public String getTypeName(String paramName) {
        return org.getTypeName(paramName);
    }

    

}