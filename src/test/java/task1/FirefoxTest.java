package task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {
    private WebDriver mozillaDriver;

    @BeforeClass
    public static void setupManager() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setupTest() {
        mozillaDriver = new FirefoxDriver();
    }

    @After
    public void teardown() {
        if (mozillaDriver != null) {
            mozillaDriver.quit();
        }
    }

    @Test
    public void firefoxTest(){
        mozillaDriver.get("https://www.seleniumhq.org/");
    }
}
