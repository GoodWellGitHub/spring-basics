package com.org.pool.psql.druid;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * https://github.com/java-rookie-233333/ConnectionPool
 */
public class DatabaseMain {
    public static void main(String[] args) throws SQLException {
        SupperDataSource dataSource = new SupperDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/panda");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setInitialSize(1);
        dataSource.setMaxIdle(20);
        Connection a = dataSource.getConnection();
        System.out.println(a.toString());
        //连接进行未进行关闭
        a.close();
        Connection b = dataSource.getConnection();
        System.out.println(b.toString());
    }
}
