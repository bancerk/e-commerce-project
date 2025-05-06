package model;

import model.enums.PaymentMethod;

import java.math.BigDecimal;

public class Payment extends BaseModel {

    private Order order;
    private PaymentMethod paymentMethod;
    private BigDecimal paymentAmount;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Payment(Order order, PaymentMethod paymentMethod, BigDecimal paymentAmount) {
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }
}
