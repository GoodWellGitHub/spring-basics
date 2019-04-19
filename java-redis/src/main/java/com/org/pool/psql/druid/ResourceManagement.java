package com.org.pool.psql.druid;

import java.sql.SQLException;
import java.sql.Wrapper;

public class ResourceManagement extends LogResourceManagement implements Wrapper {
    public ResourceManagement() {
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }
}
