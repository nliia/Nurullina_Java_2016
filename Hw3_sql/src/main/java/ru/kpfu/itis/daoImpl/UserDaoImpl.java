package ru.kpfu.itis.daoImpl;

import ru.kpfu.itis.dao.UserDao;
import ru.kpfu.itis.factory.ConnectionFactory;
import ru.kpfu.itis.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection con = null;
    private PreparedStatement ptmt = null;
    private ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    public void add(User user) {
        String query = "INSERT INTO users (name, surname, email, password, role, status) VALUES (?,?,?,?,?,?)";
        try {
            con = getConnection();
            ptmt = con.prepareStatement(query);
            ptmt.setString(1, user.getName());
            ptmt.setString(2, user.getSurname());
            ptmt.setString(3, user.getEmail());
            ptmt.setString(4, user.getPassword());
            ptmt.setString(5, user.getRole());
            ptmt.setString(6, user.getStatus());
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
    public List mostActiveRecipientOfSeason(String season) {
        List nameList = new ArrayList<>();
        try {
            String query = "WITH u_mes_count AS (SELECT\n" +
                    "                       u.id,\n" +
                    "                       u.name,\n" +
                    "                       count(m.id) count\n" +
                    "                     FROM users u\n" +
                    "                       LEFT JOIN message m ON u.id = m.recipient_id\n" +
                    "                     WHERE\n" +
                    "                       extract(MONTH FROM m.created_at) = CAST(? as DOUBLE PRECISION) OR\n" +
                    "                       extract(MONTH FROM m.created_at) = CAST(? as DOUBLE PRECISION) OR extract(MONTH FROM m.created_at) = CAST(? as DOUBLE PRECISION) \n" +
                    "                     GROUP BY u.id)\n" +
                    "SELECT name\n" +
                    "FROM u_mes_count\n" +
                    "WHERE u_mes_count.count = (SELECT max(u_mes_count.count)\n" +
                    "                           FROM u_mes_count)";
            con = getConnection();
            if (season.equals("весна")) {
                ptmt = con.prepareStatement(query);
                ptmt.setString(1, "03");
                ptmt.setString(2, "04");
                ptmt.setString(3, "05");
                rs = ptmt.executeQuery();
                while (rs.next()) {
                    nameList.add(rs.getString("name"));
                }
            }
            if (season.equals("лето")) {
                ptmt = con.prepareStatement(query);
                ptmt.setString(1, "06");
                ptmt.setString(2, "07");
                ptmt.setString(3, "08");
                rs = ptmt.executeQuery();
                while (rs.next()) {
                    nameList.add(rs.getString("name"));
                }
            }
            if (season.equals("осень")) {
                ptmt = con.prepareStatement(query);
                ptmt.setString(1, "09");
                ptmt.setString(2, "10");
                ptmt.setString(3, "11");
                rs = ptmt.executeQuery();
                while (rs.next()) {
                    nameList.add(rs.getString("name"));
                }
            }
            if (season.equals("зима")) {
                ptmt = con.prepareStatement(query);
                ptmt.setString(1, "12");
                ptmt.setString(2, "01");
                ptmt.setString(3, "02");
                rs = ptmt.executeQuery();
                while (rs.next()) {
                    nameList.add(rs.getString("name"));
                }
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
        return nameList;
    }

    @Override
    public List mostActiveVolunteerOfAddress(String addressRegEx) {
        String query = "WITH u_r AS (SELECT u.id, u.name, count(r.id) count\n" +
                "FROM users u LEFT JOIN request r ON u.id = r.volunteer_id\n" +
                "  WHERE r.address like ?\n" +
                "GROUP BY u.id)\n" +
                "SELECT u_r.id, u_r.name\n" +
                "FROM u_r WHERE u_r.count = (SELECT max(u_r.count) FROM u_r)";
        List volunteers = new ArrayList<>();
        try {
            con = getConnection();
            ptmt = con.prepareStatement(query);
            ptmt.setString(1, "%" + addressRegEx + "%");
            rs = ptmt.executeQuery();
            while (rs.next()) {
                volunteers.add(rs.getString("name"));
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
        return volunteers;
    }


}
