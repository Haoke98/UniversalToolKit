package com.silurongchuang.common;

import com.silurongchuang.common.util.desensitizer.DesensitizationUtils;
import com.silurongchuang.common.util.desensitizer.NameUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class CommonApplicationTests {
    public static void main(String[] args) {
        String name = "工作人生";

        String nowName = NameUtils.userName(name);
        System.out.println(nowName);








//        String  regular = "[()\\(\\)(集团)(企业)(有限)(股份)]";
//        String re = "[^\\u4E00-\\u9FA5]";
//
//        Pattern pattern = Pattern.compile(regular);
//        Matcher matcher = pattern.matcher(name);
//        Boolean isName = matcher.find();
////        System.out.println(isName);
//
//
//        Pattern pattern1 = Pattern.compile(re);
//        Matcher matcher1 = pattern1.matcher(name);
//        Boolean isName1 = matcher1.find();
//        System.out.println(isName1);

//        String name = "三个字";
//        int first = name.indexOf("·");
//        int last = name.lastIndexOf("·");
//        if (0 < first && first == last){
//            System.out.println("成功");
//        }else {
//            System.out.println("失败");
//        }
//        System.out.println("其他");


//        System.out.println(name.length());

    }
}
