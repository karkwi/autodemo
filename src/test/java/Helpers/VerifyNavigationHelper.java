package Helpers;

import Tests.TestCase;
import org.openqa.selenium.WebElement;
import properties.VerifyNavigationProperties;

public class VerifyNavigationHelper extends TestCase {

    public void navigateToClothesTab(){
        WebElement clothesTab = getPresentElementByXpath(VerifyNavigationProperties.CLOTHES_TAB.get());
        clothesTab.click();
    }

    public void navigateToWomenTab(){
        WebElement womenTab = getPresentElementByXpath(VerifyNavigationProperties.WOMEN_TAB.get());
        womenTab.click();
    }
 }

