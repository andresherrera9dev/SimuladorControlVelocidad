package com.ITCelaya.simuladorcontrolvelocidad.DAO;

import com.ITCelaya.simuladorcontrolvelocidad.database.MySQLConnection;
import com.ITCelaya.simuladorcontrolvelocidad.models.User;


import java.sql.*;
import java.util.*;

public class UserDAO implements Dao<User> {
    @Override
    public Optional<User> findById(int id) {
        String query = "SELECT * FROM User WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                return Optional.of(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM User";

        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public boolean save(User record) {
        return false;
    }

    @Override
    public boolean update(User record) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}