package com.example.illya.studentlist.utils;


import java.util.Random;

public class StringUtils {

    public static String createRandomStringWithLength(int resutlWordLength) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < resutlWordLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();

    }

}
