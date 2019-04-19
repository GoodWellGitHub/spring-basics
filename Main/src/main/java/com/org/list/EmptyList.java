package com.org.list;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class EmptyList {
    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayListWithCapacity(0);
        List<Integer> longs = stringList.stream().map(String::length).collect(Collectors.toList());
        longs.stream().forEach(System.out::println);
        System.out.println(CollectionUtils.isEmpty(longs));
    }
}
