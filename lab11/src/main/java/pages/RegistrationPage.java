package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;
    private By phoneNumberField = By.xpath("/html/body/header[2]/div[3]/div/div/div[3]/div/div[2]/div[1]/form/div[1]/input");
    private By submitButton = By.xpath("/html/body/header[2]/div[3]/div/div/div[3]/div/div[2]/div[1]/form/div[2]/div/button");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}
