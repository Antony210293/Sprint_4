import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pom.HomePageScooter;
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
import static pom.HomePageScooter.*;
import static pom.OrderPageScooter.HOME_PAGE;
import static org.hamcrest.CoreMatchers.is;


@RunWith(Enclosed.class)
public class ScooterQuestionAnswer {

    private WebDriver driver;


        @RunWith(Parameterized.class)
        public static class ClickQuestion {
            private WebDriver driver;
            private final By question;
            private final By answer;
            private final String answerText;


            public ClickQuestion(By question, By answer, String answerText) {
                this.question = question;
                this.answer = answer;
                this.answerText = answerText;
            }

            @Parameterized.Parameters
            public static Object[][] getAnswerText() {
                return new Object[][]{
                        {QUESTION_1, ANSWER_1, ANSWER_1_TEXT},
                        {QUESTION_2, ANSWER_2, ANSWER_2_TEXT},
                        {QUESTION_3, ANSWER_3, ANSWER_3_TEXT},
                        {QUESTION_4, ANSWER_4, ANSWER_4_TEXT},
                        {QUESTION_5, ANSWER_5, ANSWER_5_TEXT},
                        {QUESTION_6, ANSWER_6, ANSWER_6_TEXT},
                        {QUESTION_7, ANSWER_7, ANSWER_7_TEXT},
                        {QUESTION_8, ANSWER_8, ANSWER_8_TEXT},
                };
            }


            @Test
            public void scooterCorrectAnswer() {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                driver = new ChromeDriver();
                driver.get(HOME_PAGE);
                WebElement tableFAQ = driver.findElement(SCROLL);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
                HomePageScooter objHomePage = new HomePageScooter(driver);


                objHomePage.clickQuestion(question);
                driver.findElement(By.className("App_CookieButton__3cvqF")).click();
                new WebDriverWait(driver, 3)
                        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(question));
                MatcherAssert.assertThat(objHomePage.getAnswer(answer), is(answerText));
                driver.quit();

            }
        }
}

