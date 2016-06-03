package com.loolbuy.security;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.loolbuy.common.model.CustomerDto;
import com.loolbuy.global.security.AbstractAuthenticatingRealm;
import com.loolbuy.pages.logic.CustomerLogic;

public class Realm extends AbstractAuthenticatingRealm<CustomerDto>
{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Realm.class);

    /**
     * 客户相关业务逻辑
     */
    @Autowired
    private CustomerLogic customerLogic;
    
    @Override
    protected String getStoredPrincipalPassword(CustomerDto user)
    {
        String password = user.getPassword();
        return password;
    }

    @Override
    protected CustomerDto getStoredPrincipal(UsernamePasswordToken token)  {
        
        return customerLogic.queryUserByAccount(token.getUsername());
    }

}
