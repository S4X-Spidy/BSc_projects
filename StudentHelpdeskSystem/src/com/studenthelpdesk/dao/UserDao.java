package com.studenthelpdesk.dao;

import java.sql.*;
import com.studenthelpdesk.models.User;

public class UserDao {
    private Connection connection;

    public UserDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/helpdesk", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String username, String password) {
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
