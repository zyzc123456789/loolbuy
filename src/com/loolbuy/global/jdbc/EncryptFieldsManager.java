package com.loolbuy.global.jdbc;

import java.util.Map;
import java.util.Properties;

import com.loolbuy.global.security.crypt.TripleDESCrypt;


public class EncryptFieldsManager{
    private static Properties props;

    public static Object encryptIfNeed(String name, Object value) {
        if (value == null)
            return null;

        String info = getEncryptInfo(name);
        if (info == null)
            return value;

        return TripleDESCrypt.encrypt(value.toString(), info);
    }
    
    public static Object decryptIfNeed(String name, Object value) {
        if (value == null)
            return null;

        String info = getEncryptInfo(name);
        if (info == null)
            return value;

        return TripleDESCrypt.decrypt(value.toString(), info);
    }


    private static String getEncryptInfo(String name) {
//        if (props == null) {
//            props = PropertiesLoader.load("encryptfields.properties");
//        }
//
//        for (Map.Entry<Object, Object> item : props.entrySet()) {
//            // TODO field name match logic must be decided
//            if (name.startsWith(item.getKey().toString())) {
//                return item.getValue().toString();
//            }
//        }

        return null;
    }
}
