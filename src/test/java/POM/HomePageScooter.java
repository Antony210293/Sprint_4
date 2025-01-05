package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePageScooter {

    private WebDriver driver;

    //Добавили конструктор класса page object
    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Вопросы в нижней части домашней страницы
    //Сколько это стоит? И как оплатить?
    private static final By question1 = By.id("accordion__heading-0");
    //Хочу сразу несколько самокатов! Так можно?
    private static final By question2 = By.id("accordion__heading-1");
    //Как рассчитывается время аренды?
    private static final By question3 = By.id("accordion__heading-2");
    //Можно ли заказать самокат прямо на сегодня?
    private static final By question4 = By.id("accordion__heading-3");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private static final By question5 = By.id("accordion__heading-4");
    //Вы привозите зарядку вместе с самокатом?
    private static final By question6 = By.id("accordion__heading-5");
    //Можно ли отменить заказ?
    private static final By question7 = By.id("accordion__heading-6");
    //Я живу за МКАДом, привезёте?
    private static final By question8 = By.id("accordion__heading-7");

    //Ответы в нижней части страницы
    //Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private static final By answer1 = By.id("accordion__panel-0");
    //Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private static final By answer2 = By.id("accordion__panel-1");
    //Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private static final By answer3 = By.id("accordion__panel-2");
    //Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private static final By answer4 = By.id("accordion__panel-3");
    //Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private static final By answer5 = By.id("accordion__panel-4");
    //Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    private static final By answer6 = By.id("accordion__panel-5");
    //Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private static final By answer7 = By.id("accordion__panel-6");
    //Да, обязательно. Всем самокатов! И Москве, и Московской области.
    private static final By answer8 = By.id("accordion__panel-7");

    //Кнопка заказа в шапке главной страницы
    private static final By buttonOrderHead = By.className("Button_Button__ra12g");
    //Кнопка заказа в нижней части главной страницы
    private static final By buttonOrderDown = By.className("Button_Button__ra12g Button_Middle__1CSJM");

    //Методы для клика по вопросу
    public void clickQuestion1() {
        driver.findElement(question1).click();
    }

    public void clickQuestion2() {
        driver.findElement(question2).click();
    }

    public void clickQuestion3() {
        driver.findElement(question3).click();
    }

    public void clickQuestion4() {
        driver.findElement(question4).click();
    }

    public void clickQuestion5() {
        driver.findElement(question5).click();
    }

    public void clickQuestion6() {
        driver.findElement(question6).click();
    }

    public void clickQuestion7() {
        driver.findElement(question7).click();
    }

    public void clickQuestion8() {
        driver.findElement(question8).click();
    }

    //Методы для получения ответа на вопросы
    public String getAnswer1() {
        return driver.findElement(answer1).getText();
    }

    public String getAnswer2() {
        return driver.findElement(answer2).getText();
    }

    public String getAnswer3() {
        return driver.findElement(answer3).getText();
    }

    public String getAnswer4() {
        return driver.findElement(answer4).getText();
    }

    public String getAnswer5() {
        return driver.findElement(answer5).getText();
    }

    public String getAnswer6() {
        return driver.findElement(answer6).getText();
    }

    public String getAnswer7() {
        return driver.findElement(answer7).getText();
    }

    public String getAnswer8() {
        return driver.findElement(answer8).getText();
    }

    //Текст ответов
    public static final String answer1Text = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String answer2Text = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String answer3Text = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String answer4Text = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String answer5Text = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String answer6Text = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String answer7Text = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String answer8Text = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public void clickButtonOrderHead() {
        driver.findElement(buttonOrderHead).click();
    }

    public void clickButtonOrderDown() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(buttonOrderDown));
        driver.findElement(buttonOrderDown).click();
    }
}
