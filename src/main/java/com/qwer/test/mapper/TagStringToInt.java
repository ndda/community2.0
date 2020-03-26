package com.qwer.test.mapper;

import org.springframework.stereotype.Component;

@Component
public class TagStringToInt {
    public int stringToInt(String tag){
        //分别为1、2、3、4级相对应的tag
        String one;
        String two;
        String three;
        String four;

        int oneInt=10;
        int twoInt=10;
        int threeInt=10;
        int fourInt=1000;

        String[] tagChild= new String[4];
        tagChild=tag.split("\\.");
        one=tagChild[0];
        two=tagChild[1];
        three=tagChild[2];
        four=tagChild[3];

        switch (one){
            case "服务端" : oneInt=11;break;
            case "数据库" :oneInt=12;break;
            case "web端" :oneInt=13;break;
            default:oneInt=10;
        }
        switch (two){
            case "java" : twoInt=11;break;
            case "python" :twoInt=12;break;
            case "mysql" :twoInt=13;break;
            case "redis" :twoInt=14;break;
            case "html" :twoInt=15;break;
            case "css" :twoInt=16;break;
            case "javaScript" :twoInt=17;break;
            default:twoInt=10;
        }
        switch (three){
            case "异常" : threeInt=11;break;
            case "教程" :threeInt=12;break;
            case "心得" :threeInt=13;break;
            case "redis" :threeInt=14;break;
            case "html" :threeInt=15;break;
            case "css" :threeInt=16;break;
            case "javaScript" :threeInt=17;break;
            default:threeInt=10;
        }
        tag=""+oneInt+twoInt+threeInt+fourInt;
        int tagInt=Integer.parseInt(tag);
        return tagInt;
    }
}
