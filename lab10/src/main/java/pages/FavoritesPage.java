package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import base.BasePage;

public class FavoritesPage extends BasePage {
    private By addedItemsLocator = By.xpath("/html/body/section/section/div/div[3]/div/div");

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAddedItems() {
        return driver.findElements(addedItemsLocator);
    }

    public boolean isItemAdded() {
        return !getAddedItems().isEmpty();
    }

    public By getFirstAddedItemLocator() {
        return addedItemsLocator;
    }
}
