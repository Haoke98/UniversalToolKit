package com.github.Haoke98.util.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *字符串转数组的工具类
 *
 *
 *
 */
public class ArrayUtils {

    /**
     * 将字符串转换成一维数组
     *
     * @param input
     * @param spliter
     * @return
     */
    public static String[] strToArray(String input, String spliter) {
        if (input.indexOf(spliter) < 0) {
            return new String[] { input };
        } else {
            return input.split(spliter);
        }
    }

    /**
     * 将字符串转成二维数组
     *
     * @param input
     * @param spliter
     * @return
     */
    public static List<Map> strToMapList(String input, String spliter) {
        List<Map> tempLst = new ArrayList<Map>();
        if (input.indexOf(spliter) < 0) {
            return tempLst;
        } else {
            String[] temp = input.split(spliter);
            if (temp.length % 2 != 0) {// 奇数个
                return tempLst;
            } else {// 偶数个
                for (int i = 0; i < temp.length / 2; i++) {
                    Map tempMap = new HashMap();
                    tempMap.put("X", temp[i * 2]);
                    tempMap.put("Y", temp[i * 2 + 1]);
                    tempLst.add(tempMap);
                }
                return tempLst;
            }
        }
    }

    public static String strArrToString(String[] arrStrs) {
        StringBuffer sb = new StringBuffer();
        String ret = "";
        for (String str : arrStrs) {
            sb.append(str + ";");
        }
        ret = sb.substring(0, sb.length() - 1);
        return ret;
    }
}
