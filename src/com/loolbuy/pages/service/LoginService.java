package com.loolbuy.pages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loolbuy.common.model.CustomerDto;
import com.loolbuy.pages.logic.CustomerLogic;
import com.loolbuy.pages.logic.LoginLogic;

@Service
public class LoginService
{
    /**
     * 登录相关业务逻辑
     */
    @Autowired
    private LoginLogic loginLogic;

    /**
     * 客户相关业务逻辑
     */
    @Autowired
    private CustomerLogic customerLogic;
    
    /**
     * 登录成功后处理
     * 
     * @param 客户信息 customer
     */
    public void loginSucess(CustomerDto user) {

 
        // 登录成功后处理
        loginLogic.loginSuccess(user);
    }
}
