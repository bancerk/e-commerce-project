package dao;

import dao.constants.SqlScriptConstants;
import model.Order;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OrderDAO {


    public Order save(Order order) {

        try (Connection connection = DbUtil.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.ORDER_SAVE);
            ps.setLong(1, order.getCustomer().getId());
            ps.setTimestamp(2, Timestamp.valueOf(order.getOrderDate()));
            ps.setBigDecimal(3, order.getOrderAmount());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}
