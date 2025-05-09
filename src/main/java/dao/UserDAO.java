package dao;

import dao.constants.SqlScriptConstants;
import model.User;
import model.enums.Role;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements BaseDAO<User> {

    @Override
    public void save(User user) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.USER_SAVE)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole().name());
            ps.setBoolean(4,user.getActive());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(long id) {

    }

    public User findByUserName(String userName) {
        User user = null;
        try (Connection connection = DbUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.USER_FIND_BY_NAME)) {

            ps.setString(1,userName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setActive(rs.getBoolean("active"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return user;

    }
}
