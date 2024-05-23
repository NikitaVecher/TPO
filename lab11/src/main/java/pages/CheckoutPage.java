package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By phoneField = By.xpath("/html/body/section/div/div/div/form/ul/li[1]/div/ul/li[1]/input[2]");
    private By nameField = By.xpath("/html/body/section/div/div/div/form/ul/li[1]/div/ul/li[2]/input");
    private By emailField = By.xpath("/html/body/section/div/div/div/form/ul/li[1]/div/ul/li[3]/input");
    private By deliveryMethod = By.xpath("/html/body/section/div/div/div/form/ul/li[3]/div[2]/div[2]/div/div/div[1]");
    private By deliveryOption = By.xpath("/html/body/section/div/div/div/form/ul/li[4]/div[2]/ul/div[1]/li");
    private By addressField = By.xpath("/html/body/section/div/div/div/form/ul/li[4]/div[2]/div[2]/div[1]/input");
    private By commentField = By.xpath("/html/body/section/div/div/div/form/ul/li[5]/div[2]/div[2]/textarea");
    private By submitOrderButton = By.xpath("/html/body/section/div/div/div/form/div/button");
    private By orderSuccessMessageLocator = By.xpath("/html/body/section/section/div/div/div/div/div[2]");

    public void fillOrderForm(String phoneNumber, String name, String email, String address, String comment) throws InterruptedException {
        driver.findElement(phoneField).sendKeys(phoneNumber);
        Thread.sleep(1000);
        driver.findElement(nameField).sendKeys(name);
        Thread.sleep(1000);
        driver.findElement(emailField).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(deliveryMethod).click(   );
        Thread.sleep(1000);
        driver.findElement(deliveryOption).click();
        Thread.sleep(1000);
        driver.findElement(addressField).sendKeys(address);
        Thread.sleep(1000);
        driver.findElement(commentField).sendKeys(comment);
        Thread.sleep(1000);
        driver.findElement(submitOrderButton).click();
        Thread.sleep(1000);
    }
    public boolean isOrderSuccess() {
        return driver.findElement(orderSuccessMessageLocator).isDisplayed();
    }

    public boolean isOnSuccessPage() {
        return driver.getCurrentUrl().contains("/success");
    }

    public By getOrderSuccessMessageLocator() {
        return orderSuccessMessageLocator;
    }
}
