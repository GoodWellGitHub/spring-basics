package com.org.client;

import java.io.IOException;
import java.net.Socket;

/**
 * 模仿redis客户端
 */
public class RedisClient {
    private Socket socket;

    public RedisClient() {
        try {
            socket = new Socket("127.0.0.1", 6379);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String set(final String key, final String value) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*3").append("\r\n");
        stringBuilder.append("$3").append("\r\n");
        stringBuilder.append("set").append("\r\n");
        stringBuilder.append("$").append(key.getBytes().length).append("\r\n");
        stringBuilder.append(key).append("\r\n");
        stringBuilder.append("$").append(value.getBytes().length).append("\r\n");
        stringBuilder.append(value).append("\r\n");
        socket.getOutputStream().write(stringBuilder.toString().getBytes());
        byte[] b = new byte[2048];
        socket.getInputStream().read(b);
        return new String(b);
    }

    public String get(final String key) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("*2").append("\r\n");
        sb.append("$3").append("\r\n");
        sb.append("get").append("\r\n");
        sb.append("$").append(key.getBytes().length).append("\r\n");
        sb.append(key).append("\r\n");
        socket.getOutputStream().write(sb.toString().getBytes());
        byte[] bytes = new byte[2048];
        socket.getInputStream().read(bytes);
        return new String(bytes);
    }

    public static void main(String[] args) {
        RedisClient client = new RedisClient();
        try {
/*            String result = client.set("good", "morning");
            System.out.println(result);*/
            String reslut = client.get("good");
            System.out.println(reslut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
