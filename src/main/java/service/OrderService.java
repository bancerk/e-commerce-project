package service;

import dao.OrderDAO;
import model.Customer;
import model.Order;
import model.Product;

import java.math.BigDecimal;
import java.util.List;

public class OrderService {

    private static OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = new OrderDAO();
    }

    public static Order save(Customer customer, List<Product> products) {


        BigDecimal totalAmount = products.stream()
                .map(Product::getProductPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Order order = new Order();
        order.setProducts(products);
        order.setCustomer(customer);
        order.setOrderAmount(totalAmount);

        orderDAO.save(order);
        return order;
    }

}
