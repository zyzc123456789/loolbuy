package com.loolbuy.pages.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.loolbuy.common.model.CustomerDto;
import com.loolbuy.global.jdbc.SqlExecutor;

@Repository
public class CustomerDao {

    @Autowired
    public SqlExecutor sqlExecutor;
    
    public CustomerDto queryUserByAccount(String userNm)
    {
        String sql = "SELECT * FROM customer WHERE userNm=:userNm";
        Map<String ,Object> params = new HashMap<String, Object>();
        params.put("userNm", userNm);
        return sqlExecutor.queryForObject(sql, params,CustomerDto.class);
    }

}
