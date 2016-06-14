package com.loolbuy.common.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loolbuy.global.AppContext;
import com.loolbuy.global.util.MessageCode;
import com.loolbuy.global.util.Messager;

/**
 * 本对象用来存放往客户端发送的数据
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ResponseModel implements Serializable
{
    // 处理结果
    private MessageCode code;
    
    // 结果的文字描述
    private String message;
    
    // 需要发送的数据
    private Object data;

    
    private ResponseModel()
    {
        // 防止自己创建对象
    }
    
    public MessageCode getCode()
    {
        return code;
    }

    public void setCode(MessageCode code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ResponseModel [code=" + code + ", message=" + message + ", data=" + data + "]";
    }
    
    /**
     * 创建返回（业务处理成功的场合下）
     * @return
     */
    public static ResponseModel success()
    {
        return response(null, MessageCode.SUCCESS);
    }

    /**
     * 创建返回数据（业务处理成功的场合下）
     * @param data
     * @return
     */
    public static ResponseModel success(Object data)
    {
        return response(data, MessageCode.SUCCESS);
    }
    
    /**
     * 创建返回信息（业务处理失败的场合下）
     * @param data
     * @param code
     * @param params
     * @return
     */
    public static ResponseModel failure(Object data, MessageCode code, Object ... params)
    {
        return response(data, code, params);
    }
    
    /**
     * 创建返回信息（业务处理失败的场合下）
     * @param code
     * @param params
     * @return
     */
    public static ResponseModel failure(MessageCode code, Object ... params)
    {
        return response(null, code, params);
    }

    /**
     * 是否处理成功的返回信息
     * @return
     */
    @JsonIgnore
    public boolean isSuccess()
    {
        return code == MessageCode.SUCCESS;
    }
    
    // 创建返回
    private static ResponseModel response(Object data, MessageCode code, Object ... params)
    {
        ResponseModel response = new ResponseModel();
        
        response.setData(data);
        response.setCode(code);
        response.setMessage(AppContext.getBean(Messager.class).get(code, params));
        
        return response;
    }
}

