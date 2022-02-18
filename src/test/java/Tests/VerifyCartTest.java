package Tests;

import Helpers.VerifyCartHelper;
import Helpers.VerifyCheckoutHelper;
import Helpers.VerifyNavigationHelper;
import org.testng.Assert;
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
    private final String CART_INFO = "W koszyku nie ma jeszcze produktów";

    @BeforeMethod
    protected void beforeEachTest() {
        super.beforeEachTest();
    }

    @AfterMethod
    protected void afterEachTest() {
        super.afterEachTest();
    }

    @Test(description = "VerifyNavigation", priority = 0)
    public void verifyCart() throws InterruptedException {
        driver.get(VerifyNavigationProperties.AUTOTEST_WEBSITE.get());
        verifyNavigationHelper.navigateToClothesTab();
        verifyCartHelper.goToQuickView();
        LOG.info("1. Add 3 Clothes to Cart");
        verifyCheckoutHelper.addQuantity();
        verifyCheckoutHelper.addQuantity();
        verifyCheckoutHelper.addToCart();
        LOG.info("2. Go to Cart");
        try{
            verifyCheckoutHelper.clickProceedToCheckoutBtn();
            }catch (Exception e){
            Thread.sleep(2000);
            verifyCheckoutHelper.clickProceedToCheckoutBtn();
        }
        LOG.info("3. Verify Shopping Cart");
        verifyCartHelper.getCartProductsQuantity();
        LOG.info("Verify Products Quantity");
        String productsQuantity = verifyCartHelper.getCartProductsQuantity();
        Assert.assertTrue(productsQuantity.contains("3"));
        LOG.info("Verify Products Value");
        verifyCartHelper.getCartProductsValue();
        String productsValue = verifyCartHelper.getCartProductsValue();
        Assert.assertTrue(productsValue.contains("105,98"));
        LOG.info("4. Delete All Clothes");
        try{
            verifyCartHelper.deleteProductsFromCart();
        }catch (Exception e){
            Thread.sleep(3000);
            verifyCartHelper.deleteProductsFromCart();
        }
        LOG.info("5. Verify if there are no more items in your cart");
        Thread.sleep(2000);
        verifyCartHelper.verifyCartInfo();
        String cartInfo = verifyCartHelper.verifyCartInfo();
        Assert.assertEquals(cartInfo,CART_INFO);
        LOG.info("6. Click continue shopping");
        verifyCartHelper.clickContinueShopping();
        LOG.info("6. Verify Main Page");
        driver.getCurrentUrl();
        String getURL = String.format(driver.getCurrentUrl());
        Assert.assertEquals(getURL, VerifyNavigationProperties.AUTOTEST_WEBSITE.get());
    }

}