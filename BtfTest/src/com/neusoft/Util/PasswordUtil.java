/**
 *@Copyright:Copyright (c) 2017 - 2100
 *@Company:easy
 */
package com.neusoft.Util;

import java.security.MessageDigest;
import java.util.Random;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;



/**
 *@Title:
 *@Description:
 *@Author:yhc
 *@Since:2018��8��27��
 *@Version:1.1.0
 */
public class PasswordUtil {
    /**
     * ���ɺ�������ε�����
     */
    public static String generate(String password) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        System.out.println("salt Ϊ"+salt);
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }
    /**
     * У�������Ƿ���ȷ
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }
    /**
     * ��ȡʮ�������ַ�����ʽ��MD5ժҪ
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new HexBin().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

//���ԣ�
    public static void main(String[] args) {
        // ����+����
        String password1 = generate("admin");
        System.out.println("�����" + password1 + "   ���ȣ�"+ password1.length());
        // ����
        System.out.println(verify("admin", password1));
        // ����+����
        String password2= generate("admin");
        System.out.println("�����" + password2 + "   ���ȣ�"+ password2.length());
        // ����
        System.out.println(verify("admin", password2));
    }

}
