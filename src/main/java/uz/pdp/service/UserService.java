package uz.pdp.service;

import uz.pdp.DB.DBconnection;
import uz.pdp.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public void register(User user) {
        boolean chek = false;
        String sql = "INSERT INTO users(name, username, password) VALUES (?, ?, ?)";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            chek = true;
        } catch (SQLException e) {
            System.out.println(" Register qilinmadi bunaqa usernameli foydalanuvchi mavjud !!!");
        }
        if (chek) {
            System.out.println("User muvaffaqiyatli ro`yxatdan o`tdi !!!");
        }
    }

    public User login(List<User> users,String username , String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
            String sql = "SELECT * FROM users";
            try (Connection conn = DBconnection.getConnection();
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(sql)) {
           while (rs.next()) {
           users.add(new User(
           rs.getInt("id"),
           rs.getString("name"),
           rs.getString("name"),
           rs.getString("password")
           ));
           }

           } catch (SQLException e) {
                e.printStackTrace();
            }
        return users;
           }
}