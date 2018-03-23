package com.orangee.athenaeum.utils;

import java.util.Random;

/**
 * Created by Luca on 23/03/2018.
 */
public class CodeUtils {

    public static String randomGenerationCode(int size) {

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            sb.append(chars[random.nextInt(chars.length)]);
        }

        return sb.toString();
    }

}
