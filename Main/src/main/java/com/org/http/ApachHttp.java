package com.org.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApachHttp {
    private static String auth = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoyMTI3OTU3LCJyZWZfZXhwIjoxNTUzNDk0MzA5LCJhdWQiOiJZVFV3TTJSa1ltRXlZek5tTWpWak1tSXpaakE1WlRWaSIsImFwcG5hbWUiOiJiZWxsZXRvbmUiLCJpc3MiOiJlcHAiLCJuYW1lX2NuIjoiXHU1MjE4XHU2ZDBiXHU2ZDBiIiwidGhpcmRfaWQiOiIxODA4OTI1NzAiLCJhdmF0YXIiOiIiLCJleHAiOjE1NTI4ODk1MDksInRlbF9ubyI6IjE1MjEwNTM5OTIwIiwiZGVwYXJ0bWVudCI6Ilx1NTI0ZFx1N2FlZlx1N2VjNCIsImlhdCI6MTU1MjI4NDcwOSwibmFtZSI6IiJ9.pRHiu8aq_viQPD7bM2ip48N-Kxv9O0Qil9wE5-ShkNqforgkOhDN7u6TDK8VV9LnQcMdbimEXb_i0bXTlvcd6vXQSzoSnvTcj-8_MCN6ofSpzvKvESOz8isrAIMdIOtuKvQour2hBnFtU4EY9yVvTWIV812s4xlIm3SRKOv6Pn1zwXAFqzkASPYqKa4tXQcIOv48HGjAvjVpl_ADvANdsurK1hEuFQsG6Mpes9O0M80EGBW4aJuYegbMOdsTZnBsbTLWoJC899YiYcZhW12gOieAmUoFP1JuRmi5yUt-2nBtzxloiYF7FZvDpn0lCK_vT6eIZBbw0NTIyWrwqazVxQ";

    public static void main(String[] args) {
        //doApachGet();
        //doPostPara();
        doPost();
    }

    public static String doApachGet() {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://localhost:8888/message/get?name=林黛玉&age=18");
        httpGet.addHeader("Authorization", auth);
        try {
            HttpResponse response = client.execute(httpGet);
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
            return res;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String doPostPara() {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://localhost:8888/message/post/para");
        post.setHeader("Authorization", auth);
        List<NameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("name", "林黛玉"));
        pairs.add(new BasicNameValuePair("age", "18"));
        pairs.add(new BasicNameValuePair("sex", "女"));
        try {
            post.setEntity(new UrlEncodedFormEntity(pairs, HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            System.out.println(entity);
            return entity.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String doPost() {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://localhost:8888/message/post");
        post.setHeader("Authorization", auth);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> json = Maps.newHashMap();
        json.put("name", "林黛玉");
        json.put("age", 18);
        json.put("sex", "女");
        json.put("req", DeleteContentReq.builder().contentId("xy").contentType(12).build());
        post.setHeader(HTTP.CONTENT_TYPE, "application/json");
        try {
            post.setEntity(new StringEntity(objectMapper.writeValueAsString(json), HTTP.UTF_8));
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            System.out.println(entity.toString());
            return entity.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
