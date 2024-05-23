package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    private WebDriver driver;

    private By basketItemLocator = By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/div/div/ul/li[1]");

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isItemInBasket() {
        return driver.findElements(basketItemLocator).size() > 0;
    }
}
