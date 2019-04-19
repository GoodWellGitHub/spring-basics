package com.org.main.string;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Encode {
    public static void main(String[] args){
        String ss="http://container.in.hillinsight.com/?id=[4]";
        try {
            String urlencode= URLEncoder.encode("xx","utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
