package ru.kpfu.itis.daoImpl;

import ru.kpfu.itis.dao.NewsDao;
import ru.kpfu.itis.factory.ConnectionFactory;
import ru.kpfu.itis.model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsDaoImpl implements NewsDao {
    private Connection con = null;
    private PreparedStatement ptmt = null;
    private ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    public void update(String text, Long id) {
        String query = "UPDATE news SET text = ? WHERE id = ?";
        try {
            con = getConnection();
            ptmt = con.prepareStatement(query);

            ptmt.setString(1, text);
            ptmt.setLong(2, id);
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
    public int allMessagesByCommunityOfFounder(Long founder_id) {
        String query = "WITH newsCount AS (\n" +
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
        int result = -1;
        try {
            con = getConnection();
            ptmt = con.prepareStatement(query);
            ptmt.setLong(1, founder_id);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
