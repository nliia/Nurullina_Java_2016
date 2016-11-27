package ru.kpfu.itis.daoImpl;

import ru.kpfu.itis.dao.RequestDao;
import ru.kpfu.itis.factory.ConnectionFactory;
import ru.kpfu.itis.model.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestDaoImpl implements RequestDao {

    private Connection con = null;
    private PreparedStatement ptmt = null;
    private ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    public void add(Request request) {
        String query = "INSERT INTO request(needy_id, address, latitude, longitude, created_at, service_type, status) VALUES (?,?,?,?,?,?,?)";
        try {
            con = getConnection();
            ptmt = con.prepareStatement(query);
            ptmt.setLong(1, request.getNeedy_id());
            ptmt.setString(2, request.getAddress());
            ptmt.setFloat(3, request.getLatitude());
            ptmt.setFloat(4, request.getLongitude());
            ptmt.setTimestamp(5, request.getCreated_at());
            ptmt.setString(6, request.getService_type());
            ptmt.setString(7, request.getStatus());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
}
