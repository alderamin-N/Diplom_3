package pageStellarBurgers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResorePage extends BasePage {
    private final By enterButton = By.cssSelector("[href='/login']");

    public ResorePage(WebDriver driver) {
        super(driver);
    }
    @Step("Клик по кнопке войти на странице восстановления пароля")
    public LoginPage clickEnterButton(){
        driver.findElement(enterButton).click();
        return new LoginPage(driver);
    }
}
