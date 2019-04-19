package com.org.main.string;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.org.domain.ChannelType;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonString {
    public static void main(String[] args) {
/*        String str="[['颜色','白'],['尺码','S']]";
        JSONArray array=JSONArray.parseArray(str);
        Iterator iterator=array.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        JSONArray array1=JSONArray.parseArray(array.get(0).toString());

        System.out.println(array.get(0));
        System.out.println(array1.get(0));*/
        //JSONObject json=JSON.parseObject(str);
  /*      if(json.containsKey("颜色")){
            System.out.println(json.get("颜色"));
        }*/
/*
        List<Integer> list = Lists.newArrayList();
        list.add(3);
        list.add(5);
        list.add(12);
        System.out.println(JSON.toJSONString(list));
        ChannelType channelType = ChannelType.builder().type(JSON.toJSONString(list)).desc("反馈").build();
        List<ChannelType> channelTypes = Lists.newArrayList();
        channelTypes.add(channelType);
        channelTypes.add(channelType);
        System.out.println(JSON.toJSONString(channelTypes));
        Map<String, String> xx = Maps.newHashMap();
        xx.put(JSON.toJSONString(list), "反馈");
        System.out.println(JSON.toJSONString(xx));*/
/*
                List<String> jsonStr = JSON.parseArray("",String.class);
*/
        List<Integer> ax = Lists.newArrayList();
        String jsonStr = JSONArray.toJSONString(ax);
        System.out.println(jsonStr);
/*        List<String> yy=JSONArray.parseArray(jsonStr,String.class);
        System.out.println(jsonStr);
        System.out.println(yy);*/
    }
}
