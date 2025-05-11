package dao;

import dao.constants.SqlScriptConstants;
import model.Category;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAO implements BaseDAO<Category> {
    @Override
    public void save(Category category) {

        try (Connection connection = DbUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.CATEGORY_SAVE)) {

            ps.setString(1, category.getCategoryName());
            ps.setLong(2, category.getCreatedUser().getId());
            ps.setLong(3, category.getUpdatedUser().getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public static Category findById(long id) {

        Category category = null;

        try (Connection connection = DbUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.CATEGORY_FIND_BY_ID)) {

            category = null;

            ps.setString(1, category.getCategoryName());
            ps.setLong(2, category.getCreatedUser().getId());
            ps.setLong(3, category.getUpdatedUser().getId());

            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getLong("id"));
                category.setCategoryName(rs.getString("category_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public int delete(long id) {

        int affectedRowCount = 0;

        try (Connection connection = DbUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.CATEGORY_DELETE)) {

            ps.setLong(1, id);
            affectedRowCount = ps.executeUpdate();
            return affectedRowCount;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRowCount;
    }
}
