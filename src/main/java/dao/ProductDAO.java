package dao;

import dao.constants.SqlScriptConstants;
import model.Product;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements BaseDAO<Product> {

    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.PRODUCT_SEARCH_BY_NAME);
            ps.setString(1, "%" + name + "%");
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

    @Override
    public void save(Product product) {

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.PRODUCT_SAVE)) {

            ps.setString(1, product.getProductName());
            ps.setBigDecimal(2, product.getProductPrice());
            ps.setInt(3, product.getProductStock());
            ps.setLong(4,product.getProductCategory().getId());
            ps.setLong(5,product.getCreatedUser().getId());
            ps.setLong(6,product.getUpdatedUser().getId());
            ps.setLong(7,product.getProductCategory().getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(long id) {

    }
}