import org.junit.Before;
import pom.HomePageScooter;
import pom.OrderPageScooter;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pom.WebDriverFactory;


@RunWith(Enclosed.class)
public class TestOrderBrowser {
    private WebDriver driver;
    // для смены браузера в константе нужно поменять присвоенное значение на "FIREFOX"
    private static final String DEFAULT_BROWSER_NAME = "CHROME";
    private static final String BROWSER_NAME_ENV_VARIABLE = "BROWSER_NAME";

    @RunWith(Parameterized.class)
    public static class OrderTest {
        private WebDriver driver;
        private final String name;
        private final String surname;
        private final String address;
        private final String subway;
        private final String phoneNumber;
        private final String date;
        private final String rentalPeriod;
        private final String color;
        private final String comment;

        public OrderTest(String name, String surname, String address, String subway, String phoneNumber, String date, String rentalPeriod, String color, String comment) {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.subway = subway;
            this.phoneNumber = phoneNumber;
            this.date = date;
            this.rentalPeriod = rentalPeriod;
            this.color = color;
            this.comment = comment;
        }

        @Parameterized.Parameters
        public static Object[][] getDateSetForOrder() {
            return new Object[][]{
                    {"Антон", "Бондарев", "г. Москва, ул. Ленина, д.54", "Достоевская", "+79110965847", "01.01.2025", "сутки", "чёрный жемчуг", "Не опаздывать"},
                    {"Алексей", "Шмаков", "Европейский проспект 8", "Бутырская", "+79113765847", "01.02.2025", "двое суток", "серая безысходность", "Хочу самый быстрый"},
            };
        }

        @Before
        public void before() {
            String browserName = System.getenv(BROWSER_NAME_ENV_VARIABLE);
            driver = WebDriverFactory.createForName(browserName != null ? browserName : DEFAULT_BROWSER_NAME);
        }

        @Test
        public void orderTestRentScooter() {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            HomePageScooter objHomePage = new HomePageScooter(driver);
            objHomePage.clickButtonOrderHead();
            OrderPageScooter objOrderPage = new OrderPageScooter(driver);

            objOrderPage.setName(name);
            objOrderPage.setSurname(surname);
            objOrderPage.setAddress(address);
            objOrderPage.setSubway(subway);
            objOrderPage.setPhoneNumber(phoneNumber);
            objOrderPage.clickOrderNextButton();
            objOrderPage.setDate(date);
            objOrderPage.setRentalPeriod(rentalPeriod);
            objOrderPage.setColor(color);
            objOrderPage.setComment(comment);
            objOrderPage.clickOrderCreateButton();
            objOrderPage.clickOrderConfirmButton();
            String confirmHeaderText = "Заказ оформлен";
            objOrderPage.isPageOpen(objOrderPage.getConfirmHeader(), confirmHeaderText);
        }
    }
}