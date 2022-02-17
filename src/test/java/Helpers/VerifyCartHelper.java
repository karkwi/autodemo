package Helpers;

import Tests.TestCase;
import org.openqa.selenium.WebElement;
import properties.VerifyCartProperties;
import properties.VerifyCheckoutProperties;

public class VerifyCartHelper extends TestCase {

    public void goToQuickView() throws InterruptedException {
        WebElement firstProduct = getPresentElementByXpath(VerifyCartProperties.PRODUCT_IMG.get());
        actions.moveToElement(firstProduct).perform();
        try {
            WebElement quickView = getPresentElementByXpath(VerifyCheckoutProperties.QUICK_VIEW.get());
            quickView.click();
        } catch (Exception e) {
            Thread.sleep(2000);
            WebElement quickView = getPresentElementByXpath(VerifyCheckoutProperties.QUICK_VIEW.get());
            quickView.click();
        }
    }

    public void clickOnCloseBtn(){
        WebElement close = getPresentElementByXpath(VerifyCartProperties.CLOSE_BUTTON.get());
        close.click();
    }
}