package ru.kpfu.itis.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static jdk.nashorn.internal.objects.Global.exit;

public class ConnectionFactory {
    private static String url = null;
    private static String username = null;
    private static String password = null;
    private static ConnectionFactory connFactory = null;

    private ConnectionFactory() {
        try (InputStream in = ConnectionFactory.class
                .getClassLoader().getResourceAsStream("database.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException ex) {
            exit(ex, "Failed to load properties");
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static ConnectionFactory getInstance() {
        if (connFactory == null) {
            connFactory = new ConnectionFactory();
        }
        return connFactory;
    }
}
