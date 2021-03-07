package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> orderLines;
    private BigDecimal totalOrderCost;

    public Order() {
        orderLines = new ArrayList<>();
        totalOrderCost = BigDecimal.ZERO;
    }

    public void addNewOrderLine(OrderLine orderLineToAdd) {
        if (isProductAlreadyInCart(orderLineToAdd.getProduct().getName())) {
            for (OrderLine line : orderLines) {
                if (line.getProduct().getName().equals(orderLineToAdd.getProduct().getName())) {
                    line.addQuantity(orderLineToAdd.getQuantity());
                }
            }
        } else {
            orderLines.add(orderLineToAdd);
        }
        totalOrderCost = totalOrderCost.add(orderLineToAdd.getTotalOrderLineCost());
    }

    public boolean isProductAlreadyInCart(String name) {
        for (OrderLine line : orderLines) {
            if (line.getProduct().getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

//    @Getter
//    public class Order {
//
//        private Map<Product, OrderLine> productOrderLines = new HashMap<>();
//        private BigDecimal totalCost;
//
//        public void addProduct(Product product) {
//            if (productOrderLines.containsKey(product)) {
//                productOrderLines.get(product).addOneProduct();
//            } else {
//                productOrderLines.put(product, OrderLine.newLineWith(product));
//            }
//            this.totalCost = this.totalCost.add(product.getPrice());
//        }
//
//    }
}
