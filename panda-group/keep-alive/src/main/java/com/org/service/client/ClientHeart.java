package com.org.service.client;

import com.org.service.main.ClientSender;

public class ClientHeart extends Thread {
    @Override
    public void run() {
        try {
            ClientSender.getInstance().send();
            synchronized (ClientHeart.class) {
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClientHeart clientHeart = new ClientHeart();
        clientHeart.start();
    }
}
