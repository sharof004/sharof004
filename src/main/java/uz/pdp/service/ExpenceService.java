package uz.pdp.service;

import uz.pdp.DB.DBconnection;
import uz.pdp.model.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenceService {
    public void addExpence(Expense expense) {
        boolean chek = false;
        String sql = "INSERT INTO expenceis(name, user_id) VALUES (?, ?)";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, expense.getName());
            ps.setInt(2, expense.getPrice());
            ps.setInt(3, expense.getCategory_id());
            ps.executeUpdate();
            chek = true;
        } catch (SQLException e) {
            System.out.println(" category qo`shildi !!!");
        }
        if (chek == true) {
            System.out.println("category qo`shilmadi !!!");
        }
    }

    public List<Expense> getAllexpensies() {
        List<Expense> expenseis = new ArrayList<>();
        String sql = "SELECT * FROM expenceis";
        try (Connection conn = DBconnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                expenseis.add(new Expense(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("category_id"),
                        rs.getInt("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenseis;
    }
}
