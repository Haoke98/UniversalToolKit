package com.github.Haoke98.util.core.test;

public class ReplaceStarUtils {

    /**
     * 对字符加星号处理：除前面几位和后面几位外，其他的字符以星号代替
     * @param content  传入的字符串
     * @param frontNum  保留前面字符的位数
     * @param endNum 保留后面字符的位数
     * @return 带星号的字符串
     */
    public static String replaceString2Star(String content, int frontNum, int endNum) {
        if (content == null || content.trim().isEmpty())
            return content;

        int len = content.length();

        if (frontNum >= len || frontNum < 0 || endNum >= len || endNum < 0)
            return content;

        if (frontNum + endNum >= len)
            return content;


        int beginIndex = frontNum;
        int endIndex = len - endNum;
        char[] cardChar = content.toCharArray();

        for (int j = beginIndex; j < endIndex; j++) {
            cardChar[j] = '*';
        }

        return new String(cardChar);
    }
}
