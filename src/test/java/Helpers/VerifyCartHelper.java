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
            WebElement quickView = getPresentElementByXpath(VerifyCartProperties.QUICK_VIEW.get());
            quickView.click();
        } catch (Exception e) {
            Thread.sleep(2000);
            WebElement quickView = getPresentElementByXpath(VerifyCartProperties.QUICK_VIEW.get());
            quickView.click();
        }
    }

    public String getCartProductsQuantity(){
        WebElement productsQuantity = getPresentElementByXpath(VerifyCartProperties.CART_PRODUCTS_QTY.get());
        return productsQuantity.getText();
    }

    public String getCartProductsValue(){
        WebElement productsValue = getPresentElementByXpath(VerifyCartProperties.CART_PRODUCTS_PRICE.get());
        return productsValue.getText();
    }

    public void deleteProductsFromCart(){
        WebElement delete = getPresentElementByXpath(VerifyCartProperties.CART_DELETE.get());
        delete.click();
    }

    public String verifyCartInfo(){
        WebElement cart = getPresentElementByXpath(VerifyCartProperties.CART_INFO.get());
        return cart.getAttribute("innerText");
    }

    public void clickContinueShopping(){
        WebElement continueShopping = getPresentElementByXpath(VerifyCartProperties.CONTINUE_SHOPPING.get());
        continueShopping.click();
    }
}