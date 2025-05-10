package dao;

import dao.constants.SqlScriptConstants;
import model.Category;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class categoryDAO implements BaseDAO<Category> {
    @Override
    public void save(Category category) {

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.CATEGORY_SAVE)) {

            ps.setString(1, category.getCategoryName());
            ps.setLong(2, category.getCreatedUser().getId());
            ps.setLong(3, category.getUpdatedUser().getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category findById(long id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(long id) {

    }
}
