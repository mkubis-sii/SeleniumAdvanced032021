package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;

public class BasePage {
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void click(WebElement element){
        new WebDriverWait(getDriver(),10)
                .until(c-> element.isEnabled());
        System.out.println("Klikam w przycisk " + element.getText());
        element.click();
    }

    public void sendKeys(WebElement element, String text){
        element.clear();
        System.out.println("Wpisuję tekst " + text);
        element.sendKeys(text);
    }
}
