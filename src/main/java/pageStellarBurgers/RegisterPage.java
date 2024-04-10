package pageStellarBurgers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    private final By nameField = By.xpath(".//fieldset[1]/div/div/input[contains(@class, 'input__textfield')]");
    private final By emailField = By.xpath(".//fieldset[2]/div/div/input[contains(@class, 'input__textfield')]");
    private final By passwordField = By.xpath(".//fieldset[3]/div/div/input[contains(@class, 'input__textfield')]");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By wrongPasswordText = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/p");
    private final By enterButton = By.cssSelector("[href='/login']");
    private final By personalAccoutnRPage = By.xpath(".//*[text()='Личный Кабинет']");

    @Step("Клик по тексту Войти")
    public void click() {
        driver.findElement(enterButton).click();
    }
    @Step("Клик по  тексту Личный кабинет")
    public void personalAccoutnRPageClick() {
        driver.findElement(personalAccoutnRPage).click();
    }
    @Step("Заполнение имени, email, пароля на форме регистрации")
    public RegisterPage registerPage(String nameFaker, String emailFaker, String passwordFaker){
        driver.findElement(nameField).sendKeys(nameFaker);
        driver.findElement(emailField).sendKeys(emailFaker);
        driver.findElement(passwordField).sendKeys(passwordFaker);
        driver.findElement(registerButton).click();
        return this;
    }

    @Step("Проверка на некорректный пароль")
    public boolean checkLabelWrongPass(){
        return driver.findElement(wrongPasswordText).isDisplayed();
    }

}
