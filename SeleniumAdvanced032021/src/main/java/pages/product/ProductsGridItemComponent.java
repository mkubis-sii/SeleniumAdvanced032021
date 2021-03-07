package pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ProductsGridItemComponent {
    public ProductsGridItemComponent(WebElement item) {
        PageFactory.initElements(new DefaultElementLocatorFactory(item), this);
    }
    
}
