package task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorerTest {
    private WebDriver ieDriver;

    @BeforeClass
    public static void setupManager() {
        WebDriverManager.iedriver().setup();
    }

    @Before
    public void setupTest() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        ieDriver = new InternetExplorerDriver(caps);
    }

    @After
    public void teardown() {
        if (ieDriver != null) {
            ieDriver.quit();
        }
    }

    @Test
    public void internetExplorerTest() {
        ieDriver.get("https://www.seleniumhq.org/");
    }
}
