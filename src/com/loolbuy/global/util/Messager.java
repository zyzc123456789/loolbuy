package com.loolbuy.global.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * 根据 message code 到配置文件去取 message 内容
 * @author Administrator
 *
 */
@Component
public class Messager
{

    @Autowired
    public MessageSource messageSource;

    /**
     * 取得指定 message code 对应的 message 内容
     * @param key
     * @param params
     * @return
     */
    public String get(String key, Object... params)
    {
        String msg = messageSource.getMessage(key, params, null);
        return String.format("%s(%s)", msg, key);
    }
    
    /**
     * 取得指定 message code 对应的 message 内容
     * @param key
     * @param params
     * @return
     */
    public String get(Enum<?> key, Object... params)
    {
        return get(key.toString(), params);
    }

}
