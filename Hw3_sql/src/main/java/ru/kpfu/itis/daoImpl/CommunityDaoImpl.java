package ru.kpfu.itis.daoImpl;

import ru.kpfu.itis.dao.CommunityDao;
import ru.kpfu.itis.factory.ConnectionFactory;
import ru.kpfu.itis.model.Community;
import ru.kpfu.itis.model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommunityDaoImpl implements CommunityDao {

    private Connection con = null;
    private PreparedStatement ptmt = null;
    private ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    public void update(Community community) {
        String query = "UPDATE community SET name = ?, description = ? WHERE id = ?";
        try {
            con = getConnection();
            ptmt = con.prepareStatement(query);
            ptmt.setString(1, community.getName());
            ptmt.setString(2, community.getDescription());
            ptmt.setLong(3, community.getId());
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

    @Override
    public Community findByName(String name) {
        String query = "SELECT * FROM news WHERE name = ?";
        Community community =  new Community();
        try {
            con = getConnection();
            ptmt = con.prepareStatement(query);
            ptmt.setString(1, name);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                community.setId(rs.getLong("id"));
                community.setFounder_id(rs.getLong("founder_id"));
                community.setName(name);
                community.setDescription(rs.getString("description"));
                community.setCreated_at(rs.getDate("created_at"));
            }


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
        return community;
    }
}
