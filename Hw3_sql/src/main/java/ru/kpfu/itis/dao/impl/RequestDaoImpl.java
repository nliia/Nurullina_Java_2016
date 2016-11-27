package ru.kpfu.itis.dao.impl;

import ru.kpfu.itis.dao.RequestDao;
import ru.kpfu.itis.model.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.kpfu.itis.factory.ConnectionCreater.*;

public class RequestDaoImpl implements RequestDao {

    private Connection con = getConnection();
    private PreparedStatement ptmt = null;
    private ResultSet rs = null;
    private static final String ADD_REQUEST_QUERY = "INSERT INTO request(needy_id, address, latitude, longitude, created_at, service_type, status)" +
            " VALUES (?,?,?,?,?,?,?)";

    public void add(Request request) {
        try {
            ptmt = con.prepareStatement(ADD_REQUEST_QUERY);
            ptmt.setLong(1, request.getNeedyId());
            ptmt.setString(2, request.getAddress());
            ptmt.setFloat(3, request.getLatitude());
            ptmt.setFloat(4, request.getLongitude());
            ptmt.setTimestamp(5, request.getCreatedAt());
            ptmt.setString(6, request.getService_type());
            ptmt.setString(7, request.getStatus());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ptmt, con);
        }
    }
}
