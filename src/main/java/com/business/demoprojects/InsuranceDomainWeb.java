package com.business.demoprojects;
import static com.utility.Utilities.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.mlWalletWebPages.AirlIneDomainPage;
import com.mlWalletWebPages.InsuranceDomainPage;
import com.utility.ExtentReporter;


public class InsuranceDomainWeb extends BaseClass {
	boolean status=false;
	Faker faker = new Faker();
	
	//InsuranceDomainPage.objSignUpStateDrpDwn
	public void selectStateDropDwn(String stateName, By locator) throws Exception { 
		Select osel=new Select(getWebDriver().findElement(locator));
		List<WebElement>stateNames=osel.getOptions();
		for(WebElement ele : stateNames)
		{
			String stateNameVal=ele.getText();
			if(stateNameVal.contains(stateName)) {
				osel.selectByVisibleText(stateName);
				status =true;
				break; 
			}
		}	    
	}
	
	
	public void InsurancePageLogin() throws Exception {
		HeaderChildNode("Insurance Domain Login");
		String title=getWebDriver().getTitle();
		Assert.assertEquals(title, prop.getproperty("insuranceDomainHomePageTitle"), "Actual and expected titles are not matching");
		verifyElementPresentAndClick(InsuranceDomainPage.objSignUpBtn,"Sign Up Button");
		compareValue(getWebDriver().getTitle(),prop.getproperty("insuranceDomainSignUpPageTitle"));
		verifyElementPresentAndClick(InsuranceDomainPage.objSignUpFirstNameField,"Sign Up Firstname Field");	
		type(InsuranceDomainPage.objSignUpFirstNameField, faker.name().firstName(),"Sign Up Firstname Field");
		verifyElementPresentAndClick(InsuranceDomainPage.objSignUpLastNameField,"Sign Up Lastname Field");
		type(InsuranceDomainPage.objSignUpLastNameField, faker.name().lastName(),"Sign Up Lastname Field");
		verifyElementPresentAndClick(InsuranceDomainPage.objBirthdateDrpDwn,"Birth date selection dropdown");
		verifyElementPresentAndClick(InsuranceDomainPage.obBirthdateDrpDwnArrowbtn,"Birth date arrow selection dropdown");
		verifyElementPresentAndClick(InsuranceDomainPage.objDayMonthAndYearSelection("Feb"),"Birth Month selected from dropdown");
		verifyElementPresentAndClick(InsuranceDomainPage.objDayMonthAndYearSelection("202"+RandomNumberGenerator(9)),"Birth Year selected from dropdown");
		verifyElementPresentAndClick(InsuranceDomainPage.objOkBtn,"Ok button");
		verifyElementPresentAndClick(InsuranceDomainPage.objDayMonthAndYearSelection(RandomNumberGenerator(30)),"Birth Date selected from dropdown");
		verifyElementPresentAndClick(InsuranceDomainPage.objSignUpEmailField,"Sign Up Email Field");
		type(InsuranceDomainPage.objSignUpLastNameField, faker.name().firstName()+"@gmail.com","Sign Up Lastname Field");	
		verifyElementPresentAndClick(InsuranceDomainPage.objSignUpMaiingAddressField,"Sign Up Mailing Address Field");
		type(InsuranceDomainPage.objSignUpMaiingAddressField, faker.name().firstName()+"@gmail.com","Sign Up Mailing Address Field");
		verifyElementPresentAndClick(InsuranceDomainPage.objSignUpCityName,"Sign Up page city name");
		type(InsuranceDomainPage.objSignUpCityName, prop.getproperty("signUpCityName"),"Sign Up page city name");	
		selectStateDropDwn("Florida",InsuranceDomainPage.objSignUpStateDrpDwn);
		verifyElementPresentAndClick(InsuranceDomainPage.objSignUpPostalCodeField,"Sign Up postal code field");
		type(InsuranceDomainPage.objSignUpCityName, prop.getproperty("signUpPostalCode"),"Sign Up postal code field");
		verifyElementPresentAndClick(InsuranceDomainPage.objSignUpPasswordField,"Sign Up password field");
		type(InsuranceDomainPage.objSignUpPasswordField, prop.getproperty("signUpPassword"),"Sign Up password field");
		verifyElementPresentAndClick(InsuranceDomainPage.objSignUpPageSignUpBtn,"Sign Up page signup button");
		if(compareValue(getText(InsuranceDomainPage.objSignUpConfirmationMsg), prop.getproperty("signUpConfirmationMsg"))){
			verifyElementPresentAndClick(InsuranceDomainPage.objContinuetn,"Continue Button");
			logger.info("Signup is Sucessful");
			ExtentReporter.extentLoggerPass("", "Signup is Sucessful");
		}else {
			logger.info("Failed to Signup to the application");
			ExtentReporter.extentLoggerPass("", "Failed to Signup to the application");
		}
	}
	
	
	public void insuranceLogin() throws Exception {
		HeaderChildNode("Insurance Login Process");
		verifyElementPresentAndClick(InsuranceDomainPage.objEmailTextField, "Email Text Field");
		type(InsuranceDomainPage.objEmailTextField, prop.getproperty("insuranceuserName"), "Email Text Field");
		verifyElementPresentAndClick(InsuranceDomainPage.objPasswordTextField, "Password Text Field");
		type(InsuranceDomainPage.objPasswordTextField, prop.getproperty("insurancePassword"), "Email Text Field");
		verifyElementPresentAndClick(InsuranceDomainPage.objLoginBtn, "Login Button");
		if(verifyElementPresent(InsuranceDomainPage.objLogoutBtn, "Logout Button")){
			logger.info("Insurance page login is successful ");
			ExtentReporter.extentLoggerPass("Login", "Insurance page login is successful ");
		}else{
			logger.info("Insurance page login is failed ");
			ExtentReporter.extentLoggerFail("Login", "Insurance page login is failed ");	
		}
	}
	
	public void brandAndModelSelectionDrpDwn(String brandNameAndModel, By locator) throws Exception {
		List<WebElement> brandName=getWebDriver().findElements(locator); //InsuranceDomainPage.objMakeBrandDrpDwn
		for(WebElement brand : brandName )
		{	
			if(brand.getText().contains(brandNameAndModel));
			{
				verifyElementPresentAndClick(InsuranceDomainPage.objDayMonthAndYearSelection(brandNameAndModel),getText(InsuranceDomainPage.objDayMonthAndYearSelection(brandNameAndModel)).concat(" Brand Name"));
				break;
			}
		}
	}
	
	public void typeOfInsurance(String brandNameOfVehicle,String model) throws Exception {
		HeaderChildNode("Car Insurance Process");
		selectStateDropDwn("Auto Quote",InsuranceDomainPage.objServiceLoginDrpdwn);
		compareValue(getText(InsuranceDomainPage.obJinstantQuotePage).trim(), prop.getproperty("instantQuotePage"));
		verifyElementPresentAndClick(InsuranceDomainPage.objZipcodeTextField, "Zip Code Text Field");
		type(InsuranceDomainPage.objZipcodeTextField, prop.getproperty("zipcode"), "Zip Code Text Field");
		verifyElementPresentAndClick(InsuranceDomainPage.objQuoteEmailField, "Email Text Field");
		type(InsuranceDomainPage.objQuoteEmailField, faker.name().firstName()+"@gmail.com", "Email Text Field");
		verifyElementPresentAndClick(InsuranceDomainPage.objAutoMobilType, getWebDriver().findElement(InsuranceDomainPage.objAutoMobilType).getAttribute("value"));
		verifyElementPresentAndClick(InsuranceDomainPage.objNextBtn, "Next Button");
		compareValue(getText(InsuranceDomainPage.objIsntantQuoteContinePage).trim(), prop.getproperty("instantQuoteContinuePage"));
		verifyElementPresentAndClick(InsuranceDomainPage.objAgeTextField, "Age Text Field");
		type(InsuranceDomainPage.objAgeTextField,"28","Age Field");
		verifyElementPresentAndClick(InsuranceDomainPage.objgenderRadioBtn, getWebDriver().findElement(InsuranceDomainPage.objgenderRadioBtn).getAttribute("value").concat(" Radio Button"));
		verifyElementPresentAndClick(InsuranceDomainPage.objDrivingRecordRadioBtn, getWebDriver().findElement(InsuranceDomainPage.objDrivingRecordRadioBtn).getAttribute("value").concat(" Radio Button"));
		verifyElementPresentAndClick(InsuranceDomainPage.objNextBtn, "Next Button");
		verifyElementPresentAndClick(InsuranceDomainPage.objYearTextField,"Year Text Field");
		type(InsuranceDomainPage.objYearTextField, "202"+RandomNumberGenerator(4),"Year Text Field");
		verifyElementPresentAndClick(InsuranceDomainPage.objMakeBrandDrpDwn,"Make brand Dropdown");
		brandAndModelSelectionDrpDwn(brandNameOfVehicle,InsuranceDomainPage.objMakeYearDrpDwnValues);
		verifyElementPresentAndClick(InsuranceDomainPage.objModelYearDrpDwn,"Type of model Dropdown");
		brandAndModelSelectionDrpDwn(model,InsuranceDomainPage.objModelYearDrpDwnValues);
		verifyElementPresentAndClick(InsuranceDomainPage.objFinancialInforadioBtn,getWebDriver().findElement(InsuranceDomainPage.objFinancialInforadioBtn).getAttribute("value").concat(" Radio Button"));
		verifyElementPresentAndClick(InsuranceDomainPage.objNextBtn, "Next Button");	
	}
	
	public void detailsOfOwnerAndVehicle() throws Exception {
		HeaderChildNode("Vehicle and Owner Details");
		logger.info("=================="+getText(InsuranceDomainPage.objPersonalInfoTxt)+"======================");
	    ExtentReporter.extentLogger("", "=================="+getText(InsuranceDomainPage.objPersonalInfoTxt)+"======================");
		verifyElementPresent(InsuranceDomainPage.objZipCodeOfOwner,getText(InsuranceDomainPage.objZipCodeOfOwner).concat(" : Owner Zip Code"));
		verifyElementPresent(InsuranceDomainPage.objOwnerAge,getText(InsuranceDomainPage.objOwnerAge).concat(" : Owner Age ")); 
		verifyElementPresent(InsuranceDomainPage.objGenderOfTheOwner,getText(InsuranceDomainPage.objGenderOfTheOwner).concat(" : Owner Gender "));
		verifyElementPresent(InsuranceDomainPage.objDrivingRecord,getText(InsuranceDomainPage.objDrivingRecord).concat(" : Owner Driver Record "));
		logger.info("=================="+getText(InsuranceDomainPage.objAutomobileInfo)+"======================");
	    ExtentReporter.extentLogger("", "=================="+getText(InsuranceDomainPage.objAutomobileInfo)+"======================");
	    verifyElementPresent(InsuranceDomainPage.objAutomobileType,getText(InsuranceDomainPage.objAutomobileType).concat(" : Automobile Type"));
	    verifyElementPresent(InsuranceDomainPage.objAutomobileYear,getText(InsuranceDomainPage.objAutomobileYear).concat(" : Automobile Year")); 
	    verifyElementPresent(InsuranceDomainPage.objMakeoFAutoMobile,getText(InsuranceDomainPage.objMakeoFAutoMobile).concat(" : Automobile Make"));
	    verifyElementPresent(InsuranceDomainPage.objModelOfTheAutomobile,getText(InsuranceDomainPage.objModelOfTheAutomobile).concat(" : Automobile Model"));
	    verifyElementPresent(InsuranceDomainPage.objQuoteAmount,getText(InsuranceDomainPage.objQuoteAmount).concat(" : Automobile Quote Amount")); 
	    verifyElementPresentAndClick(InsuranceDomainPage.objPurchaseBtn,"Purchase Button");
	}
	
	public void paymentPage() throws Exception {
		HeaderChildNode("Payment Details");
		verifyElementPresent(InsuranceDomainPage.objPaymentAmountPerYear,getText(InsuranceDomainPage.objPaymentAmountPerYear));
		verifyElementPresent(InsuranceDomainPage.objCreditCardOwnerName,getWebDriver().findElement(InsuranceDomainPage.objCreditCardOwnerName).getAttribute("value").concat(" card holder name"));
		verifyElementPresent(InsuranceDomainPage.objcreditcardNumber,"Credit Card Number Text Field");
		type(InsuranceDomainPage.objcreditcardNumber, prop.getproperty("creditcardnumber"), "Credit Card Number Text Field");
		verifyElementPresent(InsuranceDomainPage.objExpirationDate,"Expiration Text Field");
		type(InsuranceDomainPage.objExpirationDate, prop.getproperty("expirydate"), "Expiration Text Field");
		verifyElementPresent(InsuranceDomainPage.objPaymentPurchase,"Purchase Button");
		
	}
	

}
