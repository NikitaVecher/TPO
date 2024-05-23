package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class MainPage extends BasePage {
    private By addToFavoritesButtonLocator = By.xpath("/html/body/section/section[1]/div/div[3]/div/div/div/div[1]/span[2]/a");
    private By favoritesLinkLocator = By.xpath("/html/body/header[1]/div[2]/div/div/div/ul/li[4]");

    private By addToBasketButton = By.xpath("/html/body/section/section[1]/div/div[3]/div/div/div/div[1]/a[3]");
    private By goToCheckoutButton = By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/div/div/div/div/a[2]");

    private By searchInputField = By.xpath("/html/body/header[2]/div[3]/div/div/div[1]/form[1]/input");

    private By hairCareCategoryLink = By.xpath("/html/body/header[2]/nav/div/ul/li[1]/a");

    private By CareCategoryLink = By.xpath("/html/body/section/section[2]/div/div/div[2]");


    private By firstProductLink = By.xpath("/html/body/div[1]/div[1]/main/div/section/div/div/div[1]/div/div[3]/div[3]/div/div[1]/div[3]");

    private By sortButton = By.xpath("/html/body/div[1]/div[1]/main/div/section/div/div/div[1]/div/div[2]/div[3]/div/div/div/button");
    private By sortByPriceOption = By.xpath("/html/body/div[1]/div[1]/main/div/section/div/div/div[1]/div/div[2]/div[3]/div/div/div/ul/li[2]");

    private By registerButton = By.xpath("/html/body/header[2]/div[3]/div/div/div[3]/ul/li[1]/a");

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }


    public void selectFirstProduct() {
        driver.findElement(firstProductLink).click();
    }

    public void clickSortButton() {
        driver.findElement(sortButton).click();
    }

    public void selectSortByPrice() {
        driver.findElement(sortByPriceOption).click();
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
    public void navigateToHairCarePage() {
        driver.findElement(hairCareCategoryLink).click();
    }
    public void ToHairCarePage() {
        driver.findElement(CareCategoryLink).click();
    }
    // Добавьте метод для получения заголовка страницы
    public String getPageHeader() {
        return driver.getTitle();
    }
    public void searchForProduct(String searchText) {
        driver.findElement(searchInputField).sendKeys(searchText + Keys.ENTER);
    }

    public void addToFavorites() {
        driver.findElement(addToFavoritesButtonLocator).click();
    }

    public void goToFavorites() {
        driver.findElement(favoritesLinkLocator).click();
    }

    public By getFavoritesLinkLocator() {
        return favoritesLinkLocator;
    }

    public void addToBasket() {
        driver.findElement(addToBasketButton).click();
    }

    public By getGoToCheckoutButtonLocator() {
        return goToCheckoutButton;
    }

    public void goToCheckout() {
        driver.findElement(goToCheckoutButton).click();
    }

}
