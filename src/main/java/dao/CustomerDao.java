package dao;

import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private final String url = "jdbc:postgresql://localhost:5432/patika_store";


    private final String saveScript = """
            INSERT INTO customer(name,email,password) VALUES(?,?,?);
            """;

    private final String findByIdScript = """
            SELECT * FROM customer WHERE id = ?;
            """;

    private final String findAllScript = """
            SELECT * FROM customer;
            """;

    public void save(Customer customer) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            PreparedStatement ps = connection.prepareStatement(saveScript);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerEmail());
            ps.setString(3, customer.getCustomerPassword());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Customer findById(long id) {

        Customer customer = new Customer();

        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(findAllScript);

            PreparedStatement ps = connection.prepareStatement(findByIdScript);
            ps.setLong(1, id);

            while (rs.next()) {
                customer.setId(rs.getLong("id"));
                customer.setCustomerName(rs.getString("name"));
                customer.setCustomerEmail(rs.getString("email"));
                //customer.setCreationDate(rs.getDate("createddate"));
                //customer.setUpdatedDate(rs.getDate("updateddate"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    public List<Customer> findAll() {

        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer();


        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(findAllScript);

            while (rs.next()) {
                customer.setId(rs.getLong("id"));
                customer.setCustomerName(rs.getString("name"));
                customer.setCustomerEmail(rs.getString("email"));
                //customer.setCreationDate(rs.getDate("createddate"));
                //customer.setUpdatedDate(rs.getDate("updateddate"));

                customerList.add(customer);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }
}