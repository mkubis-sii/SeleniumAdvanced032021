import model.Order;
import org.testng.annotations.Test;
import pages.product.ProductDetailsPage;
import pages.product.ProductsGridComponent;
import pages.product.ProductsGridItemComponent;

import java.util.Random;

public class CartTests extends TestBase{

    @Test
    public void shouldDisplayCorrectProductsInCart(){

        Random rnd = new Random();
        getDriver().get("http://5.196.7.235/");
        Order expectedOrder = new Order();

        new ProductsGridComponent(getDriver())
                .getRandomItem()
                .open();


        ProductDetailsPage prodPage =  new ProductDetailsPage(getDriver());
        prodPage.setQuantity(rnd.nextInt(5)+1); // 1-6
        prodPage.addToBasket(expectedOrder);
    }
}
