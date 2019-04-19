package com.org.main.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    public boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    public static void main(String[] args){
        PhoneNumber phoneNumber=new PhoneNumber();
        boolean phone=phoneNumber.isMobileNO("18098970909");
        System.out.println(phone);
    }
}
