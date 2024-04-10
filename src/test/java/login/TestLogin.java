package login;

import api.UserAPI;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageStellarBurgers.*;
import registration.BaseTest;
import user.RandomUser;
import user.User;

public class TestLogin extends BaseTest {
    private UserAPI userAPI;
    private User user;
    private String accessToken;

    @Before
    public void createTestData(){
        userAPI = new UserAPI();
        user = RandomUser.UserRandom();
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginviaBurgerPageTest(){
        BurgerMainPage burgerMainPage = new BurgerMainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.registerPage(user.getName(),user.getEmail(),user.getPassword());
        loginPage.logotipClick();
        burgerMainPage.clickButtonPersonalAcc();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        Assert.assertTrue(loginPage.checkLabelInput());
    }

    @Test
    @Description("Вход через кнопку «Личный кабинет»")
    public void loginViaPersonaAccountTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.personalAccoutnRPageClick();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        Assert.assertTrue(loginPage.checkLabelInput());
    }

    @Test
    @Description("Вход через кнопку Войти в форме восстановления пароля")
    public void loginViaFormRestorePageTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ResorePage resorePage = new ResorePage(driver);
        registerPage.click();
        loginPage.restorePasswordClick();
        resorePage.clickEnterButton().loginUser(user.getEmail(), user.getPassword());
        Assert.assertTrue(loginPage.checkLabelInput());
    }

    @Test
    @Description("Вход через кнопку Войти в форме регистрации")
    public void loginViaRegisterPageTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.click();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        Assert.assertTrue(loginPage.checkLabelInput());
    }


@After
public void tearDown(){
    if (accessToken != null){
        userAPI.deleteUser(accessToken);
    }
    driver.quit();
}
}
