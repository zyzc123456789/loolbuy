package com.loolbuy.global.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import sun.rmi.runtime.Log;

import com.loolbuy.common.model.CustomerDto;
import com.loolbuy.pages.service.LoginService;

public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter{

    
    @Autowired
    private LoginService loginService;
    
    private static final String DEFAULT_CAPTCHA_PARAM = "captcha";
    
    private String captchaParam = DEFAULT_CAPTCHA_PARAM;
    
    public String getCaptchaParam() {
        return captchaParam;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
            ServletResponse response)
    {
        increaseErrorCount();
        return super.onLoginFailure(token, e, request, response);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
            ServletResponse response) throws Exception
    {
        UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
        CustomerDto user = (CustomerDto)subject.getPrincipal();
        initUserAuthority(user);
        clearErrorCount();
        return super.onLoginSuccess(token, subject, request, response);
    }

    private void initUserAuthority(CustomerDto customerDto) {
        loginService.loginSucess(customerDto);
    }
    
    private void clearErrorCount()
    {
        SessionManager.remove(SessionManager.KEY_AUTH_ERROR_COUNT);
    }
    
    private void increaseErrorCount()
    {
        SessionManager.increase(SessionManager.KEY_AUTH_ERROR_COUNT);
    }
    
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception
    {
        try 
        {
            System.out.println("executeLogin");
            Subject subject = doLogin(request, response);
            return onLoginSuccess(null, subject, request, response);
        } 
        catch (AuthenticationException e) 
        {
            return onLoginFailure(null, e, request, response);
        }
    }
    
    protected Subject doLogin(ServletRequest request, ServletResponse response) throws AuthenticationException
    {
        CaptchaUsernamePasswordToken token = createCaptchaToken(request, response);
        doCaptchaValidate((HttpServletRequest) request, token);
        Subject subject = getSubject(request, response);
        subject.login(token);
        return subject; 
    }
    
    // 创建 Token
    private CaptchaUsernamePasswordToken createCaptchaToken(
            ServletRequest request, ServletResponse response) {

        String username = getUsername(request);
        String password = getPassword(request);
        String captcha = getCaptcha(request);
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);

        return new CaptchaUsernamePasswordToken(username, password, rememberMe,
                host, captcha);
    }
    
    private String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, getCaptchaParam());
    }
    
    // 验证码校验
    private void doCaptchaValidate(HttpServletRequest request,
            CaptchaUsernamePasswordToken token) {

        String captcha = SessionManager.get(SessionManager.KEY_CAPTCHA);
        String input = token.getCaptcha();
        
        if (captcha != null && !captcha.equalsIgnoreCase(input)) {
            //logger.error(String.format("Captcha error： need=%s, input=%s.", captcha, input));
            throw new IncorrectCaptchaException();
        }
    }


}
