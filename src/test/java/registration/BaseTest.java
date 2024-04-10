package registration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageStellarBurgers.BasePage;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = getDriver();
    }

   private WebDriver getDriver(){
       String driverType = System.getenv("BROWSER");

    if (driverType == null){
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
               return new ChromeDriver();
    }
        switch (driverType.toLowerCase()) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/java/resources/yandexdriver.exe");
                return new ChromeDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser");
        }
    }

}
