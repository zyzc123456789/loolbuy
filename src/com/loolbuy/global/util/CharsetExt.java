package com.loolbuy.global.util;

import java.nio.charset.Charset;

public class CharsetExt 
{
    public static final String UTF8 = "UTF-8";
    public static final Charset UTF8_CHARSET = Charset.forName(UTF8);
    public static final Charset SYS_CHARSET = Charset.defaultCharset();
}