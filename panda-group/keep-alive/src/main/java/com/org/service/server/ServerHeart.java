package com.org.service.server;

import com.org.domain.Entity;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHeart extends Thread {
    private ServerSocket serverSocket = null;
    Object object = new Object();

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                Socket client = serverSocket.accept();
                synchronized (object) {
                    new Thread(new Client(client)).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("开始检查客户端是否在线.........");
        new ServerHeart().start();
    }
}

class Client implements Runnable {

    Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                ObjectInput in = new ObjectInputStream(socket.getInputStream());
                Entity entity = (Entity) in.readObject();
                System.out.println(entity.getName() + " : " + entity.getSex());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}