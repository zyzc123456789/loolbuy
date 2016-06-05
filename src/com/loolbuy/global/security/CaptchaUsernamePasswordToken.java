package com.loolbuy.global.security;

import org.apache.shiro.authc.UsernamePasswordToken;

@SuppressWarnings("serial")
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {

    private String captcha;

    public String getCaptcha(){ return this.captcha; }
    
    public CaptchaUsernamePasswordToken(String username, String password, boolean rememberMe, String host, String captcha) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
    }
}