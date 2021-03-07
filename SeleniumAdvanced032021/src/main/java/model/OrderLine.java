package model;

import java.math.BigDecimal;

public class OrderLine {
    private Product product;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.totalOrderLineCost = product.getPrice().multiply(new BigDecimal(quantity));
    }

    public OrderLine(Product product, int quantity, BigDecimal totalOrderLineCost) {
        this.product = product;
        this.quantity = quantity;
        this.totalOrderLineCost = totalOrderLineCost;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalOrderLineCost() {
        return totalOrderLineCost;
    }

    public void setTotalOrderLineCost(BigDecimal totalOrderLineCost) {
        this.totalOrderLineCost = totalOrderLineCost;
    }

    private int quantity;
    private BigDecimal totalOrderLineCost;

    public void addQuantity(int quantityToAdd) {
        quantity += quantityToAdd;
        totalOrderLineCost = product.getPrice().multiply(new BigDecimal(quantity));
    }
}
