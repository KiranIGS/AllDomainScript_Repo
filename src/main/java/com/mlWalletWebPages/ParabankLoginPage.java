package com.mlWalletWebPages;

import org.openqa.selenium.By;

import com.business.demoprojects.ParaBankWeb;

public class ParabankLoginPage {
	
	public static By objUserNameField 		= By.xpath("//*[@name='username']");
	public static By objPasswordField 		= By.xpath("//*[@name='password']");
	public static By objLoginBtn	  		= By.xpath("//*[@value='Log In']");
	public static By objCreateAccLink 		= By.xpath("//*[contains(text(),'Open New Account')]");
	public static By objOpenAccBtn 			= By.xpath("//*[@value='Open New Account']");
	public static By objTypeOfAccDropDwn 	= By.xpath("//*[@id='type']");
	public static By objAccChosserDropDwn 	= By.xpath("//*[@id='fromAccountId']");
	public static By objAccOpenCongratsMsg 	= By.xpath("//*[contains(text(),'Congratulations, your account is now open.')]");
	public static By objAccNumber			= By.xpath("//a[@id='newAccountId']");
	public static By objAccOverViewLink		= By.xpath("//a[contains(text(),'Accounts Overview')]");
	public static By objAccNumbers			= By.xpath("//tbody/tr/td[1]");
	public static By objAvailableBalance(String accNum)
	{
		return By.xpath("//tbody/tr/td/a[text()='"+accNum+"']/parent::td/following-sibling::td");
	}	
	public static By objTranferFundsLink	= By.xpath("//a[contains(text(),'Transfer Funds')]");	
	public static By objAmountEnterField	= By.xpath("//input[@id='amount']");
	public static By objFromAccDropDown		= By.xpath("//select[@id='fromAccountId']");
	public static By objToAccDropDown		= By.xpath("//select[@id='toAccountId']");
	public static By objTranferBtn			= By.xpath("//input[@value='Transfer']");
	public static By objAmountTranferredSuccMsg	= By.xpath("//div[@id='rightPanel']//p[1]");
	public static By objtransferCompleteMsg	= By.xpath("//*[contains(text(),'Transfer Complete!')]");
			
	
}
