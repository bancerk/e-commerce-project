package dao;

import dao.constants.SqlScriptConstants;
import model.Payment;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAO {

    public void save(Payment payment) {

        try (Connection connection = DbUtil.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.PAYMENT_SAVE);
            ps.setLong(1, payment.getOrder().getId());
            ps.setString(2, payment.getPaymentMethod().name());
            ps.setBigDecimal(3, payment.getPaymentAmount());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
