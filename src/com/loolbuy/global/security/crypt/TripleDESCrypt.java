package com.loolbuy.global.security.crypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import com.loolbuy.global.util.CharsetExt;

public class TripleDESCrypt
{
    private static final String ALGORITHM = "DESede";
    private static final int KEY_LEN = 24;
    
    private static final Cipher cipher;
    
    static
    {
        try 
        {
            cipher = Cipher.getInstance(ALGORITHM);
        } 
        catch (NoSuchAlgorithmException | NoSuchPaddingException e) 
        {
            throw new CryptException(e);
        }
    }
    
    public static String encrypt(String src, String key)  
    {
        try 
        {
            SecretKey skey = new SecretKeySpec(createKey(key), ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            return Base64.encodeBase64String(cipher.doFinal(src.getBytes(CharsetExt.UTF8_CHARSET)));
        } 
        catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) 
        {
            throw new CryptException(e);            
        }
    }   
    
    public static String decrypt(String src, String key)
    {
        try
        {
            SecretKey skey = new SecretKeySpec(createKey(key), ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skey);
            return new String(cipher.doFinal(Base64.decodeBase64(src)), CharsetExt.UTF8_CHARSET);
        }
        catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) 
        {
            throw new CryptException(e);
        }
    }

    private static byte[] createKey(String key)
    {
        byte[] newKey = SHACrypt.hash(key);
        return ArrayUtils.subarray(newKey, 0, KEY_LEN);
    }
}
