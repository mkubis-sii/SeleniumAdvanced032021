package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BasePage {
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    protected void click(WebElement element) {
        new WebDriverWait(getDriver(), 10)
                .until(c -> element.isEnabled());
        System.out.println("Klikam w przycisk " + element.getText());
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        element.clear();
        System.out.println("Wpisuję tekst " + text);
        element.sendKeys(text);
    }

    protected WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));// losowanie z <0,8)
    }
}
