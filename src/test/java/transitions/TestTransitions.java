package transitions;


import api.UserAPI;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageStellarBurgers.BurgerMainPage;
import pageStellarBurgers.LoginPage;
import pageStellarBurgers.PersonalAccountPage;
import pageStellarBurgers.RegisterPage;
import registration.BaseTest;
import user.RandomUser;
import user.User;


public class TestTransitions extends BaseTest {
    private UserAPI userAPI;
    private User user;
    private String accessToken;

    @Before
    public void createTestData() {
        userAPI = new UserAPI();
        user = RandomUser.UserRandom();
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @Description("Переход в личный кабинет «Личный кабинет»")
    public void transitionsPersonaAccountTest() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        BurgerMainPage burgerMainPage = new BurgerMainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.registerPage(user.getName(), user.getEmail(), user.getPassword());
        registerPage.click();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        loginPage.logotipClick();
        burgerMainPage.clickButtonPersonalAcc();
        personalAccountPage.headerClick();
        String getTextActiveButton = personalAccountPage.displayedProfilePage();
        Assert.assertEquals("Профиль", getTextActiveButton);
    }


    @Test
    @Description("Переход из личного кабинета в конструктор и нажать на логотип Stellar Burgers")
    public void transitionsBurgerMainPageTest() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        BurgerMainPage burgerMainPage = new BurgerMainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.registerPage(user.getName(), user.getEmail(), user.getPassword());
        registerPage.click();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        loginPage.logotipClick();
        burgerMainPage.clickButtonPersonalAcc();
        personalAccountPage.headerClick();
        personalAccountPage.clickConstructor();
        burgerMainPage.logoClick();
        String getTextActiveButton = burgerMainPage.displayedMainPage();
        Assert.assertEquals("Соберите бургер", getTextActiveButton);
    }

    @After
    public void tearDown(){
        if (accessToken != null){
            userAPI.deleteUser(accessToken);
        }
        driver.quit();
    }

}
