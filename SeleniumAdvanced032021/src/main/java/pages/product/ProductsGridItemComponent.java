package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import pages.BasePage;

public class ProductsGridItemComponent extends BasePage {
    public ProductsGridItemComponent(WebDriver driver, WebElement item) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(item), this);
    }

    @FindBy(css = ".product-title")
    private WebElement productName;

    public ProductDetailsPage open() {
        productName.click();
        return new ProductDetailsPage(getDriver());
    }

}
