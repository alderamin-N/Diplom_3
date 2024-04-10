package transitions;

import api.UserAPI;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageStellarBurgers.BurgerMainPage;
import pageStellarBurgers.LoginPage;
import pageStellarBurgers.RegisterPage;
import registration.BaseTest;
import user.RandomUser;
import user.User;

@RunWith(Parameterized.class)
public class TestTransitionsSection extends BaseTest {
    private UserAPI userAPI;
    private User user;
    private String accessToken;
    private final String section;
    public TestTransitionsSection(String section) {
        this.section = section;
    }

    @Before
    public void createTestData() {
        userAPI = new UserAPI();
        user = RandomUser.UserRandom();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.registerPage(user.getName(), user.getEmail(), user.getPassword());
        registerPage.click();
        loginPage.loginUser(user.getEmail(), user.getPassword());
        loginPage.logotipClick();
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Булки"},
                {"Соусы"},
                {"Начинки"},
        };
    }

    @Test
    @Description("Переходы по секциям в Конструторе")
    public void transitionsSectionsTest() {
        BurgerMainPage burgerMainPage = new BurgerMainPage(driver);
        burgerMainPage.sectionClick(section);
        String getTextSection = burgerMainPage.displayedSection(section);
        Assert.assertEquals(section, getTextSection);
    }
    @After
    public void tearDown(){
        if (accessToken != null){
            userAPI.deleteUser(accessToken);
        }
        driver.quit();
    }


}
