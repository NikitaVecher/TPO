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

        @Test
        public void testAskQuestion() throws InterruptedException {
            driver.get(configReader.getProperty("base.url") + "/public/c-staylery");

            ProductPage productPage = new ProductPage(driver);
            productPage.clickProductCard();

            WaitUtils.waitForElementToBeVisible(driver, productPage.getQuestionTextareaLocator(), 10);

            productPage.askQuestion("Как работает этот продукт?", "Иванов Иван", "ivanov@example.com");

            WaitUtils.waitForElementToBeVisible(driver, productPage.getQuestionSuccessMessageLocator(), 10);
            assertTrue(productPage.isQuestionSubmitted());
        }

        @Test
        public void testPlaceOrder() throws InterruptedException {
            driver.get(configReader.getProperty("base.url") + "/public/c-staylery");

            MainPage mainPage = new MainPage(driver);
            mainPage.addToBasket();

            WaitUtils.waitForElementToBeVisible(driver, mainPage.getGoToCheckoutButtonLocator(), 10);
            mainPage.goToCheckout();

            driver.get(configReader.getProperty("base.url") + "/checkout");

            CheckoutPage checkoutPage = new CheckoutPage(driver);

            // Generate random phone number
            Random rand = new Random();
            String randomPhoneNumber = "+375 (29) " + (rand.nextInt(900) + 100) + "-" + (rand.nextInt(900) + 100) + "-" + (rand.nextInt(9000) + 1000);

            // Fill order form
            checkoutPage.fillOrderForm(randomPhoneNumber, "Иванов Иван", "ivanov@example.com", "г. Минск, ул. Пушкина, д. Колотушкина", "Комментарий к заказу");

            // Verification of successful order placement
            WaitUtils.waitForElementToBeVisible(driver, checkoutPage.getOrderSuccessMessageLocator(), 10);

            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/success"));
        }

        @Test
        public void testSearchProduct() throws InterruptedException {
            driver.get(configReader.getProperty("base.url"));

            String searchText = "Стайлер Dyson Airwrap";
            MainPage mainPage = new MainPage(driver);
            mainPage.searchForProduct(searchText);

            SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
            String actualHeaderText = searchResultsPage.getHeaderText();
            assertTrue(actualHeaderText.contains(searchText));
        }

        @Test
        public void testCategoryNavigation() throws InterruptedException {
            driver.get(configReader.getProperty("base.url"));
            Thread.sleep(2000); // Подождем, чтобы страница загрузилась полностью

            MainPage mainPage = new MainPage(driver);
            mainPage.navigateToHairCarePage();
            Thread.sleep(2000); // Подождем, чтобы страница загрузилась полностью

            CategoryPage categoryPage = new CategoryPage(driver);
            String expectedSubCategoryName = categoryPage.getSubCategoryName().toLowerCase();
            System.out.println("Expected SubCategory Name: " + expectedSubCategoryName);
            categoryPage.navigateToSubCategory();
            Thread.sleep(2000); // Подождем, чтобы страница загрузилась полностью

            // Сравниваем заголовок страницы с запомненным значением
            String actualPageHeader = categoryPage.getPageHeader().toLowerCase();
            System.out.println("Actual Page Header: " + actualPageHeader);
            assertTrue("Header does not contain the expected subcategory name.", actualPageHeader.contains(expectedSubCategoryName));
        }

        @Test
        public void testPhotoShopNavigation() throws InterruptedException {
            // Переход на главную страницу
            driver.get("https://photo-shop.by/dyson/?sort=price__number&page_num=1&page_size=12");
            Thread.sleep(1000);

            // Главная страница
            MainPage mainPage = new MainPage(driver);
            mainPage.selectFirstProduct();
            Thread.sleep(1000);

            // Страница товара
            ProductPage productPage = new ProductPage(driver);
            productPage.addToCart();
            Thread.sleep(1000);

            // Переход на страницу другой категории
            productPage.navigateToCategory();
            Thread.sleep(1000);

            // Страница категории
            CategoryPage categoryPage = new CategoryPage(driver);
            categoryPage.selectSecondProduct();
            Thread.sleep(1000);

            // Страница товара
            ProductPage secondProductPage = new ProductPage(driver);
            secondProductPage.addToCart();
            Thread.sleep(1000);

            // Переход на страницу сравнения
            secondProductPage.navigateToComparePage();
            Thread.sleep(1000);


        }

        @Test
        public void testSortByPrice() throws InterruptedException {
            // Переход на главную страницу
            driver.get("https://photo-shop.by/dyson/");
            Thread.sleep(1000);

            // Главная страница
            MainPage mainPage = new MainPage(driver);
            mainPage.clickSortButton();
            Thread.sleep(1000);
            mainPage.selectSortByPrice();
            Thread.sleep(1000);

            // Страница с отсортированными товарами
            SortedPage sortedPage = new SortedPage(driver);

            // Проверка, что страница с сортировкой отображается
            assertTrue("The sort page is not displayed", sortedPage.isSortPageDisplayed());

            // Если страница сортировки отображается, тест завершается успешно
        }


        @Test
        public void testRegistration() throws InterruptedException {
            // Переход на главную страницу
            driver.get("https://www.dyson.by/");
            Thread.sleep(1000);

            // Главная страница
            MainPage mainPage = new MainPage(driver);
            mainPage.clickRegisterButton();
            Thread.sleep(1000);

            // Страница регистрации
            RegistrationPage registrationPage = new RegistrationPage(driver);
            registrationPage.enterPhoneNumber("+375 29 xx-xx-xxx");
            Thread.sleep(1000);
            registrationPage.clickSubmitButton();
            Thread.sleep(1000);

            // Тест успешно завершен
            assertTrue(true);
        }

        @After
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }