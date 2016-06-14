package com.loolbuy.global.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.loolbuy.common.model.CustomerDto;
import com.loolbuy.pages.logic.CustomerLogic;
import com.loolbuy.pages.logic.LoginLogic;

public class Realm extends AbstractAuthenticatingRealm<CustomerDto>
{
    @Autowired
    public LoginLogic loginLogic;

    @Autowired
    public CustomerLogic customerLogic;

    /**
     * 用户登录时的认证处理，通过的场合返回用户情报，否则抛出例外 <br>
     * UnknownAccountException: 账户不存在或者已经被停用 <br>
     * ExcessiveAttemptsException: 本日的认证错误次数已经达到上限 <br>
     * EmptyCaptchaException: 图像验证码没输入 <br>
     * IncorrectCaptchaException: 图像验证码不正确 <br>
     * IncorrectCredentialsException: 登录密码不正确
     */
    @Override
    protected CustomerDto authenticatePrincipal(CaptchaUsernamePasswordToken token) throws AuthenticationException
    {

        String userNm = token.getUsername();

        CustomerDto customer = customerLogic.queryUserByAccount(userNm);
//        // 账户不存在或者状态不是启用的场合
//        if (!customerLogic.isCustomerAvailable(customer))
//        {
//            throw new UnknownAccountException();
//        }
//
//        int todayErrorCount = loginLogic.getTodayLoginErrorInfo(phone);
//
//        // 本日的认证错误次数已经达到上限
//        if (todayErrorCount >= Constant.MAX_LOGIN_ATTEMPT_COUNT)
//        {
//            throw new ExcessiveAttemptsException();
//        }
//
//        // 需要有图像验证码的场合，验证图像验证码
//        if (todayErrorCount >= Constant.MAX_LOGIN_ATTEMPT_COUNT_WITHOUT_CAPTCHA)
//        {
//            if(StringUtils.isEmpty(token.getCaptcha()))
//            {
//                throw new EmptyCaptchaException();
//            }
//            
//            if (!loginLogic.isImageAuthCodeCorrect(token.getCaptcha()))
//            {
//                throw new IncorrectCaptchaException();
//            }
//        }
//
//        if (!customer.getPassword().equals(new String(token.getPassword())))
//        {
//            throw new IncorrectCredentialsException();
//        }
//
//        logger.info("验证通过");

        return customer;
    }


}
