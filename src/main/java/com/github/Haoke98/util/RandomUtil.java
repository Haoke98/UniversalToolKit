package com.github.Haoke98.util;

import java.util.Random;

public class RandomUtil {
    public static String generate(String from, int n) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = from.charAt(random.nextInt(from.length()));
            sb.append(ch);
        }
        return sb.toString();
    }
}
