package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order extends BaseModel {

    private Customer customer;
    private BigDecimal orderAmount;
    private LocalDateTime orderDate;

    public Order(Customer customer) {
        this.customer = customer;
        this.orderDate = LocalDateTime.now();
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
