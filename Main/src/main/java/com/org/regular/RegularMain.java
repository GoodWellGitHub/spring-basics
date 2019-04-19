package com.org.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularMain {
    public static void main(String[] args){
        String str1="[A-Z]{1,10}[0-9]{13,100}";
        Pattern pattern=Pattern.compile(str1);
        Matcher matcher=pattern.matcher("18856021858");
        System.out.println(matcher.matches());
        int k=10;
        if (k>3){
            System.out.println("k>3");
        }
        if (k>4){
            System.out.println("k>4");
        }
    }
}
