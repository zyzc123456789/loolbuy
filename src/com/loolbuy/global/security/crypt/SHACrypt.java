package com.loolbuy.global.security.crypt;


import java.nio.charset.Charset;
import org.apache.commons.codec.digest.DigestUtils;
import com.loolbuy.global.util.CharsetExt;

public class SHACrypt
{
    public static byte[] hash(String text, Charset charset) 
    {
        return DigestUtils.sha256(text.getBytes(charset));
    }

    public static byte[] hash(String text, String charset) 
    {
        return hash(text, Charset.forName(charset));
    }

    public static byte[] hash(String text) 
    {
        return hash(text, CharsetExt.UTF8);
    }
}
