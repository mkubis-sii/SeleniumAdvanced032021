import model.Order;
import org.testng.annotations.Test;
import pages.product.ProductDetailsPage;
import pages.product.ProductsGridComponent;
import pages.product.ProductsGridItemComponent;

public class CartTests extends TestBase{

    @Test
    public void shouldDisplayCorrectProductsInCart(){
        getDriver().get("http://5.196.7.235/");
        Order expectedOrder = new Order();

        new ProductsGridComponent(getDriver())
                .getAllItems()
                .get(1)
                .open();

        ProductDetailsPage prodPage =  new ProductDetailsPage(getDriver());
        prodPage.setQuantity("4");
        prodPage.addToBasket(expectedOrder);
    }
}
