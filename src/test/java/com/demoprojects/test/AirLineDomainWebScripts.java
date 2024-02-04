package com.demoprojects.test;

import org.testng.annotations.Test;

public class AirLineDomainWebScripts extends BaseTest {

	@Test(priority = 1)
    public void airLineBookingE2EJourney() throws Exception {
		airlineDomainWeb.airlineBookinge2eJourney("Return"); //One Way //Return
    }
	
	
	
	
	
}
