import POM.HomePageScooter;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static POM.HomePageScooter.*;
import static org.hamcrest.CoreMatchers.is;


public class ScooterQuestionAnswer {

    private WebDriver driver;

    @Test
    public void scooterCorrectAnswer() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement tableFAQ = driver.findElement(By.xpath(".//div[@class='accordion']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
        HomePageScooter objHomePage = new HomePageScooter(driver);

        objHomePage.clickQuestion1();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accordion__panel-0")));
        MatcherAssert.assertThat(objHomePage.getAnswer1(), is(answer1Text));

        objHomePage.clickQuestion2();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accordion__panel-1")));
        MatcherAssert.assertThat(objHomePage.getAnswer2(), is(answer2Text));

        objHomePage.clickQuestion3();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accordion__panel-2")));
        MatcherAssert.assertThat(objHomePage.getAnswer3(), is(answer3Text));

        objHomePage.clickQuestion4();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accordion__panel-3")));
        MatcherAssert.assertThat(objHomePage.getAnswer4(), is(answer4Text));

        objHomePage.clickQuestion5();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accordion__panel-4")));
        MatcherAssert.assertThat(objHomePage.getAnswer5(), is(answer5Text));

        objHomePage.clickQuestion6();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accordion__panel-5")));
        MatcherAssert.assertThat(objHomePage.getAnswer6(), is(answer6Text));

        objHomePage.clickQuestion7();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accordion__panel-6")));
        MatcherAssert.assertThat(objHomePage.getAnswer7(), is(answer7Text));

        //Нажать "на принять Куки", так как всплывающее окно закрывало доступ по клику на 8 вопрос
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();

        objHomePage.clickQuestion8();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accordion__panel-7")));
        MatcherAssert.assertThat(objHomePage.getAnswer8(), is(answer8Text));

    }

    @After
    public void after() {
        driver.quit();
    }
}
