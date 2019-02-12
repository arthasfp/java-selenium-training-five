package task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.File;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;
import static org.junit.Assume.assumeTrue;

public class OperaTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupManager() {
        WebDriverManager.operadriver().setup();
    }

    @Before
    public void setupTest() {
        String operaBinary = "C:\\Users\\sergii.berezhnyi\\AppData\\Local\\Programs\\Opera\\launcher.exe";
        WebDriverManager.operadriver().setup();
        OperaOptions options = new OperaOptions();
        options.setBinary(operaBinary);
        driver = new OperaDriver(options);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void operaTest(){
        driver.get("https://www.seleniumhq.org/");
    }
}
