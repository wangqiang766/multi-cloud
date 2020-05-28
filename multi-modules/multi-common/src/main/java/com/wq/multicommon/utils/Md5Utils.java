package com.wq.multicommon.utils;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5加密算法
 */
public final class Md5Utils {

    /**
     * md5加密算法
     *
     * @param orgin 要加密密码
     * @return 加密后字符
     */
    public static String md5(String orgin) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            String result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
            return result;
        } catch (Exception e) {
            throw new RuntimeException("sign error !");
        }
    }

    /**
     * md5加密算法
     *
     * @param message
     * @param charset
     * @return
     */
    public static String md5(String message, String charset) {
        String md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5"); // 创建一个md5算法对象
            byte[] messageByte = getContentBytes(message, charset);
            byte[] md5Byte = md.digest(messageByte); // 获得MD5字节数组,16*8=128位
            md5 = bytesToHex(md5Byte); // 转换为16进制字符串
        } catch (Exception e) {
            throw new RuntimeException("sign error !");
        }
        return md5;
    }

    /**
     * 加密算法
     *
     * @param orgin
     * @return
     */
    public static String encode(String orgin) {
        return sha256(md5(orgin));
    }

    /**
     * md5 转大写
     *
     * @param orgin
     * @return
     */
    public static String md5toLowerCase(String orgin) {
        String result;
        try {
            result = md5(orgin).toLowerCase();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("sign error !");
        }
    }

    /**
     * 字符转16进制
     *
     * @param b
     * @return
     */
    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; ++n) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    private static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * @param content
     * @param charset
     * @return
     */
    public static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

    /**
     * 生成文件的md5校验值
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String getFileMD5String(File file) throws IOException {
        InputStream fis;
        fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int numRead = 0;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            while ((numRead = fis.read(buffer)) > 0) {
                md.update(buffer, 0, numRead);
            }
            fis.close();
            return byte2hex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("sign error !");
        }
    }

    /**
     * 二进制转十六进制
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
            if (num < 0) {
                num += 256;
            }
            if (num < 16) {
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString();
    }

}
