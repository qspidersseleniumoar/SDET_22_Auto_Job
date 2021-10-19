package com.crm.comcast.conatctTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.elemnetsRepoUtility.ContactInfoPage;
import com.crm.comcast.elemnetsRepoUtility.Contacts;
import com.crm.comcast.elemnetsRepoUtility.CreateNewContact;
import com.crm.comcast.elemnetsRepoUtility.CreateNewOrg;
import com.crm.comcast.elemnetsRepoUtility.Home;
import com.crm.comcast.elemnetsRepoUtility.Login;
import com.crm.comcast.elemnetsRepoUtility.OrgInfoPage;
import com.crm.comcast.elemnetsRepoUtility.Organizations;
import com.crm.comcast.genericUtility.ExcelUtility;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

public class CreateContactWithOrgTest {
	
	
	@Test
	public void createCoantctWithOrgTest() throws Throwable { 
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
		String orgName = elib.getExcelData("contact", 4, 2) + "_"+jLib.getRandomData();
		String contactNAme = elib.getExcelData("contact", 4, 3);

	
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
		cnop.createOrg(orgName);
		
		/*step 6 : verify */
		OrgInfoPage oinfop = new  OrgInfoPage(driver);
		wLib.waitForElementVisibility(driver, oinfop.getOrgHeaderSucFInfo());
		String actSucMsg = oinfop.getOrgHeaderSucFInfo().getText();
		if(actSucMsg.contains(orgName)) {
			System.out.println("org is created successfully==>PASS");
		}else {
			System.out.println("org is not created successfully==>FAIL");

		}
		
		/*step 7 : navigate to contact Page*/
		 hp.getContactLnk().click();
		 
		/*step 8 : navigate to create new contact Page*/
		 Contacts cp = new Contacts(driver);
		 cp.getCreateContactBtn().click();
		
		/*step 9 : create contact*/
		 CreateNewContact cncp = new CreateNewContact(driver);
		 cncp.createContactWithOrg(contactNAme, orgName);
		
		/*step 9 : verify  contact info */
		 ContactInfoPage cip = new ContactInfoPage(driver);
			wLib.waitForElementVisibility(driver, cip.getOrgHeaderSucFInfo());
			String actSucMsg2 = cip.getOrgHeaderSucFInfo().getText();
			if(actSucMsg2.contains(contactNAme)) {
				System.out.println("contact is created successfully==>PASS");
			}else {
				System.out.println("contact is not created successfully==>FAIL");

			}
		
		/*step 7 : logout */
	   hp.logout();
		
		/*step 8 : close the Browser */
		driver.close();
	}

}
