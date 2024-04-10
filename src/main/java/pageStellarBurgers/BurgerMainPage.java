package pageStellarBurgers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

public class BurgerMainPage extends BasePage {
    public BurgerMainPage(WebDriver driver) {
        super(driver);
    }
    String name;
    private final By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private final By logoLink = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");
    private final By mainPage = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/h1");
    private final By bunsSection = By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]/span[text()='Булки']/parent::div");
    private final By sauceSection =  By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]/span[text()='Соусы']/parent::div");
    private final By toppingSection =  By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]/span[text()='Начинки']/parent::div");
    private final By bunHeader = By.xpath(".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[1]");
    private final By sauceHeader = By.xpath(".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[2]");
    private final By toppingHeader = By.xpath(".//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[3]");

    @Step("click on button section")
    public void sectionClick(String section) {
        if (Objects.equals(section, "Булки")) {
            driver.findElement(sauceSection).click();
            driver.findElement(bunsSection).click();
        }
        else if (Objects.equals(section, "Соусы")) {
            driver.findElement(sauceSection).click();
        }
        else if (Objects.equals(section, "Начинки")) {
            driver.findElement(toppingSection).click();
        }
        name = section;
    }

    @Step("check displayed section")
    public String displayedSection(String section) {
        WebElement authorizationElement = null;
        if (Objects.equals(section, "Булки")) {
            authorizationElement = driver.findElement(bunHeader);
        }
        else if (Objects.equals(section, "Соусы")) {
            authorizationElement = driver.findElement(sauceHeader);
        }
        else if (Objects.equals(section, "Начинки")) {
            authorizationElement = driver.findElement(toppingHeader);
        }
        authorizationElement.isDisplayed();
        return authorizationElement.getText();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickButtonPersonalAcc(){
        driver.findElement(personalAccountButton).click();
    }

    @Step("click on button logo")
    public void logoClick() {
        driver.findElement(logoLink).click();
    }

    @Step("check displayed main page")
    public String displayedMainPage() {
        WebElement authorizationElement = driver.findElement(mainPage);
        authorizationElement.isDisplayed();
        return authorizationElement.getText();
    }

}
