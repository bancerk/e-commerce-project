package dao;

import model.Product;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private static final String url = "jdbc:postgresql://localhost:5432/patika_store";
    private static final String user = "example";
    private static final String password = "example";

    private static final String searchByNameScript = """
            SELECT * FROM product WHERE name LIKE ?;
            """;

    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);) {
            PreparedStatement ps = connection.prepareStatement(searchByNameScript);
            ps.setString(1,"%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getLong("id"));
                p.setProductName(rs.getString("name"));
                p.setProductPrice(rs.getBigDecimal("price"));
                p.setProductStock(rs.getInt("stock"));
                p.setcreateddate(LocalDateTime.parse(rs.getString("createddate")));
                p.setupdateddate(LocalDateTime.parse(rs.getString("updateddate")));
                products.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}