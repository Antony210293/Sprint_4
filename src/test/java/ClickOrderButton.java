import pom.HomePageScooter;
import pom.OrderPageScooter;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static pom.OrderPageScooter.*;


public class ClickOrderButton {
    private WebDriver driver;


    @Test
    public void clickButtonOrderHeadPageOpen(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        driver.get(HOME_PAGE);

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonOrderHead();
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.isPageOpen(objOrderPage.getOrderHeadline() ,ORDER_HEADLINE_TEXT);
    }

    @Test
    public void clickButtonOrderDownPageOpen(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        driver.get(HOME_PAGE);

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonOrderHead();
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.isPageOpen(objOrderPage.getOrderHeadline() ,ORDER_HEADLINE_TEXT);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
