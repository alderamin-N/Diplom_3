package registration;

import api.UserAPI;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageStellarBurgers.LoginPage;
import pageStellarBurgers.RegisterPage;
import user.RandomUser;
import user.User;

public class TestRegistration extends BaseTest{
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
    @Description("Успешная авторизация пользователя")
    public void successfulRegistrationTest(){
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.registerPage(user.getName(),user.getEmail(),user.getPassword());
        Assert.assertTrue(loginPage.checkLabelInput());
    }

    @Test
    @Description("Авторизация с неверным паролем")
    public void invalidPasswordTest(){
        Faker faker = new Faker();
        user.setPassword(faker.internet().password(1,5));
        RegisterPage registerPage = new RegisterPage(driver);
        Assert.assertTrue(registerPage.registerPage(user.getName(),user.getEmail(),user.getPassword()).checkLabelWrongPass());
    }

    @After
    public void tearDown(){
        if (accessToken != null){
            userAPI.deleteUser(accessToken);
        }
        driver.quit();
    }
}
