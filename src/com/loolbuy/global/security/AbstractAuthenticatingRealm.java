package com.loolbuy.global.security;

import java.lang.reflect.Field;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.realm.AuthenticatingRealm;


public abstract class AbstractAuthenticatingRealm<T> extends AuthenticatingRealm
{
    private final CredentialsMatcher matcher = new CredentialsMatcher()
    {
        @Override
        public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo authInfo) 
        {
            UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
            String inputPassword = new String(token.getPassword());
            String storedPassword = authInfo.getCredentials().toString();
            
            return isCredentialMatch(inputPassword, storedPassword);
        }
    };
    
    @Override
    protected final AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException 
    {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        T user = getStoredPrincipal(token);
        if(user == null) { return null; }
        
        String password = getStoredPrincipalPassword(user);
        return new SimpleAuthenticationInfo(user, password, getName());
    }

    @Override
    public final CredentialsMatcher getCredentialsMatcher()
    {
        return matcher;
    }
    
    protected String getStoredPrincipalPassword(T user)
    {
        try
        {
            for(Field f : user.getClass().getDeclaredFields())
            {
                if(f.isAnnotationPresent(Password.class))
                {
                    return (String)f.get(user);
                }
            }
        }
        catch(IllegalArgumentException | IllegalAccessException e)
        {
            throw new PrincipleTypeException(e);
        }
        
        throw new PrincipleTypeException("Principle Type must have password field.");
    }

    protected abstract T getStoredPrincipal(UsernamePasswordToken token);

    protected boolean isCredentialMatch(String inputPassword, String storedPassword) 
    {
        return inputPassword.equals(storedPassword);
    }

}
