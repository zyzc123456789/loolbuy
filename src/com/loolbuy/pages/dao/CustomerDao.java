package com.loolbuy.pages.dao;

import org.springframework.stereotype.Repository;

import com.loolbuy.common.model.CustomerDto;

@Repository
public class CustomerDao {

    public CustomerDto queryUserByAccount(String userNm)
    {
        CustomerDto cust = new CustomerDto();
        cust.setId(1);
        cust.setUserNm(userNm);
        cust.setPassword("111111");
        cust.setMailAddress("315172009@qq.com");
        cust.setPhoneNo("17705142966");
        return cust;
    }

}
