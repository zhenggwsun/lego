package com.zhangweinan.util;

import java.util.Random;

/**
 * 验证码
 * Created by Eric on 2019/4/22.
 */
public class CodesUtil {

    public static String getCodex(int length){
        //第一步定义一个字典
        String a = "1234567890";

        //第二步定义一个随机数
        Random random = new Random();

        //第三步定义一个数组并填充
        char[] c = new char[length];
        for(int i=0;i<c.length;i++){

            c[i] = a.charAt(random.nextInt(a.length()));
        }

        return new String(c);
    }
}
