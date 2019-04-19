package com.org.http;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
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
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApachSendMessage {
    private static String bailing3 = "https://ecloud.belle.net.cn/api/sky_server_data_app/push/hh_push_im";
    private static String accessTokenURL = "https://open.belle.net.cn/cgi/token/get";
    private static String bailing4 = "https://open.belle.net.cn/cgi/message/send";

    private static CloseableHttpClient client = HttpClientBuilder.create().build();

    public static void main(String[] args) {
/*        String result = postMessageV3();
        System.out.println("#############");
        System.out.println(result);*/

/*        Map<String, String> value = Maps.newHashMap();
        value.put("app_key", "ODkxZGQ3YTI0YTJlNDJkZDYxZWRkNmFk");
        value.put("app_secret", "MDNiYmZhZGM3NjAwZGJlZjFiYzQ4OGQy");
        String access = getAccessToken(value);
        System.out.println(access);*/

        String result = sendMessageV4();
        System.out.println(result);
    }

    static String postMessageV3() {
        String result = "";
        HttpPost post = new HttpPost(bailing3);
        post.setHeader("token", "f59633c5689555b795865ec9b426e4c1");
        post.setHeader("bundle", "belletone");
        List<NameValuePair> pairs = Lists.newArrayList();
        Map<String, String> value = Maps.newHashMap();
        value.put("app_id", "1438");
        value.put("user_ids", JSON.toJSONString(Arrays.asList("2157025")));
        //value.put("lapp_login_name",JSON.toJSONString(Arrays.asList("190199219")));
        value.put("message", "消息推送");
        value.put("content", "消息推送测试，如果收到，请忽略");
        value.put("msg_type", "10");
        value.put("app_key", "YTUwM2RkYmEyYzNmMjVjMmIzZjA5ZTVi");
        value.put("pic", "https://inews.gtimg.com/newsapp_bt/0/8242769487/1000");
        value.put("source", "topsport");
        pairs = getNameValue(value);
        try {
            post.setEntity(new UrlEncodedFormEntity(pairs, HTTP.UTF_8));
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            System.out.println(entity.toString());
            result = getEntityString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String getAccessToken(Map<String, String> keyValue) {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();
        if (!CollectionUtils.isEmpty(keyValue)) {
            stringBuilder.append("?");
            Iterator iterator = keyValue.entrySet().iterator();
            Map.Entry entry00 = (Map.Entry) iterator.next();
            append(stringBuilder, entry00);
            while (iterator.hasNext()) {
                stringBuilder.append("&");
                Map.Entry entry = (Map.Entry) iterator.next();
                append(stringBuilder, entry);
            }
        }
        HttpGet httpGet = new HttpGet(accessTokenURL + stringBuilder.toString());
        try {
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            result = getEntityString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String sendMessageV4() {
        String reslut = "";
        String para = "?access_token=9c79fea64f9111e99cbd02420a000621";
        HttpPost post = new HttpPost(bailing4 + para);
        post.setHeader(HTTP.CONTENT_TYPE, "application/json");
        Message message = Message.builder()
                .app_id("5xq3oy41jn")
                .portal("PnA3PvrV")
                .msgtype("text")
                .touser(Arrays.asList("n019wdylgnrm6xl3"))
                .msg(MessageInfo.builder().content("测试消息推送,如果收到，请自动忽略").message("测试消息推送").build())
                .build();
        try {
            String xx=JSON.toJSONString(message);
            post.setEntity(new StringEntity(xx,HTTP.UTF_8));
            HttpResponse response = client.execute(post);
            reslut = getEntityString(response.getEntity());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reslut;
    }

    static void append(StringBuilder stringBuilder, Map.Entry entry) {
        stringBuilder.append(entry.getKey());
        stringBuilder.append("=");
        stringBuilder.append(entry.getValue());
    }

    static String getEntityString(HttpEntity entity) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    static List<NameValuePair> getNameValue(Map<String, String> value) {
        return value.entrySet().stream().map(entry -> {
            return new BasicNameValuePair(entry.getKey(), entry.getValue());
        }).collect(Collectors.toList());
    }

}
