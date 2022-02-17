package Helpers;

import Tests.TestCase;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import properties.VerifyCheckoutProperties;

public class VerifyCheckoutHelper extends TestCase {

    public void selectSizeM(){
        WebElement size = getPresentElementByXpath(VerifyCheckoutProperties.SIZE_M_CHECKBOX.get());
        size.click();
    }

    public String verifyActiveFilters(){
        WebElement activeFilters = getPresentElementByXpath(VerifyCheckoutProperties.ACTIVE_FILTERS.get());
        return activeFilters.getText();
    }

    public void goToQuickView() throws InterruptedException {
        WebElement firstProduct = getPresentElementByXpath(VerifyCheckoutProperties.FIRST_PRODUCT_IMG.get());
        actions.moveToElement(firstProduct).perform();
        try {
            WebElement quickView = getPresentElementByXpath(VerifyCheckoutProperties.QUICK_VIEW.get());
            quickView.click();}catch (Exception e) {
            Thread.sleep(2000);
            WebElement quickView = getPresentElementByXpath(VerifyCheckoutProperties.QUICK_VIEW.get());
            quickView.click();
        }
    }

    public void addQuantity(){
        WebElement addQty = getPresentElementByXpath(VerifyCheckoutProperties.ADD_QTY_BUTTON.get());
        addQty.click();
    }

    public void addToCart() throws InterruptedException {
        WebElement toCart = getPresentElementByXpath(VerifyCheckoutProperties.ADD_TO_CART_BUTTON.get());
       try{
           toCart.click();} catch (Exception e){
           Thread.sleep(2000);
           toCart.click();
       }

    }

    public String checkCartQuantity(){
        WebElement cartQty = getPresentElementByXpath(VerifyCheckoutProperties.CART_QUANTITY_COUNT.get());
        return cartQty.getAttribute("innerText");
    }

    public String checkTotalPrice(){
        WebElement totalPrice = getPresentElementByXpath(VerifyCheckoutProperties.TOTAL_PRICE.get());
        return  totalPrice.getText();
    }

    public void clickProceedToCheckoutBtn(){
        WebElement proceedBtn = getPresentElementByXpath(VerifyCheckoutProperties.PROCEED_TO_CHECKOUT_BUTTON.get());
        proceedBtn.click();
    }
}
