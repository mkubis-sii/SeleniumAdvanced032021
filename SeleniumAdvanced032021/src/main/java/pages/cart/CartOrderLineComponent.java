package pages.cart;

import model.OrderLine;
import model.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.math.BigDecimal;

public class CartOrderLineComponent {
    public CartOrderLineComponent(WebElement orderLine) {
        PageFactory.initElements(new DefaultElementLocatorFactory(orderLine), this);
    }

    @FindBy(css = "a.label")
    private WebElement name;

    @FindBy(css = "input")
    private WebElement quantity;

    @FindBy(css = "span.product-price")
    private WebElement totalPrice;

    @FindBy(css = "span.price")
    private WebElement price;

    public String getName() {
        return name.getText();
    }

    public int getQuantity() {
        return Integer.parseInt(quantity.getAttribute("value"));
    }

    public BigDecimal getPrice() {
        return new BigDecimal(price.getText().replace("$", ""));
    }

    public BigDecimal getTotalPrice() {
        return new BigDecimal(totalPrice.getText().replace("$", ""));
    }

    public OrderLine toOrderLine() {
        return new OrderLine(new Product(getPrice(), getName()),
                getQuantity(), getTotalPrice());
    }
}
