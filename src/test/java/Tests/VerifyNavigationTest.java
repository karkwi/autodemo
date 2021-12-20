package Tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import properties.VerifyNavigationProperties;

public class VerifyNavigationTest extends TestCase{

@Override
@BeforeMethod
@Parameters("browser")
    protected void beforeEachTest(String browser){
    super.beforeEachTest(browser);
}

@Override
@AfterMethod
@Parameters("browser")
    protected void afterEachTest(ITestResult testResult, String browser){
    super.afterEachTest(testResult, browser);
}

@Test(description="VerifyNavigation",priority = 0)
    public void verifyNavigation(){
    driver.get(VerifyNavigationProperties.AUTOTEST_WEBSITE.get());


}

}
