import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class WebDriverUnitTest {
    private WebDriver driver;
    private String addedItemId;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testButtonClick() throws InterruptedException {
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

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
