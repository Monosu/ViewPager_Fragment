package com.example.linxi.viewpager_fragment.util;

import android.content.Context;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * desp:
 * author: xuhan
 * date: 15/12/28
 */
public class AESUtil {


    /**
     *
     * @description SHA1加密
     * @author sctang
     * @create 2015年12月8日 上午10:16:35
     * @version 1.0
     * @param val
     * @return
     */
    public static String SHA1(String val) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(val.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 加密
     *
     * @param msg[in]    明文数据串
     * @param cipher[in] 加密后的密文
     * @param length[in] 明文长度
     * @return
     */
    public synchronized static native int Encrypt(byte[] msg, byte[] key, byte[] cipher, int length);

    /**
     * 解密
     *
     * @param cipher[in] 密文数据
     * @param key[in]    秘钥
     * @param result[in] 明文
     * @param length[in] 密文长度
     * @return
     */
    public synchronized static native int Decrypt(byte[] cipher, byte[] key, byte[] result, int length);


    /**
     * 生成签名
     *
     * @param key[in]       秘钥
     * @param timestamp[in] 时间戳
     * @param nonce[in]     唯一标示
     * @return
     */
    public synchronized static native String getSignature(String key, String timestamp, String nonce);

    /**
     * 生成签名
     *
     * @param data[in] 数组
     * @return
     */
    public synchronized static native String getEncodeSignature(String[] data);

    /**
     * 获取有效的授权秘钥
     *
     * @param context
     * @return
     */
    public synchronized static native String getAuthKey(Context context);

    static {
      System.loadLibrary("AES");
    }
}
