package task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerTest {
    private WebDriver ieDriver;

    @BeforeClass
    public static void setupManager() {
        WebDriverManager.iedriver().setup();
    }

    @Before
    public void setupTest() {
        ieDriver = new InternetExplorerDriver();
    }

    @After
    public void teardown() {
        if (ieDriver != null) {
            ieDriver.quit();
        }
    }

    @Test
    public void internetExplorerTest(){
        ieDriver.get("https://www.seleniumhq.org/");
    }
}
