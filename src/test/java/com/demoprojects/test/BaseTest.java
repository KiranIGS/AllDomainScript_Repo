
package com.demoprojects.test;

import com.aventstack.extentreports.ExtentTest;
import com.business.demoprojects.*;

import org.testng.Reporter;
import org.testng.annotations.*;
import com.driverInstance.AppiumServer;
import com.propertyfilereader.PropertyFileReader;
import com.utility.ExtentReporter;
import com.utility.LoggingUtils;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import static com.utility.Utilities.softAssert;
import static com.utility.Utilities.*;

public class BaseTest  {
	
    protected com.business.demoprojects.BaseClass baseClass;


    
    protected ParaBankWeb paraBankWeb;
    protected AirlineDomainWeb airlineDomainWeb;
    protected InsuranceDomainWeb insuranceDomainWeb;

    public static ExtentTest testLogger;
    AppiumServer server = new AppiumServer();
    protected static LoggingUtils logger = new LoggingUtils();
    public static PropertyFileReader prop;
    public String osName = System.getProperty("os.name").toLowerCase();

    //To Read Properties File Based On Current OS Of Laptop
    public void propertyFileReader() {
        if (osName.contains("mac") || osName.contains("linux") ||osName.contains("windows")) {
            System.out.println(osName);
            prop = new PropertyFileReader(".//properties//testdata.properties");
        } else {
            prop = new PropertyFileReader(".\\properties\\testdata.properties");
        }

    }



    //Start Application
    @Parameters({"deviceName", "portno"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(String deviceName, String portno) throws Exception {
    	String domainName=Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("domain");
        baseClass = new BaseClass("MLWALLET", deviceName, portno);
        switch(domainName)
    	{
    		case "Banking" :
    			  paraBankWeb =new ParaBankWeb();
    			break;
    			
    		case "Airline" :
    		     airlineDomainWeb=new AirlineDomainWeb();
    		     break; 
    		     
    		case "Insurance" :
    			insuranceDomainWeb=new InsuranceDomainWeb();
    			break;
    			
    		default :
    			System.out.println("Invalid Domain Name Selected");
    	}
      // mlWalletWeb = new MLWalletWeb();
      ///  paraBankWeb =new ParaBankWeb();
       // airlineDomainWeb=new AirlineDomainWeb();
      //  insuranceDomainWeb=new InsuranceDomainWeb();
        propertyFileReader();
        softAssert = new SoftAssert();
    }


//    Stop Application
    @AfterMethod
    public void afterTest() {
        baseClass.tearDown();
    }


}
