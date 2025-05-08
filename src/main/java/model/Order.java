package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order extends BaseModel {

    private Customer customer;
    private BigDecimal orderAmount;
    private LocalDateTime orderDate;
    private List<Product> products;

    public Order() {
        this.orderDate = LocalDateTime.now();
    }

    public Order(Customer customer) {
        this.customer = customer;
        this.orderDate = LocalDateTime.now();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderTotalAmount) {
        this.orderAmount = orderTotalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
