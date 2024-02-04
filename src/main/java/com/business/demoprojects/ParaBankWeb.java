package com.business.demoprojects;

import com.mlWalletWebPages.ParabankLoginPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;
import static com.utility.ExtentReporter.*;
import static com.utility.Utilities.*;


public class ParaBankWeb extends BaseClass {
	public static String accNumber;
	boolean status=false;
	String amount;
	String beforeTransferAmount;
	
	/*************************************************
	 * Method Name 			: ParaBankLogin()
	 * Author				: Kiran Halagi
	 * Purpose 				: Login to the App
	 * Reviewed By 			:
	 * Modified By			:  
	 * @throws Exception	:
	 * ***********************************************
	 */
	
	public void ParaBankLogin() throws Exception {
		HeaderChildNode("Para Bank Login Process");
		String title=getWebDriver().getTitle();
		Assert.assertEquals(title, prop.getproperty("loginPageTitle"), "Actual and expected titles are not matching");
		waitTime(2000);
		type(ParabankLoginPage.objUserNameField,prop.getproperty("userName"),"Username Field"); 
		verifyElementPresentAndClick(ParabankLoginPage.objPasswordField,"Password Field");
		type(ParabankLoginPage.objPasswordField,prop.getproperty("password"),"Password Field");
		verifyElementPresentAndClick(ParabankLoginPage.objLoginBtn,"Login Button");	
		waitTime(2000);
		String homePageTitle=getWebDriver().getTitle();
		if(homePageTitle.equalsIgnoreCase("ParaBank | Accounts Overview")){
			logger.info("Para Bank Login is successful ");
			ExtentReporter.extentLoggerPass("Login", "Para Bank Login is successful ");
		}else{
			logger.info("Para Bank Login is failed");
			ExtentReporter.extentLoggerFail("Login", "Para Bank Login is failed ");	
		}
	 }
	
	/*************************************************
	 * Method Name 			: CreateAnAccount()
	 * Author				: Kiran Halagi
	 * Purpose 				: Creating an Account For the User
	 * Reviewed By 			:
	 * Modified By			: 
	 * @throws Exception	:
	 * ***********************************************
	 */
	public void CreateAnAccount() throws Exception {
		HeaderChildNode("Create An Account Process");
//		ParaBankLogin();
		verifyElementPresentAndClick(ParabankLoginPage.objCreateAccLink,"Create Account Link");	
		compareValue(getWebDriver().getTitle(),prop.getproperty("createAccountPageTitle"));
		selectDropdown(ParabankLoginPage.objTypeOfAccDropDwn, "visibleText","SAVINGS");
		waitTime(1000);
		selectDropdown(ParabankLoginPage.objAccChosserDropDwn, "selectByIndex","5");
		verifyElementPresentAndClick(ParabankLoginPage.objOpenAccBtn,"Open New Account Button");
		if(compareValue(getText(ParabankLoginPage.objAccOpenCongratsMsg), prop.getproperty("congratsAccOpenMsg"))){
			accNumber=getText(ParabankLoginPage.objAccNumber);
			logger.info("Account Created with Account number : "+accNumber+" Successfully");
			ExtentReporter.extentLoggerPass("Account", "Account Created with Account number : "+accNumber+" Successfully");
		}else{
			logger.info("Failed to open The Account");
			ExtentReporter.extentLoggerFail("Account", "Failed to open The Account");
		}
	}
	
	/*************************************************
	 * Method Name 			: AccDropDowns()
	 * Author				: Kiran Halagi
	 * Purpose 				: Handling the Dropdown irrespective of any data
	 * Reviewed By 			:
	 * Modified By			: 
	 * @throws Exception	:
	 * ***********************************************
	 */
	public void AccDropDowns() throws Exception {
		Select osel=new Select(getWebDriver().findElement(ParabankLoginPage.objToAccDropDown));
		List<WebElement>toAccNumber=osel.getOptions();
		for(WebElement ele : toAccNumber)
		{
			String accNum=ele.getText();
			if(accNum.contains(accNumber)) {
				osel.selectByVisibleText(accNumber);
				status =true;
				break; 
			}
		}	    
	}
	
	/*************************************************
	 * Method Name 			: balanceFetch()
	 * Author				: Kiran Halagi
	 * Purpose 				: Method to fetch before and after Transferred Amount
	 * Reviewed By 			:
	 * Modified By			: 
	 * @throws Exception	:
	 * ***********************************************
	 */
	public String balanceFetch() throws Exception {
		List <WebElement> totalAccounts=findElements(ParabankLoginPage.objAccNumbers);	
		waitTime(3000);
		for(WebElement ele : totalAccounts)
		{
			String accNum=ele.getText();
			if(accNum.contains(accNumber)) {
				status =true;
				amount=getText(ParabankLoginPage.objAvailableBalance(accNumber));
				//System.out.println(amount);
				break; 
			}
		}
		return amount;
	}
	
	
	/*************************************************
	 * Method Name 			: TransferFund()
	 * Author				: Kiran Halagi
	 * Purpose 				: Method to transfer from one account to another account
	 * Reviewed By 			:
	 * Modified By			: 
	 * @throws Exception	:
	 * ***********************************************
	 */
	public  void TransferFund() throws Exception {
		HeaderChildNode("Fund Transfer Process");
		ParaBankLogin();
		CreateAnAccount();
		verifyElementPresentAndClick(ParabankLoginPage.objAccOverViewLink,"Accounts Overview Link");
		compareValue(getWebDriver().getTitle(), prop.getproperty("accountsOverviewPageTitle"));
		waitTime(3000);
		beforeTransferAmount=balanceFetch();
		verifyElementPresentAndClick(ParabankLoginPage.objTranferFundsLink,"Transfer Fund Link");
		waitTime(2000);
		verifyElementPresentAndClick(ParabankLoginPage.objAmountEnterField, "Amonut Enter Field");
		type(ParabankLoginPage.objAmountEnterField, prop.getproperty("inputAmount"), "Amonut Enter Field");
		AccDropDowns();
		verifyElementPresentAndClick(ParabankLoginPage.objTranferBtn, "Transfer Button");
		if(compareValue(getText(ParabankLoginPage.objtransferCompleteMsg),"Transfer Complete!" )){
			logger.info(getText(ParabankLoginPage.objAmountTranferredSuccMsg));
			ExtentReporter.extentLoggerPass("", getText(ParabankLoginPage.objAmountTranferredSuccMsg));
			balanceCheck();
		}else{
			logger.info("Failed To Transfer the Amount");
			ExtentReporter.extentLoggerPass("", "Failed To Transfer the Amount");
		}
		
	}
	
	/*************************************************
	 * Method Name 			: balanceCheck()
	 * Author				: Kiran Halagi
	 * Purpose 				: Method To verify the before transfer and after transfer of amount
	 * Reviewed By 			:
	 * Modified By			: 
	 * @throws Exception	:
	 * ***********************************************
	 */
	public void balanceCheck() throws Exception {
		HeaderChildNode("Balance Check Process Before Transfer And After Transfer");
		logger.info("Before the Transfer Of Money Balance was : "+beforeTransferAmount);
		ExtentReporter.extentLogger("", "Before the Transfer Of Money Balance was : "+beforeTransferAmount);
		verifyElementPresentAndClick(ParabankLoginPage.objAccOverViewLink,"Accounts Overview Link");
		waitTime(3000);
		String afterMoneyTransfer=balanceFetch();
		String amountWithoutDollar = beforeTransferAmount.replaceAll("\\$", "");
		double amountDouble = Double.parseDouble(amountWithoutDollar);
		int amountInt = (int) amountDouble;
		if((amountInt+1)>amountInt) {
		    logger.info("After Transfer Amount is : "+afterMoneyTransfer);
			ExtentReporter.extentLogger("", "After Transfer Amount is : "+afterMoneyTransfer);
		}else {
			 logger.info("After Transfer Amount not got creadited for the account "+accNumber);
			 ExtentReporter.extentLoggerFail("", "After Transfer Amount not got creadited for the account "+accNumber);
		}		
	}
	
		
	
}




