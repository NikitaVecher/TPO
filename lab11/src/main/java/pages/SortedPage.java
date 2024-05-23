package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SortedPage {
    private WebDriver driver;
    private By sortResultIndicator = By.xpath("/html/body/div[1]/div[1]/main/div/section/div/div/div[1]/div/div[2]/div[3]/div/div/div/button");

    public SortedPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSortPageDisplayed() {
        // Проверяем наличие элемента, который указывает на успешную сортировку
        return driver.findElement(sortResultIndicator).isDisplayed();
    }
}