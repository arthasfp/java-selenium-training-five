package task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariTest {
    private WebDriver safariDriver;
    private WebDriver ieDriver;

    @BeforeClass
    public static void setupManager() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.iedriver().setup();
    }

    @Before
    public void setupTest() {
        safariDriver = new SafariDriver();
        ieDriver = new InternetExplorerDriver();
    }

    @After
    public void teardown() {
        if (safariDriver != null) {
            safariDriver.quit();
        }
        if (ieDriver != null) {
            ieDriver.quit();
        }
    }


    @Test
    public void safariTest(){
        safariDriver.get("https://www.seleniumhq.org/");
    }

    @Test
    public void internetExplorerTest(){
        ieDriver.get("https://www.seleniumhq.org/");
    }
}
