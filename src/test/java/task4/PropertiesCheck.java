package task4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PropertiesCheck {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.iedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setupTest() {
//        driver = new ChromeDriver();

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        driver = new InternetExplorerDriver(caps);

        driver = new FirefoxDriver();

        driver.get("http://localhost/litecart");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void menuItemsSearch() {
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='name']")).getText(), "Yellow Duck");

        WebElement regularPriceMain = driver.findElement(By.xpath("//*[@class='regular-price']"));
        Assert.assertEquals(regularPriceMain.getText(), "$20");
        Assert.assertEquals(regularPriceMain.getCssValue("color"), "rgba(119, 119, 119, 1)");
        Assert.assertEquals(regularPriceMain.getCssValue("text-decoration"), "line-through solid rgb(119, 119, 119)");

        WebElement campaignPriceMain = driver.findElement(By.xpath("//*[@class='campaign-price']"));
        Assert.assertEquals(campaignPriceMain.getText(), "$18");
        Assert.assertEquals(campaignPriceMain.getCssValue("color"), "rgba(204, 0, 0, 1)");
        Assert.assertEquals(campaignPriceMain.getCssValue("font-weight"), "700");

        driver.findElement(By.xpath("//div[@id='box-campaigns']//ul/li[1]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='title']")).getText(), "Yellow Duck");

        WebElement regularPrice = driver.findElement(By.xpath("//*[@class='regular-price']"));
        Assert.assertEquals(regularPrice.getText(), "$20");
        Assert.assertEquals(regularPrice.getCssValue("color"), "rgba(102, 102, 102, 1)");
        Assert.assertEquals(regularPrice.getCssValue("text-decoration"), "line-through solid rgb(102, 102, 102)");

        WebElement campaignPrice = driver.findElement(By.xpath("//*[@class='campaign-price']"));
        Assert.assertEquals(campaignPrice.getText(), "$18");
        Assert.assertEquals(campaignPrice.getCssValue("color"), "rgba(204, 0, 0, 1)");
        Assert.assertEquals(campaignPrice.getCssValue("font-weight"), "700");
    }

}
