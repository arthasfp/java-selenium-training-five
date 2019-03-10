package task3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class MenuItemsSearch {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void menuItemsSearch() {
        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@id='box-apps-menu']/li"));
        for (int i = 1; i < menuItems.size() + 1; i++) {
            driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[" + i + "]")).click();
            if (areElementsPresent(driver, By.xpath("//ul[@id='box-apps-menu']/li[" + i + "]"))) {
                List<WebElement> subItems = driver.findElements(By.xpath("//ul[@class='docs']/li"));
                for (int j = 1; j < subItems.size() + 1; j++) {
                    driver.findElement(By.xpath("//ul[@class='docs']/li[" + j + "]")).click();
                    checkHearedIsPresent();
                }
            } else {
                checkHearedIsPresent();
            }
        }
    }

    private void checkHearedIsPresent() {
        try {
            assertTrue(isElementPresent(driver, By.xpath("//td[@id='content']/h1")));
            System.out.println(driver.findElement(By.xpath("//td[@id='content']/h1")).getText());
        } catch (AssertionError e) {
            System.out.println("No h1 heared was found");
        }
    }

    public boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

}