package com.org.pool.psql.druid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ArrayBlockingQueue;

public class SupperPool {
    DatabaseConfiguration configuration;

    //已使用连接
    private ArrayBlockingQueue<SuperPoolConnection> use = new ArrayBlockingQueue<SuperPoolConnection>(1024);
    //未使用连接
    private ArrayBlockingQueue<SuperPoolConnection> duse = new ArrayBlockingQueue<SuperPoolConnection>(1024);

    private boolean initDriver = false;

    private SupperPool() {
    }

    private void initDriver() {
        try {
            Class.forName(configuration.getDriverClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        initDriver = true;
    }

    public SuperPoolConnection getConnection() {
        if (!initDriver) {
            initDriver();
        }
        Connection conn = null;
        SuperPoolConnection superPoolConnection = null;
        try {
            conn = DriverManager.getConnection(configuration.getJdbcUrl(), configuration.getUsername(), configuration.getPassword());
            superPoolConnection = new SuperPoolConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return superPoolConnection;
    }

    public void setUse(ArrayBlockingQueue<SuperPoolConnection> use) {
        this.use = use;
    }

    public void setDuse(ArrayBlockingQueue<SuperPoolConnection> duse) {
        this.duse = duse;
    }

    private static class Singleton {
        private static SupperPool supperPool;

        static {
            supperPool = new SupperPool();
        }

        public static SupperPool getInstance() {
            return supperPool;
        }
    }

    public static SupperPool getInstance() {
        return Singleton.getInstance();
    }

    public DatabaseConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(DatabaseConfiguration databaseConfiguration) {
        this.configuration = databaseConfiguration;
    }

    public SuperPoolConnection getSupperPoolConnection(long waitTime) throws InterruptedException {
        SuperPoolConnection superPoolConnection = null;
        while (true) {
            if (use.size() + duse.size() <= configuration.getMaxIdle()) {
                // 如果可用连接小于等于0那就新获取一个连接，返回之前把这个连接放到已用集合中去
                if (duse.size() <= 0) {
                    superPoolConnection = getConnection();
                    use.put(superPoolConnection);
                    return superPoolConnection;
                } else {
                    return duse.take();
                }
            } else {
                wait(waitTime);
            }
        }
    }

    public void addUse(SuperPoolConnection connection) {
        this.use.add(connection);
    }

    public void removeUse(SuperPoolConnection connection) {
        this.use.remove(connection);
    }

    public void addDuse(SuperPoolConnection connection) {
        this.duse.add(connection);
    }

    public ArrayBlockingQueue<SuperPoolConnection> getUse() {
        return use;
    }

    public ArrayBlockingQueue<SuperPoolConnection> getDuse() {
        return duse;
    }

    public void removeDuse(SuperPoolConnection connection) {
        this.duse.remove(connection);
    }
}
