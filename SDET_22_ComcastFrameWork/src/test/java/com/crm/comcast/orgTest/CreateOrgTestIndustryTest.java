package com.crm.comcast.orgTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.elemnetsRepoUtility.CreateNewOrg;
import com.crm.comcast.elemnetsRepoUtility.Home;
import com.crm.comcast.elemnetsRepoUtility.Login;
import com.crm.comcast.elemnetsRepoUtility.OrgInfoPage;
import com.crm.comcast.elemnetsRepoUtility.Organizations;
import com.crm.comcast.genericUtility.ExcelUtility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

public class CreateOrgTestIndustryTest {

	@Test
	 public void createOrgTestWithIndustriesTest() throws Throwable {
		/*create Objects */
		ExcelUtility elib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		WebDriver driver = null;
		
		/*read common data*/
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		/*read test data*/
		String orgName = elib.getExcelData("org", 4, 2) + "_"+jLib.getRandomData();
		String industries = elib.getExcelData("org", 4, 3);
		String employeCount = elib.getExcelData("org", 4, 4);
	
		/*step 1 : launch the Browser*/
		if(BROWSER.equals("firefox")) {
		    driver = new FirefoxDriver();
	      }else if(BROWSER.equals("chrome")){
		    driver = new ChromeDriver();
	      }else if(BROWSER.equals("ie")){
		    driver = new InternetExplorerDriver();
	      }else {
	    	   driver = new ChromeDriver();
	      }
	
		/*step 2 : login to app*/
		driver.get(URL);
		Login lp = new Login(driver);
		lp.logintoApp(USERNAME, PASSWORD, URL);
		
		/*step 3 : navigate to Org*/
		Home hp = new Home(driver);
		hp.getOrgLnk().click();	
		
		/*step 4 : navigate to create Org Page*/
		Organizations op = new Organizations(driver);
		op.getCreateOrgBtn().click();
		
		/*step 5 : create org*/
		CreateNewOrg cnop = new CreateNewOrg(driver);
		cnop.createOrg(orgName, industries, employeCount);
		
		/*step 6 : verify */
		OrgInfoPage oinfop = new  OrgInfoPage(driver);
		wLib.waitForElementVisibility(driver, oinfop.getOrgHeaderSucFInfo());
		String actSucMsg = oinfop.getOrgHeaderSucFInfo().getText();
		if(actSucMsg.contains(orgName)) {
			System.out.println("org is created successfully==>PASS");
		}else {
			System.out.println("org is not created successfully==>FAIL");

		}
		
		/*step 7 : logout */
	   hp.logout();
		
		/*step 8 : close the Browser */
		driver.close();
		


	}

}
