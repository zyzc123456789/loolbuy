package com.loolbuy.common.model.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomerEntity implements Serializable
{
    private Integer id;
    private String userNm;
    private String password;
    private String phoneNo;
    private String mailAddress;
    private String createTime;
    private String updateTime;
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getUserNm()
    {
        return userNm;
    }
    public void setUserNm(String userNm)
    {
        this.userNm = userNm;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPhoneNo()
    {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo = phoneNo;
    }
    public String getMailAddress()
    {
        return mailAddress;
    }
    public void setMailAddress(String mailAddress)
    {
        this.mailAddress = mailAddress;
    }
    public String getCreateTime()
    {
        return createTime;
    }
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    public String getUpdateTime()
    {
        return updateTime;
    }
    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }
    
}
