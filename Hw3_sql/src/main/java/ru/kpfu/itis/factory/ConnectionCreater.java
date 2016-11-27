package ru.kpfu.itis.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionCreater {
    public static Connection getConnection() {
        return ConnectionFactory.getInstance().getConnection();
    }

    public static void closeResources(ResultSet rs, PreparedStatement ptmt, Connection con) {
        try {
            if (rs != null)
                rs.close();
            if (ptmt != null)
                ptmt.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
