package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class ProductPage extends BasePage {
    private By productCardLocator = By.xpath("/html/body/section/section[1]/div/div[3]/div/div/div/div[1]/a[1]");
    private By starsLocator = By.xpath("/html/body/section/section/div[2]/div[12]/div/div[2]/div/div[1]/form/div[2]/div/label[1]");
    private By reviewTextLocator = By.xpath("/html/body/section/section/div[2]/div[12]/div/div[2]/div/div[1]/form/div[3]/label/textarea");
    private By nameInputLocator = By.xpath("/html/body/section/section/div[2]/div[12]/div/div[2]/div/div[1]/form/div[3]/div/label[1]/input");
    private By emailInputLocator = By.xpath("/html/body/section/section/div[2]/div[12]/div/div[2]/div/div[1]/form/div[3]/div/label[2]/input");
    private By submitButtonLocator = By.xpath("/html/body/section/section/div[2]/div[12]/div/div[2]/div/div[1]/form/div[3]/button");
    private By successMessageLocator = By.xpath("/html/body/section/section/div[2]/div[12]/div/div[2]/div/div[1]/form/div[1]/div/div");


    private By questionTextareaLocator = By.xpath("/html/body/section/section/div[2]/div[12]/div/div[2]/div/div[2]/form/div[2]/label/textarea");
    private By questionNameInputLocator = By.xpath("/html/body/section/section/div[2]/div[12]/div/div[2]/div/div[2]/form/div[2]/div/label[1]/input");
    private By questionEmailInputLocator = By.xpath("/html/body/section/section/div[2]/div[12]/div/div[2]/div/div[2]/form/div[2]/div/label[2]/input");
    private By questionSubmitButtonLocator = By.xpath("/html/body/section/section/div[2]/div[12]/div/div[2]/div/div[2]/form/div[2]/button");
    private By questionSuccessMessageLocator = By.xpath("/html/body/section/section/div[2]/div[12]/div/div[2]/div/div[2]/form/div[1]/div/div");

    private By addToCartButton = By.xpath("/html/body/div[1]/div[1]/main/div/section/div/div/div[1]/div/div[1]/div[2]/div/div[4]/div/div/div/div/div/div[1]");
    private By categoryLink = By.xpath("/html/body/div[1]/div[1]/main/div/section/div/div/div[1]/ol/li[3]/a");
    private By compareButton = By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div/div/div/div[5]");

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void navigateToCategory() {
        driver.findElement(categoryLink).click();
    }

    public void navigateToComparePage() {
        driver.findElement(compareButton).click();
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickProductCard() {
        driver.findElement(productCardLocator).click();
    }

    public By getStarsLocator() {
        return starsLocator;
    }

    public void writeReview(String review, String name, String email) {
        driver.findElement(reviewTextLocator).sendKeys(review);
        driver.findElement(nameInputLocator).sendKeys(name);
        driver.findElement(emailInputLocator).sendKeys(email);
        driver.findElement(submitButtonLocator).click();
    }

    public boolean isReviewSubmitted() {
        return driver.findElement(successMessageLocator).isDisplayed();
    }

    public By getSuccessMessageLocator() {
        return successMessageLocator;
    }

    // Новый метод для заполнения и отправки вопроса
    public void askQuestion(String question, String name, String email) {
        driver.findElement(questionTextareaLocator).sendKeys(question);
        driver.findElement(questionNameInputLocator).sendKeys(name);
        driver.findElement(questionEmailInputLocator).sendKeys(email);
        driver.findElement(questionSubmitButtonLocator).click();
    }

    public By getQuestionTextareaLocator() {
        return questionTextareaLocator;
    }

    public By getQuestionSuccessMessageLocator() {
        return questionSuccessMessageLocator;
    }

    public boolean isQuestionSubmitted() {
        return driver.findElement(questionSuccessMessageLocator).isDisplayed();
    }
}
