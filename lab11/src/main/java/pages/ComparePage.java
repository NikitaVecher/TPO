package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparePage {

    private WebDriver driver;
    private By comparisonPageIdentifier = By.xpath("//h1[contains(text(), 'Сравнение товаров')]");

    public ComparePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isComparisonPageDisplayed() {
        return driver.findElements(comparisonPageIdentifier).size() > 0;
    }
}
