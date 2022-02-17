package Tests;

import Helpers.VerifyCartHelper;
import Helpers.VerifyCheckoutHelper;
import Helpers.VerifyNavigationHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import properties.VerifyCartProperties;
import properties.VerifyNavigationProperties;

import java.util.logging.Logger;

public class VerifyCartTest extends TestCase {
    VerifyCheckoutHelper verifyCheckoutHelper = new VerifyCheckoutHelper();
    VerifyNavigationHelper verifyNavigationHelper = new VerifyNavigationHelper();
    VerifyCartHelper verifyCartHelper = new VerifyCartHelper();

    private final static Logger LOG = Logger.getLogger(Logger.class.getName());

    @BeforeMethod
    protected void beforeEachTest() {
        super.beforeEachTest();
    }

    @AfterMethod
    protected void afterEachTest() {
        super.afterEachTest();
    }

    @Test(description = "VerifyNavigation", priority = 0)
    public void verifyNavigation() throws InterruptedException {
        driver.get(VerifyNavigationProperties.AUTOTEST_WEBSITE.get());
        verifyNavigationHelper.navigateToClothesTab();
        verifyCartHelper.goToQuickView();
        LOG.info("1. Add 3 Clothes to Cart");
        verifyCheckoutHelper.addQuantity();
        verifyCheckoutHelper.addQuantity();
        LOG.info("Click Add to Cart");
        verifyCheckoutHelper.addToCart();
        verifyCartHelper.clickOnCloseBtn();
        LOG.info("2. Go to Cart");

    }

}