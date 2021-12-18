package com.github.Haoke98.util.desensitizer;

import com.github.Haoke98.util.security.EncryptViewUtils;

import java.text.MessageFormat;

public class DesensitizationUtils {
    public static String phoneNum(String phoneNum) {
        return EncryptViewUtils.toEncryptView(phoneNum, "*", 3, 6);
    }

    public static String name(String name) {
        return NameUtils.userName(name);
    }

    public static String highlighted(String highlightedValue, String desensitizationValue,String preTag,String postTag) {
        System.out.println(MessageFormat.format("h:({0}),d:({1})", highlightedValue, desensitizationValue));
        //高亮标签之前的部分
        int rightStart = 0;
        int rightEnd = highlightedValue.indexOf(preTag) - 1;
        //高亮标签内的部分
        int midStart = rightEnd + 1;
        int midEnd = highlightedValue.indexOf(postTag) - postTag.length() - 1;
        //高亮标签之后的版本
        int leftStart = midEnd + 1;
        int leftEnd = desensitizationValue.length() - 1;

        System.out.println(MessageFormat.format("rs:{0},re:{1},ms:{2},me:{3},ls:{4},le:{5}", rightStart, rightEnd, midStart, midEnd, leftStart, leftEnd));
        if (midStart == -1) {
            return desensitizationValue;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = rightStart; i <= rightEnd; i++) {
            sb.append(desensitizationValue.charAt(i));
        }
        sb.append(preTag);
        for (int i = midStart; i <= midEnd; i++) {
            sb.append(desensitizationValue.charAt(i));
        }
        sb.append(postTag);
        for (int i = leftStart; i <= leftEnd; i++) {
            sb.append(desensitizationValue.charAt(i));
        }
        return sb.toString();
    }
}
