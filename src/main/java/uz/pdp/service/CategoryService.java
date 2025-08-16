package uz.pdp.service;

import uz.pdp.DB.DBconnection;
import uz.pdp.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    public void addCategory(Category category) {
        boolean chek = false;
        String sql = "INSERT INTO categories(name, user_id) VALUES (?, ?)";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category.getName());
            ps.setInt(2, category.getUser_id());
            ps.executeUpdate();
            chek = true;
        } catch (SQLException e) {
            System.out.println(" category qo`shildi !!!");
        }
        if (chek == true) {
            System.out.println("category qo`shilmadi !!!");
        }
    }

    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        try (Connection conn = DBconnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categories.add(new Category(
                        rs.getInt("user_id"),
                        rs.getInt("id"),
                        rs.getString("name")
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
