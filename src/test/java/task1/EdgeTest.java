package task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupManager() {
        WebDriverManager.edgedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new EdgeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void edgeTest(){
        driver.get("https://www.seleniumhq.org/");
    }
}
