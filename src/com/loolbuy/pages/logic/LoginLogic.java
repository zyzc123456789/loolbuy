package com.loolbuy.pages.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loolbuy.common.core.Constant;
import com.loolbuy.common.model.CustomerDto;
import com.loolbuy.global.security.SessionManager;
import com.loolbuy.pages.dao.CustomerDao;

@Component
public class LoginLogic
{
    @Autowired
    private CustomerDao customerDao;
    /**
     * 登录成功后处理
     * 
     */
    public void loginSuccess(CustomerDto customer) {
        // 用户信息
        customer = customerDao.queryUserByAccount(customer.getUserNm());
        
        // 设定Session
        SessionManager.set(Constant.SESSIONKEY_USER, customer);
 
    }

}
