package com.loolbuy.global;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppContext implements ApplicationContextAware
{

    private static ApplicationContext appContext;

    @SuppressWarnings("static-access")
    @Override
    public void setApplicationContext(ApplicationContext globalAppContext) throws BeansException
    {
        this.appContext = globalAppContext;
    }

    public static ApplicationContext getAppContext()
    {
        return appContext;
    }

    public static Object getBean(String beanId)
    {
        return appContext.getBean(beanId);
    }

    public static <T> T getBean(Class<T> beanClass)
    {
        return appContext.getBean(beanClass);
    }

}