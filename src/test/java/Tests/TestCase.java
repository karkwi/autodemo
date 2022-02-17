package Tests;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestCase {
    public static WebDriver driver;
    public static WebDriverWait driverWait;
    public static Actions actions;



    @BeforeMethod
    protected void beforeEachTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
     }


    @AfterMethod
    protected void afterEachTest() {
        //if (testResult.getStatus() == ITestResult.SUCCESS)
        driver.quit();
    }

    public WebElement getPresentElementByXpath(String xpath) {
        driverWait = new WebDriverWait(this.driver, 45);
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void scrollToElement(WebElement element) {
        String scrollElementIntoMiddle =
                "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                        + "var elementTop = arguments[0].getBoundingClientRect().top;"
                        + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) this.driver).executeScript(scrollElementIntoMiddle, element);
    }

    public void clickElementByJSExecutor(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


}
