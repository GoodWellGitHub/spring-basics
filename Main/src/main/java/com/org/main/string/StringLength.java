package com.org.main.string;

import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.util.Map;

public class StringLength {
/*    public static void main(String[] args){
        String str="               ";
        System.out.println(isEmpty(str));
    }
    public static boolean isEmpty(String string){
     return StringUtils.hasLength(string) && StringUtils.hasLength(string.trim());
    }*/

    public static void main(String[] args) {
        String str = "你好as好阿斯兰的/n房间啊dfb";
        String str1=str.substring(0,str.length());

        System.out.println(str.length());
        System.out.println(str1);

        Map<Integer,String>  stringMap= Maps.newHashMap();
        stringMap.put(3,"key");
        Byte b=(byte)3;
        System.out.println(stringMap.get((int)b));

        String ss="\"";
        String a="我";
        String ba="你";
        StringBuilder stringBuilder=new StringBuilder(a);
        stringBuilder.append(ss).append(ba);
        System.out.println(stringBuilder.toString());

        String sr="xlka4?2*3x.";
        System.out.println(sr.contains("u"));
    }
}
