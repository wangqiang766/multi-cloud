package com.wq.multicommon.utils;

import java.util.regex.Pattern;

/**
 * @author HX0013522
 * @date 2019-06-11 16:49:49
 */
public class RegExUtils {

    private static Pattern INTEGER_PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");

    /**
     * 判断是否为整数
     *
     * @param str 传入字符串
     * @return 是整数返回true，否则返回false
     */
    public static boolean isInteger(String str) {
        return INTEGER_PATTERN.matcher(str).matches();
    }

    /**
     * 判断是否是字母
     *
     * @param str 传入字符串
     * @return 是字母返回true，否则返回false
     */
    public boolean isAlpha(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("[a-zA-Z]+");
    }

    /**
     * 判断是否是字母或者数字
     *
     * @param str 传入字符串
     * @return 是字母返回true，否则返回false
     */
    public static boolean isLetterDigit(String str) {
        String regex = "^[a-z0-9A-Z]+$";
        return str.matches(regex);
    }

    /**
     * 判断是否是字母或者数字
     *
     * @param str 传入字符串
     * @return 是字母返回true，否则返回false
     */
    public static boolean isLetterDigitLine(String str) {
        String regex = "^[a-z0-9A-Z\\-_]+$";
        return str.matches(regex);
    }

}
