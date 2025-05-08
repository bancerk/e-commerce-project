package dao;

import dao.constants.SqlScriptConstants;
import model.Customer;
import util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private final Customer customer = null;

    public static Customer findByEmail(String email) {

        Customer customer = null;


        try (Connection connection = DbUtil.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.CUSTOMER_EXIST_BY_EMAIL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setCustomerName(rs.getString("name"));
                customer.setCustomerEmail(rs.getString("email"));
                customer.setCustomerPassword(rs.getString("password"));
                customer.setcreateddate(new Timestamp(rs.getDate("createddate").getTime()).toLocalDateTime());
                customer.setupdateddate(new Timestamp(rs.getDate("updateddate").getTime()).toLocalDateTime());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void save(Customer customer) {

        try (Connection connection = DbUtil.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.CUSTOMER_SAVE);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerEmail());
            ps.setString(3, customer.getCustomerPassword());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Customer findById(long id) {

        Customer customer = new Customer();

        try (Connection connection = DbUtil.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.CUSTOMER_FIND_BY_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setCustomerName(rs.getString("name"));
                customer.setCustomerEmail(rs.getString("email"));
                customer.setcreateddate(new Timestamp(rs.getDate("createddate").getTime()).toLocalDateTime());
                customer.setupdateddate(new Timestamp(rs.getDate("updateddate").getTime()).toLocalDateTime());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> findAll() {

        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer();


        try (Connection connection = DbUtil.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SqlScriptConstants.CUSTOMER_FIND_ALL);

            while (rs.next()) {
                customer.setId(rs.getLong("id"));
                customer.setCustomerName(rs.getString("name"));
                customer.setCustomerEmail(rs.getString("email"));
                customer.setcreateddate(new Timestamp(rs.getDate("createddate").getTime()).toLocalDateTime());
                customer.setupdateddate(new Timestamp(rs.getDate("updateddate").getTime()).toLocalDateTime());
                customerList.add(customer);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public boolean existByEmail(String email) {

        try (Connection connection = DbUtil.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(SqlScriptConstants.CUSTOMER_EXIST_BY_EMAIL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}