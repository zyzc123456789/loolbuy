package com.loolbuy.global.security;

import java.lang.reflect.Field;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.realm.AuthenticatingRealm;


public abstract class AbstractAuthenticatingRealm<T> extends AuthenticatingRealm
{
    private static final AllowAllCredentialsMatcher ALLOW_ALL = new AllowAllCredentialsMatcher();

    /**
     * 检查客户输入的登录情报
     * 认证通过后返回客户情报
     * 认证失败后抛出例外
     */
    @Override
    protected final AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException
    {
        CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;
        T user = authenticatePrincipal(token);
        
        // 认证通过后将用户信息设置到 principal 属性，将来可以通过 SecurityUtils.getSubject().getPrincipal() 得到该信息
        return new SimpleAuthenticationInfo(user, user, getName());
    }

    /**
     * 认证情报匹配用（目前不做检查）
     */
    @Override
    public final CredentialsMatcher getCredentialsMatcher()
    {
        // 在 getStoredPrincipal 的同时就进行所有的认证检查，所以这里就不需要做了
        return ALLOW_ALL;
    }

    /**
     * 根据画面输入的内容取得平台保存的认证情报，然后进行所有的认证检查，通过的场合返回用户情报，否则抛出例外
     * @param token 客户端输入的认证用情报
     * @return 用户情报
     * @throws AuthenticationException
     */
    protected abstract T authenticatePrincipal(CaptchaUsernamePasswordToken token) throws AuthenticationException;

}
