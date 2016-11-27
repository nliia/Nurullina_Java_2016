package ru.kpfu.itis.dao.impl;

import ru.kpfu.itis.dao.CommunityDao;
import ru.kpfu.itis.model.Community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.kpfu.itis.factory.ConnectionCreater.*;

public class CommunityDaoImpl implements CommunityDao {

    private Connection con = getConnection();
    private PreparedStatement ptmt = null;
    private ResultSet rs = null;
    private static final String UPDATE_COMMUNITY_QUERY = "UPDATE community SET name = ?, description = ? WHERE id = ?";
    private static final String FIND_BY_NAME_QUERY = "SELECT * FROM news WHERE name = ?";

    public void update(Community community) {
        try {
            ptmt = con.prepareStatement(UPDATE_COMMUNITY_QUERY);
            ptmt.setString(1, community.getName());
            ptmt.setString(2, community.getDescription());
            ptmt.setLong(3, community.getId());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ptmt, con);
        }
    }

    @Override
    public Community findByName(String name) {
        Community community = new Community();
        try {
            ptmt = con.prepareStatement(FIND_BY_NAME_QUERY);
            ptmt.setString(1, name);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                community.setId(rs.getLong("id"));
                community.setFounderId(rs.getLong("founder_id"));
                community.setName(name);
                community.setDescription(rs.getString("description"));
                community.setCreatedAt(rs.getDate("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ptmt, con);
        }
        return community;
    }
}
