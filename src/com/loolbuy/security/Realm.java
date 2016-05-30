package com.loolbuy.security;

import org.slf4j.LoggerFactory;

import com.loolbuy.common.model.CustomerModel;
import com.loolbuy.global.security.AbstractAuthenticatingRealm;

public class Realm extends AbstractAuthenticatingRealm<CustomerModel>
{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Realm.class);
}
