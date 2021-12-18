package com.silurongchuang.common.util.desensitizer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ms 萌森
 * @creationDate 2021/9/27
 */
public class NameUtils {
    //复性
    private final static String[] surName = {
            "万俟","司马","上官","欧阳","夏侯",
            "诸葛","闻人","东方","赫连","皇甫",
            "尉迟","公羊","澹台","公冶","宗政",
            "濮阳","淳于","单于","太叔","申屠",
            "公孙","仲孙","轩辕","令狐","锺离",
            "宇文","长孙","慕容","鲜于","闾丘",
            "司徒","司空","丌官","司寇","南宫",
            "子车","颛孙","端木","巫马","公西",
            "漆雕","乐正","壤驷","公良","拓拔",
            "夹谷","宰父","谷梁","段干","百里",
            "东郭","南门","呼延","羊舌","微生",
            "梁丘","左丘","东门","西门"
    };
    //正则 匹配非中文
    private final static String  RULE_OUT_CHINESE = "[^\\u4E00-\\u9FA5]";
    //正则 匹配非中文
    private final static String  RULE_CHINESE = "[\\u4E00-\\u9FA5]";
    //正则 匹配企业名法人
    private final static String  LEGAL_BODY_ENTERPRISE = "[()\\(\\)]|(集团)|(企业)|(有限)|(股份)|(公司)|(工作室)|(暂无)";

    //法人脱敏
    public static String userName(String name){
        //去除空替换大部分空白字符， 不限于空格
        name = name.replaceAll(" ", "");
//        name = name.replaceAll("(\\s)(\\t)", "");

        Boolean nonChinese = Pattern.compile(RULE_OUT_CHINESE).matcher(name).find();
        Boolean enterprise = Pattern.compile(LEGAL_BODY_ENTERPRISE).matcher(name).find();
        Boolean chinese = Pattern.compile(RULE_CHINESE).matcher(name).find();

        //企业法人
        if (enterprise){
            return name;
        }
        //带有符号的法人
        if (nonChinese) {
            // &#8226; 前端符号
            int firstC = name.indexOf("&#8226;");
            if(0 < firstC){
                name = name.substring(0,firstC) + "·" + name.substring(firstC+7);
            }

            //·符号处理
            int first = name.indexOf("·");
            int last = name.lastIndexOf("·");
            int c = name.indexOf(".");
            int d = name.lastIndexOf(".");

            if (c > first){
                first = c;
                last = d;
            }
            if (0 < first) {
                return aFew(name, first, last);
            }
            return "暂无";
        }
        //姓名脱敏
        if (chinese){
            if ("登记管理机关暂未提供".equals(name)){
                return "暂无";
            }

            //复性
            String firstName = name.substring(0,2);
            String xin = "<b>**</b>";//*号
            for(String s : surName){
                if(s.contains(firstName)){
                    name = firstName + xin;
                    return name;
                }
            }
            //单姓
            if (name.length() < 3){
                return str2(name);
            }
            return str3(name);
        }
        //其他人物
        return "暂无";
    }


    //多字姓名
    private  static String str3(String name){
        if (3 == name.length()){
            name = name.substring(0,1) + "<b>*</b>" + name.substring(name.length()-1);
        }else {
            name = name.substring(0,2) + "<b>*</b>" + name.substring(name.length()-1);
        }
        return name;
    }

    //2字姓名
    private static String str2(String name){
        String xin = "<b>*</b>";//*号
        name = name.substring(0,1) + xin;
        return name;
    }

    //留首
    private static String shou(String name){
        name = name.substring(0,1);
        return name;

    }
    //留2首
    private static String shou2(String name){
        name = name.substring(0,2);
        return name;

    }
    //留尾
    private static String wei(String name){
        name = name.substring(name.length()-1);
        return name;
    }
    //留2尾
    private static String wei2(String name){
        name = name.substring(name.length()-2);
        return name;
    }

    private static String aFew(String name, int first, int last){
        //XXX·XXX
        String str11 = name.substring(0,first);
        String str22 = name.substring(last+1);
        if (str11.length() < 3){
            name = shou(str11) + "<b>**</b>" + wei(str22);
        }else {
            name = shou2(str11) + "<b>*</b>" + wei(str22);
        }
        return name;
    }

}
