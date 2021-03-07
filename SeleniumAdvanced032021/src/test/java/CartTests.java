import model.Order;
import org.testng.annotations.Test;
import pages.product.ProductDetailsPage;
import pages.product.ProductsGridComponent;

import java.util.Random;

public class CartTests extends TestBase {

    @Test
    public void shouldDisplayCorrectProductsInCart() {
        Order expectedOrder = new Order();

        getDriver().get("http://5.196.7.235/");

        new ProductsGridComponent(getDriver())
                .getRandomItem()
                .open();

        ProductDetailsPage prodPage = new ProductDetailsPage(getDriver());
        prodPage.setQuantity(new Random().nextInt(5) + 1); // 1-6
        prodPage.addToBasket(expectedOrder);

    }
}
