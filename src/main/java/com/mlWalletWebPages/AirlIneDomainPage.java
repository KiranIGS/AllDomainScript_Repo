package com.mlWalletWebPages;

import org.openqa.selenium.By;

public class AirlIneDomainPage {
	
	public static By objUserNameField 		= By.xpath("//*[@name='username']");
	public static By objPasswordField 		= By.xpath("//*[@name='password']");
	public static By objSignInBtn			= By.xpath("//*[@value='Sign in']");
	public static By objSignInSuccesMsg		= By.xpath("//*[@id='flash_notice']");
	
	public static By objFlightBookingPage	= By.xpath("//*[contains(text(),'Select Flight')]");
	public static By objTripTypeRadioBtn	= By.xpath("//*[@type='radio']");
	
	public static By objDateDropDownHandling(String nameAttributeValue)
	{
		return By.xpath("//*[@name='"+nameAttributeValue+"']");
	}
	
	public static By objContinueBtn				= By.xpath("//*[@value='Continue']");
	public static By objDropDwnAttributeValues  = By.xpath("//select");
	
 
	public static By objPassengerDetailsPageTitle=By.xpath("//*[contains(text(),'Passenger Details')]");
	public static By objPassengerFirstName		= By.xpath("//*[@name='passengerFirstName']");
	public static By objPassengerLastName		= By.xpath("//*[@name='passengerLastName']");
	public static By objNextBtn					= By.xpath("//input[@value='Next']");
	
	public static By objPaymentPageTitle		= By.xpath("//*[contains(text(),'Pay by Credit Card')]");
	public static By objFareCharge				= By.xpath("//div[2]");
	public static By objCardHolderName			= By.xpath("//*[@name='holder_name']");
	public static By objCardNumber				= By.xpath("//*[@name='card_number']");
	public static By objPayNowBtn				= By.xpath("//input[@value='Pay now']");
	
	public static By objPaymentConfirmationMg	= By.xpath("//*[contains(text(),'Confirmation')]");
	public static By objBookingId				= By.xpath("//span[@id='booking_number']");
	public static By objPassengerDetails		= By.xpath("//*[@id='confirmation']/p[2]/label");
	

}
