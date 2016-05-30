package com.loolbuy.global.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.realm.AuthenticatingRealm;

public class AbstractAuthenticatingRealm<T> extends AuthenticatingRealm
{

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException
    {
        // TODO Auto-generated method stub
        return new SimpleAuthenticationInfo();
    }

    @Override
    public CredentialsMatcher getCredentialsMatcher()
    {
        // TODO Auto-generated method stub
        return super.getCredentialsMatcher();
    }

}
