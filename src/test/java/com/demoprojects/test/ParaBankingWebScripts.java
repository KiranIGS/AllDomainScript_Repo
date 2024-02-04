package com.demoprojects.test;

import org.testng.annotations.Test;

public class ParaBankingWebScripts extends BaseTest{

//    @Test(priority = 1)
//    public void paraBankLogin() throws Exception {
//    	paraBankWeb.ParaBankLogin();
//    }
    
//    @Test(priority = 2)
//    public void CreateAnAccountForParaBank() throws Exception {
//    	paraBankWeb.CreateAnAccount();
//    }
    
    @Test(priority = 3)
    public void TransferFundForParaBank() throws Exception {
    	paraBankWeb.TransferFund();
    }
    



}
