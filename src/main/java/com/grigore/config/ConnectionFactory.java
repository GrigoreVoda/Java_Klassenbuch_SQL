package com.grigore.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                DbConfig.get("db.url"),
                DbConfig.get("db.user"),
                DbConfig.get("db.password")
        );

    }
}
