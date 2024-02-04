package com.business.demoprojects;

import static com.utility.ExtentReporter.HeaderChildNode;
import static com.utility.Utilities.getWebDriver;
import static com.utility.Utilities.type;
import static com.utility.Utilities.verifyElementPresentAndClick;
import static com.utility.Utilities.waitTime;

import java.util.List;

import static com.utility.Utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.mlWalletWebPages.AirlIneDomainPage;
import com.utility.ExtentReporter;


public class AirlineDomainWeb extends BaseClass {
	String attributes = null;
	boolean status=false;
	
	public void airLineLoginProcess() throws Exception {
		HeaderChildNode("AirLine Login Process");
		String title=getWebDriver().getTitle();
		Assert.assertEquals(title, prop.getproperty("airlineLoginPageTitle"), "Actual and expected titles are not matching");
		waitTime(2000);
		type(AirlIneDomainPage.objUserNameField,prop.getproperty("airlineuserName"),"Username Field"); 
		verifyElementPresentAndClick(AirlIneDomainPage.objPasswordField,"Password Field");
		type(AirlIneDomainPage.objPasswordField,prop.getproperty("airlinePassword"),"Password Field");
		verifyElementPresentAndClick(AirlIneDomainPage.objSignInBtn,"Sign In Button");	
		waitTime(2000);
		if(compareValue(getText(AirlIneDomainPage.objSignInSuccesMsg),prop.getproperty("airlineSignInSuccMsg"))){
			logger.info("Trvel Agile way Login is successful ");
			ExtentReporter.extentLoggerPass("Login", "Trvel Agile way Login is successful ");
		}else{
			logger.info("Trvel Agile way Login is failed");
			ExtentReporter.extentLoggerFail("Login", "Trvel Agile way Login is failed");	
		}
	 }
	
	public void radioButtonHandling(String typeOfJourney) throws Exception {
	 List<WebElement>radioBtn=getWebDriver().findElements(AirlIneDomainPage.objTripTypeRadioBtn);
		if(typeOfJourney.contains("Return")){
			radioBtn.get(0).click();
			logger.info("Selected Jorney Type : "+typeOfJourney);
			ExtentReporter.extentLogger("Journey Type","Selected Jorney Type : "+typeOfJourney);	
		}else if(typeOfJourney.contains("One Way")){
			radioBtn.get(1).click();
			logger.info("Selected Jorney Type : "+typeOfJourney);
			ExtentReporter.extentLogger("Journey Type","Selected Jorney Type : "+typeOfJourney);
		}else if(typeOfJourney.contains("Visa")){
			radioBtn.get(0).click();
			logger.info("Selected Payment Type : "+typeOfJourney);
			ExtentReporter.extentLogger("Journey Type","Selected Jorney Type : "+typeOfJourney);
		}else if(typeOfJourney.contains("Master")){
			radioBtn.get(1).click();
			logger.info("Selected Payment Type : "+typeOfJourney);
			ExtentReporter.extentLogger("Journey Type","Selected Jorney Type : "+typeOfJourney);
		}else{
			logger.info("Invalid Jorney Type Selected");
			ExtentReporter.extentLoggerFail("Journey Type","Invalid Jorney Type Selected");
		}
	}
	
	public String getAttributeValueOfDrpDwn(String nameAttributeValue) throws InterruptedException
	{	
		List<WebElement>values=getWebDriver().findElements(AirlIneDomainPage.objDropDwnAttributeValues);
		for(WebElement attributeval : values)
		{	
			attributes=attributeval.getAttribute("name");
			if(attributes.equalsIgnoreCase(nameAttributeValue))
			{
				break;
			}
		}
		return attributes;
	}
		
	public void calenderDropDowns(String nameAttributeValue ,String expecteddropDownValue, String dropDownType) throws Exception {
		getAttributeValueOfDrpDwn(nameAttributeValue);
		Select osel=new Select(getWebDriver().findElement(AirlIneDomainPage.objDateDropDownHandling(attributes)));
		List<WebElement>actualdropdwnVal=osel.getOptions();
		for(WebElement ele : actualdropdwnVal)
		{
			String accNum=ele.getText();
			if(accNum.contains(expecteddropDownValue)) {
				osel.selectByVisibleText(expecteddropDownValue);
				status =true;
				break; 
			}
		}
		logger.info("From the "+dropDownType+" selected the Drop Down Value : "+expecteddropDownValue);
		ExtentReporter.extentLogger("", "From the "+dropDownType+" selected the Drop Down Value : "+expecteddropDownValue);
	}
	
	public void bookingType(String bookinType) throws Exception {
		HeaderChildNode("Type of Ticket Booking");	
		if(bookinType.contains("One Way")){
		   radioButtonHandling(bookinType);
		   calenderDropDowns("fromPort","Sydney","From Dropdown");
		   calenderDropDowns("toPort","New York","To Dropdown");
		   calenderDropDowns("departDay","05","Day Dropdown");
		   calenderDropDowns("departMonth","Feburary 2024","Month Dropdown");   		   
		}else if(bookinType.contains("Return")) {
			radioButtonHandling(bookinType);
			calenderDropDowns("fromPort","Sydney","From Dropdown");
			calenderDropDowns("toPort","New York","To Dropdown");
			calenderDropDowns("departDay","05","Day Dropdown");
			calenderDropDowns("departMonth","Feburary 2024","Month Dropdown");
			logger.info("===================Selecting return date======================");
			ExtentReporter.extentLogger("","===================Selecting return date======================");
			calenderDropDowns("returnDay","08","Retrun Day Dropdown"); 
			calenderDropDowns("returnMonth","Feburary 2024","Return Month Dropdown");
		}
		verifyElementPresentAndClick(AirlIneDomainPage.objContinueBtn, "Continue Button");
	}
	
	public void passengerDetails() throws Exception {
		HeaderChildNode("Adding Passenger Details");
		compareValue(getText(AirlIneDomainPage.objPassengerDetailsPageTitle),prop.getproperty("airlinePassengerDetailsPageTitle"));
		verifyElementPresentAndClick(AirlIneDomainPage.objPassengerFirstName, "Passenger Firstname Field");
		type(AirlIneDomainPage.objPassengerFirstName, "Hello", "Passenger Firstname Field");
		verifyElementPresentAndClick(AirlIneDomainPage.objPassengerLastName, "Passenger Lastname Field");
		type(AirlIneDomainPage.objPassengerLastName, "Hi", "Passenger Lastname Field");
		verifyElementPresentAndClick(AirlIneDomainPage.objNextBtn, "Next Button");	
	}
	
	public void paymentMethod() throws Exception {
		HeaderChildNode("Payment Method Details");
		compareValue(getText(AirlIneDomainPage.objPaymentPageTitle),prop.getproperty("airlinePaymentPageTitle"));
		logger.info("Fair Charge for the trave is : "+getText(AirlIneDomainPage.objFareCharge));
		ExtentReporter.extentLogger("Fare", "Fair Charge for the trave is : "+getText(AirlIneDomainPage.objFareCharge));
		radioButtonHandling("Visa");
		String cardHoldersname=getWebDriver().findElement(AirlIneDomainPage.objCardHolderName).getAttribute("value");
		logger.info("Card Holder Name : "+cardHoldersname);
		ExtentReporter.extentLogger("","Card Holder Name : "+cardHoldersname);
		verifyElementPresentAndClick(AirlIneDomainPage.objCardNumber, "Card Number Text Field");
		type(AirlIneDomainPage.objCardNumber, "1234567887654321", "Card Number Text Field");
		calenderDropDowns("expiry_month", "08", "Card Expiry Date Dropdown");
		calenderDropDowns("expiry_year", "2027", "Card Expiry Month Dropdown");
		verifyElementPresentAndClick(AirlIneDomainPage.objPayNowBtn, "Paynow Button");
		if(compareValue(getText(AirlIneDomainPage.objPaymentConfirmationMg), "Confirmation")){
			String bookingNumber=getText(AirlIneDomainPage.objBookingId);
			String passengerName=getText(AirlIneDomainPage.objPassengerDetails);
			logger.info("Payment is successful! and booking is confirmed with booking ID "+bookingNumber+" For the "+passengerName);
			ExtentReporter.extentLoggerPass("Booking Confirmed","Payment is successful! and booking is confirmed with booking ID "+bookingNumber+" For the "+passengerName);
		}else{
			logger.info("Failed book the ticket");
			ExtentReporter.extentLoggerFail("", "Failed book the ticket");
		}
	}
	
	public void airlineBookinge2eJourney(String journeyType) throws Exception {
		airLineLoginProcess();
		Thread.sleep(2000);
		bookingType(journeyType); 
		passengerDetails();
		paymentMethod();		
	}
		
 

}



