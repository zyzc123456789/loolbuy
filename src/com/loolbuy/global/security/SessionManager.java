package com.loolbuy.global.security;

import org.apache.shiro.SecurityUtils;

import com.google.code.kaptcha.Constants;

public class SessionManager
{
    public static final String KEY_AUTH_ERROR_COUNT = "AUTH_ERROR_COUNT";
    public static final String KEY_CAPTCHA = Constants.KAPTCHA_SESSION_KEY;
    public static final String KEY_CSRF_TOKEN_FORM = "CSRF_TOKEN_FORM";
    public static final String KEY_CSRF_TOKEN_AJAX = "CSRF_TOKEN_AJAX";

    @SuppressWarnings("unchecked")
    public static <T> T get(String key)
    {
        Object value = SecurityUtils.getSubject().getSession().getAttribute(key);
        return (T)value;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key, T defaultValue)
    {
        Object value = SecurityUtils.getSubject().getSession().getAttribute(key);
        if(value == null) return defaultValue;
        return (T)value;
    }
    
    public static void set(String key, Object value)
    {
        SecurityUtils.getSubject().getSession().setAttribute(key, value);
    }
    
    public static boolean has(String key)
    {
        Object value = get(key);
        return value != null;
    }
    
    public static void add(String key)
    {
        set(key, "1");
    }
    
    public static void remove(String key)
    {
        SecurityUtils.getSubject().getSession().removeAttribute(key);
    }
    
    public static void increase(String key)
    {
        int current = get(key, 0);
        set(key, current + 1);
    }
    
    public static String getId()
    {
        try
        {
            return SecurityUtils.getSubject().getSession().getId().toString();
        }
        catch(Exception e)
        {
            return "";
        }
    }
}
