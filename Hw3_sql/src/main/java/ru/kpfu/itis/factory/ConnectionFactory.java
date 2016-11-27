package ru.kpfu.itis.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String driverClassName = "org.postgresql.Driver";
    private final String connectionUrl = "jdbc:postgresql://localhost:5432/sql_practice";
    private final String dbUser = "postgres";
    private final String dbPsw = "postgres";

    private static ConnectionFactory connFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPsw);
        return conn;
    }

    public static ConnectionFactory getInstance(){
        if (connFactory == null) {
            connFactory = new ConnectionFactory();
        }
        return connFactory;
    }
}
