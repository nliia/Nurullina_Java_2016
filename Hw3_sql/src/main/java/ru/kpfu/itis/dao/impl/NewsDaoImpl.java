package ru.kpfu.itis.dao.impl;

import ru.kpfu.itis.dao.NewsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.kpfu.itis.factory.ConnectionCreater.*;

public class NewsDaoImpl implements NewsDao {
    private Connection con = getConnection();
    private PreparedStatement ptmt = null;
    private ResultSet rs = null;
    private static final String UPDATE_NEWS_QUERY =  "UPDATE news SET text = ? WHERE id = ?";
    private static final String MESSAGES_BY_COMMUNITY_OF_FOUNDER_QUERY = "WITH newsCount AS (\n" +
            "    SELECT\n" +
            "      count(news.id) count,\n" +
            "      c.id,\n" +
            "      c.founder_id\n" +
            "    FROM news\n" +
            "      JOIN community c ON news.community_id = c.id\n" +
            "    GROUP BY c.id)\n" +
            "SELECT newsCount.count\n" +
            "FROM newsCount\n" +
            "WHERE founder_id = ?";
    public void update(String text, Long id) {
        try {
            ptmt = con.prepareStatement(UPDATE_NEWS_QUERY);
            ptmt.setString(1, text);
            ptmt.setLong(2, id);
            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ptmt, con);
        }
    }


    @Override
    public int allMessagesByCommunityOfFounder(Long founder_id) {
        int result = -1;
        try {
            ptmt = con.prepareStatement(MESSAGES_BY_COMMUNITY_OF_FOUNDER_QUERY);
            ptmt.setLong(1, founder_id);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, ptmt, con);
        }
        return result;
    }


}
