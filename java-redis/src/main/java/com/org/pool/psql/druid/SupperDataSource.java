package com.org.pool.psql.druid;

import com.org.pool.psql.util.StringUtils;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.PooledConnection;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class SupperDataSource extends ResourceManagement implements DataSource, ConnectionPoolDataSource {

    protected volatile String username;
    protected volatile String password;
    protected volatile String jdbcUrl;
    protected volatile String driverClass;
    protected volatile int initialSize = 0;
    protected volatile int minIdle = 0;
    protected volatile int maxIdle = 0;
    protected volatile int maxActive = 0;
    protected volatile long maxWait = 0;
    protected volatile long waitTime = 1000l;

    private SupperPool supperPool = SupperPool.getInstance();

    public SupperDataSource() {
    }

    public SupperDataSource(String username, String password, String jdbcUrl) {
        super();
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }


    public PooledConnection getPooledConnection() throws SQLException {
        SuperPoolConnection superPoolConnection = getSuperPoolConnection();
        if (superPoolConnection != null) {
            return superPoolConnection;
        } else {
            throw new UnsupportedOperationException("not support ");
        }
    }

    public SuperPoolConnection getSuperPoolConnection() {
        init();
        try {
            return supperPool.getSupperPoolConnection(getWaitTime());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public PooledConnection getPooledConnection(String user, String password) throws SQLException {
        if (username != null && password != null && username == null && password == null) {
            this.username = username;
            this.password = password;
            return getPooledConnection();
        }
        if (!StringUtils.equals(username, this.username)) {
            throw new UnsupportedOperationException("Not supporte superDatasource");
        }
        if (!StringUtils.equals(password, this.password)) {
            throw new UnsupportedOperationException("not support superDataSource");
        }
        return getPooledConnection();
    }

    public Connection getConnection() throws SQLException {
        SuperPoolConnection superPoolConnection = getSuperPoolConnection();
        if (superPoolConnection != null) {
            return superPoolConnection;
        } else {
            throw new UnsupportedOperationException("Not supported by SupperDatasource");
        }
    }

    public Connection getConnection(String username, String password) throws SQLException {
        if (username != null && password != null && username == null && password == null) {
            this.username = username;
            this.password = password;
            return getConnection();
        }
        if (!StringUtils.equals(username, this.username)) {
            throw new UnsupportedOperationException("Not supporte superDatasource");
        }
        if (!StringUtils.equals(password, this.password)) {
            throw new UnsupportedOperationException("not support superDataSource");
        }
        return getConnection();
    }

    public void close() throws SQLException {
        for (Connection connection : supperPool.getUse()) {
            connection.close();
        }
        supperPool.setUse(null);
        for (Connection connection : supperPool.getDuse()) {
            connection.close();
        }
        supperPool.setDuse(null);
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    public void setLoginTimeout(int seconds) throws SQLException {

    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public long getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(long maxWait) {
        this.maxWait = maxWait;
    }

    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    public SupperPool getSupperPool() {
        return supperPool;
    }

    public void setSupperPool(SupperPool supperPool) {
        this.supperPool = supperPool;
    }

    private void init() {
        if (supperPool.getConfiguration() == null) {
            DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
            databaseConfiguration.setDriverClass(getDriverClass());
            databaseConfiguration.setJdbcUrl(getJdbcUrl());
            databaseConfiguration.setInitialSize(getInitialSize());
            databaseConfiguration.setMaxActive(getMaxActive());
            databaseConfiguration.setMaxIdle(getMaxIdle());
            databaseConfiguration.setMaxWait(getMaxWait());
            databaseConfiguration.setMinIdle(getMinIdle());
            databaseConfiguration.setPassword(getPassword());
            databaseConfiguration.setUsername(getUsername());
            supperPool.setConfiguration(databaseConfiguration);
        }
    }
}
