package com.loolbuy.global.security.crypt;


@SuppressWarnings("serial")
public class CryptException extends RuntimeException 
{
    public CryptException(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public CryptException(String message) 
    {
        super(message);
    }

    public CryptException(Throwable cause) 
    {
        super(cause);
    }
}