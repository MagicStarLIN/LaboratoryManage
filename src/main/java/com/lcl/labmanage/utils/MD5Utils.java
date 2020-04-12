package com.lcl.labmanage.utils;

import java.security.MessageDigest;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: MD5Utils
 * @date 2020/3/30 9:57 下午
 */
public class MD5Utils {
    private static final String slat = "&%5123***&&%%$$#@";

    /**
     * 对字符串进行加密处理
     * @param dataStr
     * @return
     */
    public static String encrypt(String dataStr) {
        try {
            dataStr = dataStr + slat;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}
