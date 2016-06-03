package com.loolbuy.pages.logic;

import org.springframework.stereotype.Component;

import com.loolbuy.common.model.CustomerDto;

@Component
public class CustomerLogic
{
    /**
     * 查询用户
     * 
     * @param  userNm
     * 
     * @return 用户信息
     */
    public CustomerDto queryUserByAccount(String userNm) {
        CustomerDto cust = new CustomerDto();
        cust.setId(1);
        cust.setUserNm(userNm);
        cust.setPassword("111111");
        cust.setMailAddress("315172009@qq.com");
        cust.setPhoneNo("17705142966");
        
        return null;
    }
}
