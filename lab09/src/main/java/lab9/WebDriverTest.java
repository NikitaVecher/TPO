package lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class WebDriverTest {
  public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://dyson.by/c-feny-dlya-volos");

    WebElement addToFavoritesButton  = driver.findElement(By.xpath("/html/body/section/section[1]/div/div[3]/div/div/div/div[1]/span[2]/a"));
    addToFavoritesButton .click();
    Thread.sleep(2000);

    WebElement favoritesLink = driver.findElement(By.xpath("/html/body/header[1]/div[2]/div/div/div/ul/li[4]"));
    favoritesLink.click();
    Thread.sleep(2000);

    // Проверяем, что мы находимся на странице с избранными товарами после нажатия на кнопку
    String currentUrl = driver.getCurrentUrl();
    assertTrue(currentUrl.contains("wish-list")); // Предполагаем, что в URL есть "wish-list"
    Thread.sleep(2000);

    // Проверяем, что добавленный товар отображается на странице избранных
    List<WebElement> addedItems = driver.findElements(By.xpath("/html/body/section/section/div/div[3]/div/div"));
    assertTrue(addedItems.size() > 0); // Проверяем, что список элементов не пустой
    Thread.sleep(2000);

    driver.quit(); // Закрываем браузер
  }
}
