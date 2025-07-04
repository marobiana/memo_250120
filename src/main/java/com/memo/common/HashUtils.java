package com.memo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// 일반 bean
public class HashUtils {

    // i: 원본 메시지
    // o: 해싱된 메시지
    public static String md5(String message) {
        String encData = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] bytes = message.getBytes();
            md.update(bytes);
            byte[] digest = md.digest();

            for (int i = 0; i < digest.length; i++) {
                encData += Integer.toHexString(digest[i] & 0xff); // 16진수로 변환하는 과정
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encData;
    }
}
