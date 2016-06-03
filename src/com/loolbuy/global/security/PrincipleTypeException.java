package com.loolbuy.global.security;

@SuppressWarnings("serial")
public class PrincipleTypeException extends RuntimeException 
{
    public PrincipleTypeException(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public PrincipleTypeException(String message) 
    {
        super(message);
    }

    public PrincipleTypeException(Throwable cause) 
    {
        super(cause);
    }
}