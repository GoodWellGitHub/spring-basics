package com.org.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JDKHttp {
    private static String uri = "http://localhost:8888/message";

    public static void main(String[] args) {
        doJDKUrlGet();
    }

    public static String doJDKUrlGet() {
        try {
            URL url = new URL(uri + "/get?name=林黛玉&age=18");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            urlConnection.setRequestProperty("Authorization", "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoyMTI3OTU3LCJyZWZfZXhwIjoxNTUzNDk0MzA5LCJhdWQiOiJZVFV3TTJSa1ltRXlZek5tTWpWak1tSXpaakE1WlRWaSIsImFwcG5hbWUiOiJiZWxsZXRvbmUiLCJpc3MiOiJlcHAiLCJuYW1lX2NuIjoiXHU1MjE4XHU2ZDBiXHU2ZDBiIiwidGhpcmRfaWQiOiIxODA4OTI1NzAiLCJhdmF0YXIiOiIiLCJleHAiOjE1NTI4ODk1MDksInRlbF9ubyI6IjE1MjEwNTM5OTIwIiwiZGVwYXJ0bWVudCI6Ilx1NTI0ZFx1N2FlZlx1N2VjNCIsImlhdCI6MTU1MjI4NDcwOSwibmFtZSI6IiJ9.pRHiu8aq_viQPD7bM2ip48N-Kxv9O0Qil9wE5-ShkNqforgkOhDN7u6TDK8VV9LnQcMdbimEXb_i0bXTlvcd6vXQSzoSnvTcj-8_MCN6ofSpzvKvESOz8isrAIMdIOtuKvQour2hBnFtU4EY9yVvTWIV812s4xlIm3SRKOv6Pn1zwXAFqzkASPYqKa4tXQcIOv48HGjAvjVpl_ADvANdsurK1hEuFQsG6Mpes9O0M80EGBW4aJuYegbMOdsTZnBsbTLWoJC899YiYcZhW12gOieAmUoFP1JuRmi5yUt-2nBtzxloiYF7FZvDpn0lCK_vT6eIZBbw0NTIyWrwqazVxQ");
            urlConnection.connect();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = null;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line + "\n");
            }
            urlConnection.disconnect();
            return result.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
