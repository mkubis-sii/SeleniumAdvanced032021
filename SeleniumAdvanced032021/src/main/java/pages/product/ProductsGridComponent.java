package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsGridComponent extends BasePage {
    public ProductsGridComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "article")
    private List<WebElement> allItems;

    public List<ProductsGridItemComponent> getAllItems() {
        return allItems
                .stream()
                .map(ProductsGridItemComponent::new)
                .collect(Collectors.toList());
    }

    public ProductsGridItemComponent getRandomItem() {
        return new ProductsGridItemComponent(getRandomElement(allItems));
    }



    // prostsza forma zapisu metody:
//    public List<ProductsGridItemComponent> getAllItems() {
//        List<ProductsGridItemComponent> items = new ArrayList<>();
//        for (WebElement item : allItems) {
//            items.add(new ProductsGridItemComponent(item));
//        }
//        return items;
//    }
}
