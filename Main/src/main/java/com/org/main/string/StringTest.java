package com.org.main.string;

import com.google.common.collect.Sets;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class StringTest {
    public static void main(String[] args) {
        List<String> strings=new ArrayList<>();
        System.out.println(StringUtils.isEmpty(""));

        String empty="              ";
        System.out.println("xx"+empty.trim()+"xx");
        System.out.println(StringUtils.isEmpty(empty.trim()));
        System.out.println(Objects.isNull(empty.trim()));
        System.out.println("".equals(empty.trim()));

        Set<String> setNum= Sets.newHashSet("1","0","2");
        byte a=1;
        System.out.println(setNum.contains(a+""));
    }
}
