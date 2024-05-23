package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {

    private WebDriver driver;

    private By subCategoryNameLocator = By.xpath("/html/body/section/section/div/div[3]/div/div/div/a[3]/span");
    private By subCategoryLink = By.xpath("/html/body/section/section/div/div[3]/div/div/div/a[3]");
    private By pageHeaderLocator = By.xpath("/html/body/section/section[1]/div/div[2]/div/div/h1");
    private By specificProductLink = By.xpath("/html/body/section/section[1]/div/div[3]/div/div/div/div[1]/a[3]");


    private By secondProductLink = By.xpath("/html/body/div[1]/div[1]/main/div/section/div/div/div[1]/div/div[3]/div[4]/div/div[1]/div[3]");

    public void selectSecondProduct() {
        driver.findElement(secondProductLink).click();
    }


    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSubCategoryName() {
        return driver.findElement(subCategoryNameLocator).getText();
    }

    public void selectSpecificProduct() {
        driver.findElement(specificProductLink).click();
    }
    public void navigateToSubCategory() {
        driver.findElement(subCategoryLink).click();
    }

    public String getPageHeader() {
        return driver.findElement(pageHeaderLocator).getText();
    }
}
