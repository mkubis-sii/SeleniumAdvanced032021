package model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    List<OrderLine> orderLines;
    BigDecimal totalOrderCost;

    public void addNewOrderLine(OrderLine orderLineToAdd){
        if (isProductAlreadyInCart(orderLineToAdd.product.name)) {
            for (OrderLine line : orderLines){
                if(line.product.name.equals(orderLineToAdd.product.name)){
                    line.quantity.add(orderLineToAdd.quantity);
                }
            }
        } else{
            orderLines.add(orderLine);
        }
        totalOrderCost = totalOrderCost.add(orderLine.totalOrderLineCost);
    }

    public boolean isProductAlreadyInCart(String name){
        for (OrderLine line : orderLines){
            if(line.product.name.equals(name)){
                return true;
            }
        }
        return false;
    }
}
