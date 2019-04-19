package com.org.pool.psql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConnectionPool {
    private LinkedList<Connection> connections=new LinkedList<Connection>();
    public ConnectionPool(){
        for (int i=0;i<10;i++){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/panda?useSSL=false","root","12345678");
                connections.add(connection);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
