package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePageScooter {

    private WebDriver driver;

    //Добавили конструктор класса page object
    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public static final By SCROLL = By.xpath(".//div[@class='accordion']");
    //Вопросы в нижней части домашней страницы
    //Сколько это стоит? И как оплатить?
    public static final By QUESTION_1 = By.id("accordion__heading-0");
    //Хочу сразу несколько самокатов! Так можно?
    public static final By QUESTION_2 = By.id("accordion__heading-1");
    //Как рассчитывается время аренды?
    public static final By QUESTION_3 = By.id("accordion__heading-2");
    //Можно ли заказать самокат прямо на сегодня?
    public static final By QUESTION_4 = By.id("accordion__heading-3");
    //Можно ли продлить заказ или вернуть самокат раньше?
    public static final By QUESTION_5 = By.id("accordion__heading-4");
    //Вы привозите зарядку вместе с самокатом?
    public static final By QUESTION_6 = By.id("accordion__heading-5");
    //Можно ли отменить заказ?
    public static final By QUESTION_7 = By.id("accordion__heading-6");
    //Я живу за МКАДом, привезёте?
    public static final By QUESTION_8 = By.id("accordion__heading-7");

    //Ответы в нижней части страницы
    //Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    public static final By ANSWER_1 = By.id("accordion__panel-0");
    //Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    public static final By ANSWER_2 = By.id("accordion__panel-1");
    //Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    public static final By ANSWER_3 = By.id("accordion__panel-2");
    //Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    public static final By ANSWER_4 = By.id("accordion__panel-3");
    //Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    public static final By ANSWER_5 = By.id("accordion__panel-4");
    //Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    public static final By ANSWER_6 = By.id("accordion__panel-5");
    //Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    public static final By ANSWER_7 = By.id("accordion__panel-6");
    //Да, обязательно. Всем самокатов! И Москве, и Московской области.
    public static final By ANSWER_8 = By.id("accordion__panel-7");

    //Кнопка заказа в шапке главной страницы
    private static final By buttonOrderHead = By.className("Button_Button__ra12g");
    //Кнопка заказа в нижней части главной страницы
    private static final By buttonOrderDown = By.className("Button_Button__ra12g Button_Middle__1CSJM");

    //Методы для клика по вопросу
    public void clickQuestion(By question) {
        driver.findElement(question).click();
    }

    public void clickQuestion2() {
        driver.findElement(QUESTION_2).click();
    }

    public void clickQuestion3() {
        driver.findElement(QUESTION_3).click();
    }

    public void clickQuestion4() {
        driver.findElement(QUESTION_4).click();
    }

    public void clickQuestion5() {
        driver.findElement(QUESTION_5).click();
    }

    public void clickQuestion6() {
        driver.findElement(QUESTION_6).click();
    }

    public void clickQuestion7() {
        driver.findElement(QUESTION_7).click();
    }

    public void clickQuestion8() {
        driver.findElement(QUESTION_8).click();
    }

    //Методы для получения ответа на вопросы
    public String getAnswer(By answer) {
        return driver.findElement(answer).getText();
    }



    //Текст ответов
    public static final String ANSWER_1_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String ANSWER_2_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String ANSWER_3_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ANSWER_4_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String ANSWER_5_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String ANSWER_6_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String ANSWER_7_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String ANSWER_8_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public void clickButtonOrderHead() {
        driver.findElement(buttonOrderHead).click();
    }

    public void clickButtonOrderDown() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(buttonOrderDown));
        driver.findElement(buttonOrderDown).click();
    }
}
