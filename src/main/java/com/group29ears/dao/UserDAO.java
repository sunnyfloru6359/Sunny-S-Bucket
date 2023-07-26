package com.group29ears.dao;

import com.group29ears.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    
    public UserDAO() {
    }


    public void insertUser(User user) {
        try (Connection connection = DB.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, email, country) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        User user = null;
        try (Connection connection = DB.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, email, country FROM users WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DB.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DB.getCon();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id=?")) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) {
        boolean rowUpdated = false;
        try (Connection connection = DB.getCon();
             PreparedStatement statement = connection.prepareStatement("UPDATE users SET name=?, email=?, country=? WHERE id=?")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        ex.printStackTrace();
        System.err.println("SQLState: " + ex.getSQLState());
        System.err.println("Error Code: " + ex.getErrorCode());
        System.err.println("Message: " + ex.getMessage());
        Throwable t = ex.getCause();
        while (t != null) {
            System.out.println("Cause: " + t);
            t = t.getCause();
        }
    }
}
