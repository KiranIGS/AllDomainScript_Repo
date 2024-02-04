package com.mlWalletWebPages;

import org.openqa.selenium.By;

public class InsuranceDomainPage {
	
	public static By objServiceLoginDrpdwn 		= By.xpath("//*[@id='quick-link:jump-menu']");
	public static By objEmailTextField 			= By.xpath("//*[@id='login-form:email']");
	public static By objPasswordTextField 		= By.xpath("//*[@id='login-form:password']");
	public static By objLoginBtn		 		= By.xpath("//*[@id='login-form:login']");
	public static By objSignUpBtn		 		= By.xpath("//*[@id='login-form:signup']");
	public static By objLogoutBtn				= By.xpath("//*[@name='logout-form:logout']");
	public static By obJinstantQuotePage		= By.xpath("//*[contains(text(),'Automobile Instant Quote')]");
	public static By objZipcodeTextField		= By.xpath("//*[@id='autoquote:zipcode']");
	public static By objQuoteEmailField			= By.xpath("//*[@id='autoquote:e-mail']");
	public static By objAutoMobilType			= By.xpath("//*[@value='car']");
	public static By objNextBtn					= By.xpath("//*[@id='autoquote:next']");
	public static By objIsntantQuoteContinePage = By.xpath(" //*[contains(text(),' Instant Auto Quote - Continued ')]");
	public static By objAgeTextField			= By.xpath("//*[@id='autoquote:age']");
	public static By objgenderRadioBtn				= By.xpath("//*[@value='Male']");
	public static By objDrivingRecordRadioBtn		= By.xpath("//*[@value='Excellent']");
	public static By objDrivingrecordCondition	= By.xpath("//*[@value='Excellent']/following-sibling::label");
	
	public static By objYearTextField			= By.xpath("//*[@id='autoquote:year']");
	public static By objMakeBrandDrpDwn			= By.xpath("//*[@id='ext-gen4']");
	public static By objMakeYearDrpDwnValues	= By.xpath("//*[@id='ext-gen8']/div");
	public static By objModelYearDrpDwn			= By.xpath("//*[@id='ext-gen6']");
	public static By objModelYearDrpDwnValues	= By.xpath("//*[@id='ext-gen12']/div");
	public static By objFinancialInforadioBtn	= By.xpath("//*[@value='Own']");
	
	public static By objAutomobileInfo			= By.xpath("//*[contains(text(),'Automobile Information')]");
	public static By objAutomobileType			= By.xpath("//span[@id='quote-result:type']");
	public static By objAutomobileYear			= By.xpath("//span[@id='quote-result:year']");
	public static By objMakeoFAutoMobile 		= By.xpath("//span[@id='quote-result:make']");
	public static By objModelOfTheAutomobile	= By.xpath("//span[@id='quote-result:make']");
	public static By objQuoteAmount				= By.xpath("//span[@id='quoteResult']/parent::div/following-sibling::h1");
	
	
	public static By objPersonalInfoTxt			= By.xpath("//*[contains(text(),'Personal Information')]");
	public static By objZipCodeOfOwner			= By.xpath("//span[@id='quote-result:zipcode']");
	public static By objOwnerAge				= By.xpath("//span[@id='quote-result:age']");
	public static By objGenderOfTheOwner		= By.xpath("//span[@id='quote-result:gender']");
	public static By objDrivingRecord			= By.xpath("//span[@id='quote-result:drecord']");
	
	public static By objPurchaseBtn				= By.xpath("//input[@id='quote-result:purchase-quote']");
	
	
	
	public static By objSignUpFirstNameField 	= By.xpath("//*[@id='signup:fname']");
	public static By objSignUpLastNameField 	= By.xpath("//*[@id='signup:lname']");
	public static By objBirthDateField 			= By.xpath("//*[@id='BirthDate']");
	public static By objSignUpEmailField 		= By.xpath("//*[@id='signup:email']");
	public static By objSignUpCityName			= By.xpath("//*[@id='signup:city']");
	public static By objSignUpStateDrpDwn		= By.xpath("//*[@id='signup:state']");
	public static By objSignUpPostalCodeField	= By.xpath("//*[@id='signup:zip']");
	public static By objSignUpPasswordField= By.xpath("//*[@id='signup:password']");
	public static By objSignUpMaiingAddressField= By.xpath("//*[@id='signup:street']");
	public static By objSignUpPageSignUpBtn		= By.xpath("//*[@id='signup:signup']");
	
	public static By objBirthdateDrpDwn			= By.xpath("//img[@id='ext-gen4']");
	public static By obBirthdateDrpDwnArrowbtn	= By.xpath("//*[@class=' x-btn-arrow']");
	
	public static By objDayMonthAndYearSelection(String value) {
		
		return By.xpath("//*[normalize-space()='"+value+"']");
	}
	
	public static By objOkBtn = By.xpath("//*[@class='x-date-mp-ok']");
	public static By objSignUpConfirmationMsg=By.xpath("//*[contains(text(),'Thank you for signup!')]");
	public static By objContinuetn = By.xpath("//*[@id='signup:continue']");
	
	public static By objInsurerName = By.xpath("//*[@id='content']/h1");
	public static By objContactInformation = By.xpath("//*[@id='content']/h2");
	public static By objUserEmail 		   = By.xpath("//*[@id='content']/div/label[1]");
	public static By objMailingAddres	   = By.xpath("//*[@id='content']/div/label[2]");
	public static By obUserjAddress		   = By.xpath("//*[@id='content']/div/label[3]");
	
	public static By insuranceTypeDropDwn  = By.xpath("//*[@id='quick-link:jump-menu']");
	
	public static By objHomePage		   = By.xpath("//*[@id='home']");
	
	public static By objPaymentAmountPerYear = By.xpath("//b[contains(text(),'You are agreeing to purchase the Auto policy for ')]");
	public static By objCreditCardOwnerName	 = By.xpath("//input[@id='purchaseQuote:cardname']");
	public static By objcreditcardNumber	 = By.xpath("//input[@id='purchaseQuote:cardnumber']");
	public static By objExpirationDate		 = By.xpath("//input[@id='purchaseQuote:expiration']");
	public static By objPaymentPurchase		 = By.xpath("//input[@id='purchaseQuote:purchase']");
	
	
	

}
