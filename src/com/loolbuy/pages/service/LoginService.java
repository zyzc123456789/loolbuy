package com.loolbuy.pages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.loolbuy.common.model.CustomerDto;
import com.loolbuy.common.model.ResponseModel;
import com.loolbuy.global.util.MessageCode;
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
    
    /**
     * 登录认证后处理返回给客户端的信息
     * 
     * @param exception 例外信息
     * @param errorCount 错误次数
     * 
     * @return  <br>
     *          SUCCESS  <br>
     *          E0041 图像验证码不正确（返回是否需要出验证码的标记）  <br>
     *          E0045 图像验证码没输入（返回是否需要出验证码的标记）  <br>
     *          E0042 本日的认证错误次数已经达到上限（返回是否需要出验证码的标记）  <br>
     *          E0043 账户不存在或者已经被停用/登录密码不正确 （返回是否需要出验证码的标记）  <br>
     *          E0044 其他错误（返回是否需要出验证码的标记） 
     */
    public ResponseModel afterLoginAuth(String exception, int errorCount)
    {
        // 认证通过
        if (StringUtils.isEmpty(exception))
        {
            return ResponseModel.success();
        }

        // 其他错误
        return ResponseModel.failure(1, MessageCode.E0001);
    }
}

