package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCase {
    WebDriver driver = new ChromeDriver();
    WebDriverWait driverWait = new WebDriverWait(this.driver, 45);
}
