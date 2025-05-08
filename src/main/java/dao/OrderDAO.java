package dao;

import model.Order;

import java.sql.*;

public class OrderDAO {

    private static final String url = "jdbc:postgresql://localhost:5432/patika_store";
    private static final String user = "example";
    private static final String password = "example";

    private static final String saveScript= """
            INSERT INTO "/order" (customer_id,order_date,total_amount,createddate,updateddate)
            VALUES (?,?,?,?,?);
            """;

    public Order save(Order order){

        try (Connection connection = DriverManager.getConnection(url, user, password){
            PreparedStatement ps = connection.prepareStatement(saveScript);
            ps.setLong(1,order.getCustomer().getId());
//            ps.setDate(2,new java.sql.Date(order.getOrderDate().toEpochSecond()));
            ps.setBigDecimal(3,order.getOrderAmount());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
