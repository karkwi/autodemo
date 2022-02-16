package Tests;

import Helpers.VerifyNavigationHelper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import properties.VerifyNavigationProperties;

public class VerifyNavigationTest extends TestCase{
    VerifyNavigationHelper verifyNavigationHelper = new VerifyNavigationHelper();

@BeforeMethod
    protected void beforeEachTest(){
    super.beforeEachTest();
}

@AfterMethod
    protected void afterEachTest(){
    super.afterEachTest();
}

@Test(description="VerifyNavigation",priority = 0)
    public void verifyNavigation(){
    driver.get(VerifyNavigationProperties.AUTOTEST_WEBSITE.get());
    verifyNavigationHelper.navigateToClothesTab();

}

}
