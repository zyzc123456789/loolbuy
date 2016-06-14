package com.loolbuy.pages.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loolbuy.common.model.CustomerDto;
import com.loolbuy.pages.dao.CustomerDao;

@Component
public class CustomerLogic
{
    @Autowired
    public CustomerDao customerDao;
    /**
     * 查询用户
     * 
     * @param  userNm
     * 
     * @return 用户信息
     */
    public CustomerDto queryUserByAccount(String userNm) {
        return customerDao.queryUserByAccount(userNm);
    }
}
