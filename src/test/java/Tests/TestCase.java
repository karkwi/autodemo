package Tests;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static io.github.bonigarcia.wdm.WebDriverManager.getInstance;


public class TestCase {
    public static WebDriver driver;


    @Parameters("browser")
    @BeforeMethod
    protected void beforeEachTest(String browser) {
     //   System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().browserVersion("96.0.4664.110").setup();

    }

    @Parameters("browser")
    @AfterMethod
    protected void afterEachTest(ITestResult testResult, String browser) {
        if (testResult.getStatus() == ITestResult.SUCCESS)
        driver.quit();
    }

}
