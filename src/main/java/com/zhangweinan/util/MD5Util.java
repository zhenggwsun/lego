package com.zhangweinan.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密
 * Created by Eric on 2019/4/22.
 */
public class MD5Util {

    public static String md5Hex(String password){
        return DigestUtils.md5Hex(password);
    }
}
