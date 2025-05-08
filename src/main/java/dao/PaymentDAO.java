package dao;

import model.Payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAO {

    private static final String url = "jdbc:postgresql://localhost:5432/patika_store";
    private static final String user = "example";
    private static final String password = "example";

    private final String saveScript = """
            INSERT INTO payment (order_id, payment_method, payment_amount)
            VALUES (?,?,?);
            """;

    public void save(Payment payment) {

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            PreparedStatement ps = connection.prepareStatement(saveScript);
            ps.setLong(1, payment.getOrder().getId());
            ps.setString(2, payment.getPaymentMethod().name());
            ps.setBigDecimal(3, payment.getPaymentAmount());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
