package com.org.service.main;

import com.org.domain.Entity;
import com.org.factory.Factory;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSender {
    private ClientSender() {
    }

    Socket socket = null;
    private static ClientSender sender;

    public static ClientSender getInstance() {
        if (sender == null) {
            synchronized (ClientSender.class) {
                if (sender == null) {
                    sender = new ClientSender();
                }
            }
        }
        return sender;
    }

    public void send() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            while (true) {
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                Entity entity = Factory.getEntity();
                outputStream.writeObject(entity);
                outputStream.flush();
                System.out.println("已发送..........");
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
