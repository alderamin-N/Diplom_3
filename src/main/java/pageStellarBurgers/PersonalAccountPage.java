package pageStellarBurgers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalAccountPage extends BasePage {

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }
    private final By labelProfile = By.cssSelector("[href = '/account/profile']");
    private final By constructor = By.xpath(".//p[text() = 'Конструктор']");
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    private final By headerButton = By.xpath("//p[text()='Личный Кабинет']/parent::a");
    private final By profilePage = By.xpath(".//a[contains(@class, 'Account_link_active__2opc9')]");

    @Step("check displayed profile page")
    public String displayedProfilePage() {
        WebElement authorizationElement = driver.findElement(profilePage);
        authorizationElement.isDisplayed();
        return authorizationElement.getText();
    }

    @Step("click on button 'Личный кабинет'")
    public void headerClick() {
        driver.findElement(headerButton).click();
    }

    @Step("click on button logout")
    public void logoutClick() {
        driver.findElement(logoutButton).click();
    }

    @Step("Взять надпись Личный кабинет")
    public String getLabel(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelProfile)).getText();
    }

    @Step("Клик по кнопке Конструктор")
    public BurgerMainPage clickConstructor(){
        driver.findElement(constructor).click();
        return new BurgerMainPage(driver);
    }

}
