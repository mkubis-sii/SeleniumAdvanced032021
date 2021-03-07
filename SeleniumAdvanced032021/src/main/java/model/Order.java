package model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private List<OrderLine> orderLines;
    private BigDecimal totalOrderCost;

    public void addNewOrderLine(OrderLine orderLineToAdd){
        if (isProductAlreadyInCart(orderLineToAdd.getProduct().getName())) {
            for (OrderLine line : orderLines){
                if(line.getProduct().getName().equals(orderLineToAdd.getProduct().getName())){
                    line.addQuantity(orderLineToAdd.getQuantity());
                }
            }
        } else{
            orderLines.add(orderLineToAdd);
        }
        totalOrderCost = totalOrderCost.add(orderLineToAdd.getTotalOrderLineCost());
    }

    public boolean isProductAlreadyInCart(String name){
        for (OrderLine line : orderLines){
            if(line.getProduct().getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
