    package tests;

    import org.junit.After;
    import org.junit.Before;
    import org.junit.Test;
    import org.openqa.selenium.WebDriver;
    import pages.*;
    import utils.WebDriverUtils;
    import utils.WaitUtils;
    import utils.ConfigReader;

    import org.openqa.selenium.support.ui.WebDriverWait;

    import static org.junit.Assert.assertTrue;

    import java.util.Random;


    public class WebDriverUnitTest {
        private WebDriver driver;
        private ConfigReader configReader;
        private WebDriverWait wait;

        @Before
        public void setUp() {
            configReader = new ConfigReader("src/main/resources/config.properties");
            driver = WebDriverUtils.getDriver(configReader.getProperty("webdriver.path"));
        }

        @Test
        public void testAddToFavorites() throws InterruptedException {
            driver.get(configReader.getProperty("base.url") + "/c-feny-dlya-volos");

            MainPage mainPage = new MainPage(driver);
            mainPage.addToFavorites();

            WaitUtils.waitForElementToBeVisible(driver, mainPage.getFavoritesLinkLocator(), 10);

            mainPage.goToFavorites();
            FavoritesPage favoritesPage = new FavoritesPage(driver);
            WaitUtils.waitForElementToBeVisible(driver, favoritesPage.getFirstAddedItemLocator(), 10);

            assertTrue(favoritesPage.isItemAdded());
        }

        @Test
        public void testAddToBasket() throws InterruptedException {
            // Переходим на главную страницу
            driver.get(configReader.getProperty("base.url"));
            Thread.sleep(2000); // Подождем, чтобы страница загрузилась полностью

            // Используем Page Object для взаимодействия с элементами
            MainPage mainPage = new MainPage(driver);
            mainPage.ToHairCarePage();
            Thread.sleep(2000); // Подождем, чтобы страница загрузилась полностью

            CategoryPage categoryPage = new CategoryPage(driver);
            categoryPage.selectSpecificProduct();
            Thread.sleep(2000); // Подождем, чтобы страница загрузилась полностью

            BasketPage basketPage = new BasketPage(driver);
            assertTrue("Item was not added to the basket.", basketPage.isItemInBasket());
        }

        @Test
        public void testWriteReview() throws InterruptedException {
            driver.get(configReader.getProperty("base.url") + "/public/c-staylery");

            ProductPage productPage = new ProductPage(driver);
            productPage.clickProductCard();

            WaitUtils.waitForElementToBeVisible(driver, productPage.getStarsLocator(), 10);

            productPage.writeReview("Отличный продукт!", "Иванов Иван", "ivanov@example.com");

            WaitUtils.waitForElementToBeVisible(driver, productPage.getSuccessMessageLocator(), 10);
            assertTrue(productPage.isReviewSubmitted());
        }



        @After
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }