package com.demoprojects.test;

import org.testng.annotations.Test;

public class InsuranceDomainWebScripts extends BaseTest {
	
	@Test(priority = 1)
    public void insuranceE2EJourney() throws Exception {
//		insuranceDomainWeb.InsurancePageLogin();
//		insuranceDomainWeb.buyInsurance();
		insuranceDomainWeb.insuranceLogin();
		insuranceDomainWeb.typeOfInsurance("Toyota", "Hilux");
		insuranceDomainWeb.detailsOfOwnerAndVehicle();
		insuranceDomainWeb.paymentPage();
		
    }
	

}
