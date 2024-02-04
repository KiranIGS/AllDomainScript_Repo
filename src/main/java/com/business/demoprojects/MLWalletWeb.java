package com.business.demoprojects;

import com.driverInstance.DriverManager;
import com.mlWalletWebPages.MLShopHomePage;
import com.mlWalletWebPages.MLShopProfileLoginPage;
import com.mlWalletWebPages.MLShopRingsPage;
import com.mlWalletWebPages.MLShopWatchPage;
import com.utility.ExtentReporter;
import com.utility.Utilities;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.business.demoprojects.BaseClass.prop;
import static com.utility.ExtentReporter.*;
import static com.utility.Utilities.*;

public class MLWalletWeb extends BaseClass{

    public void profileLogin() throws Exception {
        if(verifyElementPresent(MLShopProfileLoginPage.objProfileIcon,"Profile Icon")) {
//           click(MLShopProfileLoginPage.objProfileIcon, "Profile Icon");
//            click(MLShopProfileLoginPage.objMobileNumberInputField, "Mobile Number input field");
            waitTime(2000);
            type(MLShopProfileLoginPage.objMobileNumberInputField, prop.getproperty("Branch_Verified"), "Mobile Number Input field");
           
//            click(MLShopProfileLoginPage.objLoginBtn, "Get OTP Button");
//            verifyElementPresent(MLShopProfileLoginPage.objOTPPopup, "One Time Pin popup");
//            type(MLShopProfileLoginPage.objOTpInputField, prop.getproperty("Valid_OTP"), "ONe Time Pin Input field");
//            verifyElementPresent(MLShopProfileLoginPage.objSuccessfullyLoginPopup, "Successfully login popup");
//            waitTime(5000);
//            verifyElementPresentAndClick(MLShopProfileLoginPage.objOkayBtn, "Okay Button");
        }
    }

    public void mlShopProfileNameAndDropDownValidation() throws Exception {
        HeaderChildNode("Shop Items, Profile name and its dropdown elements validation");
        waitTime(15000);
        profileLogin();
        verifyElementPresentAndClick(MLShopProfileLoginPage.objProfileName,getTextVal(MLShopProfileLoginPage.objProfileName, "Profile Name"));
        if(verifyElementPresent(MLShopProfileLoginPage.objProfileDropDownElement,getTextVal(MLShopProfileLoginPage.objProfileDropDownElement,"DropdownElement"))){
            verifyElementPresent(MLShopProfileLoginPage.objPurchaseHistoryDropDownElement,getTextVal(MLShopProfileLoginPage.objPurchaseHistoryDropDownElement,"DropdownElement"));
            verifyElementPresent(MLShopProfileLoginPage.objLogOutDropDownElement,getTextVal(MLShopProfileLoginPage.objLogOutDropDownElement,"DropdownElement"));
            logger.info("Shop Items, Profile name and its dropdown elements validated");
            extentLoggerPass("", "Shop Items, Profile name and its dropdown elements validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsProfilePageNavigation() throws Exception {
        HeaderChildNode("Shop Items, Profile page navigation validation");
        waitTime(15000);
        profileLogin();
        verifyElementPresentAndClick(MLShopProfileLoginPage.objProfileName,getTextVal(MLShopProfileLoginPage.objProfileName, "Profile Name"));
        verifyElementPresentAndClick(MLShopProfileLoginPage.objProfileDropDownElement,getTextVal(MLShopProfileLoginPage.objProfileDropDownElement,"DropdownElement"));
        if(verifyElementPresent(MLShopProfileLoginPage.objFullNameInProfilePage,getTextVal(MLShopProfileLoginPage.objFullNameInProfilePage,"Full Name in Profile page"))){
            verifyElementPresent(MLShopProfileLoginPage.objEmailAddressInProfilePage,getTextVal(MLShopProfileLoginPage.objEmailAddressInProfilePage,"Email Address in Profile page"));
            verifyElementPresent(MLShopProfileLoginPage.objMobileNumberInProfilePage,getTextVal(MLShopProfileLoginPage.objMobileNumberInProfilePage,"Mobile Number in Profile page"));
            logger.info("Shop Items, Profile page navigation validated");
            extentLoggerPass("", "Shop Items, Profile page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPurchaseHistoryPageNavigation() throws Exception {
        HeaderChildNode("Shop Items, Purchase History page navigation validation");
        waitTime(15000);
        profileLogin();
        verifyElementPresentAndClick(MLShopProfileLoginPage.objProfileName,getTextVal(MLShopProfileLoginPage.objProfileName, "Profile Name"));
        verifyElementPresentAndClick(MLShopProfileLoginPage.objPurchaseHistoryDropDownElement,getTextVal(MLShopProfileLoginPage.objPurchaseHistoryDropDownElement,"DropdownElement"));
        if (verifyElementPresent(MLShopProfileLoginPage.objMLShopItemsInPurchaseHistory,"ML Shop ItemsPurchase History"))// "Pay Bills"
        {
            List<WebElement> values = findElements(MLShopProfileLoginPage.objMLShopItemsInPurchaseHistory);
            int sMLShopItems = values.size();
            logger.info("ML Shop Purchase history contains "+sMLShopItems+ " Items");
            extentLogger(" ", "ML Shop Purchase history contains "+sMLShopItems+" Items");
            logger.info("Shop Items, Purchase History page navigation validated");
            extentLoggerPass("", "Shop Items, Purchase History page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsLogoutValidation() throws Exception {
        HeaderChildNode("Shop Items Logout validation");
        waitTime(15000);
        profileLogin();
        verifyElementPresentAndClick(MLShopProfileLoginPage.objProfileName,getTextVal(MLShopProfileLoginPage.objProfileName, "Profile Name"));
        verifyElementPresentAndClick(MLShopProfileLoginPage.objLogOutDropDownElement,getTextVal(MLShopProfileLoginPage.objLogOutDropDownElement,"DropdownElement"));
     //   verifyElementNotPresentForWeb(MLShopProfileLoginPage.objProfileName,5);
        logger.info("Shop Items , Profile Logged out successfully validated");
        extentLoggerPass("", "Shop Items, Profile Logged out successfully validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsProfileSuccessfulLogin() throws Exception {
        HeaderChildNode("Shop Items Profile Successful login validation");
        waitTime(15000);
        profileLogin();
        if(verifyElementPresent(MLShopProfileLoginPage.objProfileName,getTextVal(MLShopProfileLoginPage.objProfileName, "Profile Name"))){
            logger.info("Shop Items Profile Successful login validated");
            extentLoggerPass("", "Shop Items Profile Successful login validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAvailableJewelryItemsValidation() throws Exception {
        HeaderChildNode("Shop Items, Available Jewelry items validation");
        waitTime(15000);
        scrollByWEB(0,500);
        if (verifyElementPresent(MLShopHomePage.objAvailableJewelryItem,"Available Jewelry item"))// "Pay Bills"
        {
            List<WebElement> values = findElements(MLShopHomePage.objAvailableJewelryItem);
            for (int i = 0; i < values.size(); i++) {
                String sAvailableJewelryItems = values.get(i).getText();
                logger.info(sAvailableJewelryItems + " Available Jewelry Item is displayed");
                extentLogger(" ", sAvailableJewelryItems + " Available Jewelry Item is displayed");
            }
        }
        logger.info("Shop Items, Available Jewelry items validated");
        extentLoggerPass("", "Shop Items, Available Jewelry items validated");
        System.out.println("-----------------------------------------------------------");
    }
    public void shopItemsWatchItemsValidation() throws Exception {
        HeaderChildNode("Shop Items, Watch items validation");
        waitTime(15000);
        scrollByWEB(0, 1000);
        if (verifyElementPresent(MLShopHomePage.objWatchesItems, "Watch item"))// "Pay Bills"
        {
            List<WebElement> values = findElements(MLShopHomePage.objWatchesItems);
            int nAvailableJewelryItems = values.size();
            logger.info("Available Watch covers = " + nAvailableJewelryItems);
            extentLogger(" ", "Available Watch covers = " + nAvailableJewelryItems);
        }
        logger.info("Shop Items, Watch items validated");
        extentLoggerPass("", "Shop Items, Watch items validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsRingsProductTypePageNavigationValidation() throws Exception {
        HeaderChildNode("Shop Items, Rings product type page navigation validation");
        waitTime(15000);
        verifyElementPresent(MLShopHomePage.objGreatSummerSale,getTextVal(MLShopHomePage.objGreatSummerSale,"Header"));
        scrollByWEB(0,500);
        verifyElementPresentAndClick(MLShopRingsPage.objRingsItemBtn,getTextVal(MLShopRingsPage.objRingsItemBtn,"Button"));
        if (verifyElementPresent(MLShopRingsPage.objProductsDisplayed,"Rings product type page"))// "Pay Bills"
        {
            List<WebElement> values = findElements(MLShopRingsPage.objProductsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String sRingDisplayed = values.get(i).getText();
                logger.info(sRingDisplayed + " product is displayed");
                extentLogger(" ", sRingDisplayed + " product is displayed");
            }
        }
        logger.info("Shop Items, Rings product type page navigation validated");
        extentLoggerPass("", "Shop Items, Rings product type page navigation validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsNecklacesAndPendantsProductTypePageNavigationValidation() throws Exception {
        HeaderChildNode("Shop Items, Necklaces And Pendants product type page navigation validation");
        waitTime(15000);
        verifyElementPresent(MLShopHomePage.objGreatSummerSale,getTextVal(MLShopHomePage.objGreatSummerSale,"Header"));
        scrollByWEB(0,500);
        verifyElementPresentAndClick(MLShopHomePage.objNecklacesAndPendants,getTextVal(MLShopHomePage.objNecklacesAndPendants,"Button"));
        if (verifyElementPresent(MLShopRingsPage.objProductsDisplayed,"Necklaces And Pendants product type page"))// "Pay Bills"
        {
            List<WebElement> values = findElements(MLShopRingsPage.objProductsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String sNecklacesAndPendantsDisplayed = values.get(i).getText();
                logger.info(sNecklacesAndPendantsDisplayed + " product is displayed");
                extentLogger(" ", sNecklacesAndPendantsDisplayed + " product is displayed");
            }
        }
        logger.info("Shop Items, Necklaces And Pendants product type page navigation validated");
        extentLoggerPass("", "Shop Items, Necklaces And Pendants product type page navigation validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsBraceletsAndBanglesProductTypePageNavigationValidation() throws Exception {
        HeaderChildNode("Shop Items, Bracelets And Bangles product type page navigation validation");
        waitTime(15000);
        verifyElementPresent(MLShopHomePage.objGreatSummerSale,getTextVal(MLShopHomePage.objGreatSummerSale,"Header"));
        scrollByWEB(0,500);
        verifyElementPresentAndClick(MLShopHomePage.objBraceletsAndBangles,getTextVal(MLShopHomePage.objBraceletsAndBangles,"Button"));
        if (verifyElementPresent(MLShopRingsPage.objProductsDisplayed,"Bracelets And Bangles product type page"))// "Pay Bills"
        {
            List<WebElement> values = findElements(MLShopRingsPage.objProductsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String sBraceletsAndBanglesDisplayed = values.get(i).getText();
                logger.info(sBraceletsAndBanglesDisplayed + " product is displayed");
                extentLogger(" ", sBraceletsAndBanglesDisplayed + " product is displayed");
            }
        }
        logger.info("Shop Items, Bracelets And Bangles product type page navigation validated");
        extentLoggerPass("", "Shop Items, Bracelets And Bangles product type page navigation validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void shopItemsEarringsProductTypePageNavigationValidation() throws Exception {
        HeaderChildNode("Shop Items, Earrings product type page navigation validation");
        waitTime(15000);
        verifyElementPresent(MLShopHomePage.objGreatSummerSale,getTextVal(MLShopHomePage.objGreatSummerSale,"Header"));
        scrollByWEB(0,500);
        verifyElementPresentAndClick(MLShopHomePage.objEarrings,getTextVal(MLShopHomePage.objEarrings,"Button"));
        if (verifyElementPresent(MLShopRingsPage.objProductsDisplayed,"Earrings product type page"))// "Pay Bills"
        {
            List<WebElement> values = findElements(MLShopRingsPage.objProductsDisplayed);
            for (int i = 0; i < values.size(); i++) {
                String sEarringsDisplayed = values.get(i).getText();
                logger.info(sEarringsDisplayed + " product is displayed");
                extentLogger(" ", sEarringsDisplayed + " product is displayed");
            }
        }
        logger.info("Shop Items, Earrings product type page navigation validated");
        extentLoggerPass("", "Shop Items, Earrings product type page navigation validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsWatchProductTypePageNavigationValidation() throws Exception {
        HeaderChildNode("Shop Items, Watch product type page navigation validation");
        waitTime(15000);
        scrollByWEB(0,800);
        verifyElementPresentAndClick(MLShopWatchPage.objWatchItem,getTextVal(MLShopWatchPage.objWatchItem,"Image"));
        if (verifyElementPresent(MLShopWatchPage.objWatchProductDisplayed,"Watches product type page"))// "Pay Bills"
        {
            List<WebElement> values = findElements(MLShopWatchPage.objWatchProductDisplayed);
            List<WebElement> values2 = findElements(MLShopWatchPage.objWatchAmounts);
            List<WebElement> values3 = findElements(MLShopWatchPage.objDiscountBanners);
            for (int i = 0; i < values.size(); i++) {
                String sWatchesDisplayed = values.get(i).getText();
                String sWatchAmount = values2.get(i).getText();
                String sDiscountBanner = values3.get(i).getText();
                logger.info("Product = " +sWatchesDisplayed+ " is displayed");
                logger.info("Product Amount = " + sWatchAmount + " is displayed");
                logger.info("Discount Banner = " + sDiscountBanner + " is displayed");
                extentLogger(" ", "Product = " +sWatchesDisplayed+ " is displayed");
                extentLogger(" ", "Product Amount = " + sWatchAmount + " is displayed");
                extentLogger(" ", "Discount Banner = " + sDiscountBanner + " is displayed");
            }
        }
        logger.info("Shop Items, Watch product type page navigation validated");
        extentLoggerPass("", "Shop Items, Watch product type page navigation validated");
        System.out.println("-----------------------------------------------------------");
    }




    public void shopItemsRingProductPurchaseScenario() throws Exception {
        HeaderChildNode("Shop Items Rings Product purchase scenario");
        waitTime(5000);
        switchPlatformToAndroid(); 
        DriverManager.getAppiumDriver().navigate().back();
        DriverManager.getAppiumDriver().quit();
       
//        waitTime(2000);
//        new Utilities().setPlatform("Web");
//        getDriver().switchTo().defaultContent();
        
        switchPlatformToWeb("https://mlshoppreprod.mlhuillier.com/");
      
        profileLogin();
        scrollByWEB(0,500);
        verifyElementPresentAndClick(MLShopRingsPage.objRingsItemBtn,getTextVal(MLShopRingsPage.objRingsItemBtn,"Button"));
        verifyElementPresentAndClick(MLShopRingsPage.objRingsProduct,getTextVal(MLShopRingsPage.objRingsProduct,"Ring Product"));
//        waitTime(5000);
//        verifyElementPresentAndClick(MLShopRingsPage.objAddToCartBtn,getTextVal(MLShopRingsPage.objAddToCartBtn,"Button"));
//        waitTime(5000);
//        verifyElementPresent(MLShopRingsPage.objPopup,getTextVal(MLShopRingsPage.objPopup,"Popup"));
//        verifyElementPresentAndClick(MLShopRingsPage.objConfirmBtn,getTextVal(MLShopRingsPage.objConfirmBtn,"button"));
//        verifyElementPresentAndClick(MLShopRingsPage.objCartIcon,"Cart icon");
//        verifyElementPresentAndClick(MLShopRingsPage.objCheckout,getTextVal(MLShopRingsPage.objCheckout,"Button"));
//        scrollByWEB(0,200);
//        waitTime(10000);
//        selectByVisibleTextFromDD(MLShopRingsPage.objBranchNameDropdown,"ML CAMALIG ALBAY");
//        scrollByWEB(0,300);
//        verifyElementPresentAndClick(MLShopRingsPage.objMLWalletOption,getTextVal(MLShopRingsPage.objMLWalletOption,"payment option"));
//        waitTime(5000);
//        verifyElementPresentAndClick(MLShopRingsPage.objPlaceOrder,getTextVal(MLShopRingsPage.objPlaceOrder,"button"));
//        waitTime(5000);
//        verifyElementPresent(MLShopRingsPage.objPopup,getTextVal(MLShopRingsPage.objPopup,"Popup"));
//        verifyElementPresentAndClick(MLShopRingsPage.objProceedBtn,getTextVal(MLShopRingsPage.objProceedBtn,"button"));
//        verifyElementPresent(MLShopProfileLoginPage.objOTPPopup, "One Time Pin popup");
//        type(MLShopProfileLoginPage.objOTpInputField, prop.getproperty("Valid_OTP"), "ONe Time Pin Input field");
//        if(verifyElementPresent(MLShopRingsPage.objPopup,getTextVal(MLShopRingsPage.objPopup,"popup"))){
//            verifyElementPresent(MLShopProfileLoginPage.objOkayBtn,getTextVal(MLShopProfileLoginPage.objOkayBtn,"Button"));
//            logger.info("Shop Items Rings Product purchase scenario validated");
//            extentLoggerPass("", "Shop Items Rings Product purchase scenario validated");
//            System.out.println("-----------------------------------------------------------");
//        }

    }





}
