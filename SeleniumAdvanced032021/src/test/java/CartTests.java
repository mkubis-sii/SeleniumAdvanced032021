import model.Order;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.cart.CartPage;
import pages.product.ProductDetailsPage;
import pages.product.ProductsGridComponent;

import java.util.Random;

public class CartTests extends TestBase {

    @Test
    public void shouldDisplayCorrectProductsInCart() {
        Order expectedOrder = new Order();

        for (int i = 0; i < 10; i++) {
            getDriver().get("http://5.196.7.235/");

            new ProductsGridComponent(getDriver())
                    .getRandomItem()
                    .open();

            ProductDetailsPage prodPage = new ProductDetailsPage(getDriver());
            prodPage.setQuantity(new Random().nextInt(5) + 1); // 1-6
            prodPage.addToBasket(expectedOrder);
        }

        getDriver().get("http://5.196.7.235/cart");
        CartPage cartPage = new CartPage(getDriver());
        Order orderDisplayedInCart = cartPage.toOrder();

        Assertions.assertThat(orderDisplayedInCart)
                .isEqualToComparingFieldByFieldRecursively(expectedOrder);
    }

    @Test
    public void addFirstProductToBasket() {
        Order expectedOrder = new Order();
        getDriver().get("http://5.196.7.235/");
        new ProductsGridComponent(getDriver())
                .getAllItems()
                .get(1)
                .open();

        ProductDetailsPage prodPage = new ProductDetailsPage(getDriver());
        prodPage.setQuantity(new Random().nextInt(5) + 1); // 1-6
        prodPage.addToBasket(expectedOrder);

    }
}
