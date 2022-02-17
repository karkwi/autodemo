package Tests;

import Helpers.VerifyCheckoutHelper;
import Helpers.VerifyNavigationHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import properties.VerifyNavigationProperties;

import java.util.logging.Logger;

public class VerifyCheckoutTest extends TestCase {
    VerifyNavigationHelper verifyNavigationHelper = new VerifyNavigationHelper();
    VerifyCheckoutHelper verifyCheckoutHelper = new VerifyCheckoutHelper();

    private final static Logger LOG = Logger.getLogger(Logger.class.getName());
    private final String CART_QUANTITY_INFO = "Ilość produktów w Twoim koszyku: 2.";
    private final String TOTAL_PRICE = "70,65 zł (brutto)";

    @BeforeMethod
    protected void beforeEachTest() {
        super.beforeEachTest();
    }

    @AfterMethod
    protected void afterEachTest() {
        super.afterEachTest();
    }

    @Test(description = "VerifyCheckout", priority = 0)
    public void verifyCheckout() throws InterruptedException {
        LOG.info("1. Go to Women page and select Size M");
        driver.get(VerifyNavigationProperties.WOMEN_URL.get());
        verifyCheckoutHelper.selectSizeM();
        LOG.info("2. Verify active filters");
        verifyCheckoutHelper.verifyActiveFilters();
        String activeFilters = String.format(verifyCheckoutHelper.verifyActiveFilters());
        Assert.assertTrue(activeFilters.contains("Rozmiar: M"));
        LOG.info("3. Click quick view on first product");
        verifyCheckoutHelper.goToQuickView();
        LOG.info("4. Add Quantity 2");
        verifyCheckoutHelper.addQuantity();
        LOG.info("5. Click Add to Cart");
        verifyCheckoutHelper.addToCart();
        LOG.info("6. Verify quantity");
        verifyCheckoutHelper.checkCartQuantity();
        String cartQuantity = verifyCheckoutHelper.checkCartQuantity();
        Assert.assertEquals(cartQuantity,CART_QUANTITY_INFO);
        LOG.info("7. Verify Total Price");
        verifyCheckoutHelper.checkTotalPrice();
        String totalPrice = verifyCheckoutHelper.checkTotalPrice();
        Assert.assertTrue(totalPrice.contains(TOTAL_PRICE));
        LOG.info("8. Click Proceed to Checkout");
        verifyCheckoutHelper.clickProceedToCheckoutBtn();
    }
}
