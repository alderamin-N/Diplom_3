package pageStellarBurgers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By emailField = By.xpath(".//fieldset[1]/div/div/input[contains(@class, 'input__textfield')]");
    private final By passwordField = By.xpath(".//fieldset[2]/div/div/input[contains(@class, 'input__textfield')]");
    private final By restorePassword = By.cssSelector("[href='/forgot-password']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By labelInput = By.xpath(".//h2[text() = 'Вход']");
     private final By logotip = By.xpath(".//div/a");

    @Step("Проверка надписи Вход на странице авторизации")
    public boolean checkLabelInput(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelInput)).isDisplayed();
    }

    @Step("Заполнение логина и email на форме авторизации")
    public LoginPage loginUser(String emailFaker, String passwordFaker){
        driver.findElement(emailField).sendKeys(emailFaker);
        driver.findElement(passwordField).sendKeys(passwordFaker);
        driver.findElement(loginButton).click();
        return this;
    }

    @Step("Клик по тексту Восстановить пароль")
    public void restorePasswordClick() {
        driver.findElement(restorePassword).click();
    }


    @Step("Клик по логотипу")
    public void logotipClick() {
        driver.findElement(logotip).click();
    }

}
