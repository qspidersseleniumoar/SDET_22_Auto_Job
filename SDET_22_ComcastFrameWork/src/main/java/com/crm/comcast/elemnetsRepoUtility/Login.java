package com.crm.comcast.elemnetsRepoUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.WebDriverUtility;

public class Login  extends WebDriverUtility{   //R1 :create seprate java class for every page in Application  
		WebDriver driver;
	public  Login(WebDriver driver) {   //R3 :For Every POM class  create Constructor to get an Object of the class & initialize the Page Element 	
		  this.driver= driver;
		  PageFactory.initElements(driver, this);
		}
	
		  @FindBy(name="user_name")            //R1 : identify all the elements @findBy & @findAll , @FindBys annoation & store them specific pom class 
		  private WebElement userNameEdt;
		  
		  
		  @FindBy(name="user_password")
		  private WebElement passwordEdt;
		  
		  @FindAll({@FindBy(id="subm") , @FindBy(xpath ="//input[@type='submit']")})
		  private WebElement loginBtn;

		public WebElement getUserNameEdt() {  // R4 declare all the WebElements as private & provide getters methods to accesses elements in testScripts class 
			return userNameEdt;
		}
		
		public WebElement getPasswordEdt() {
			return passwordEdt;
		}
		
		public WebElement getLoginBtn() {
			return loginBtn;
		}
		  
		
		public void logintoApp() {
			  driver.manage().window().maximize();
		      waitUntilPageLoad(driver);
		      driver.get("http://localhost:8888");
				//perform an action on elements
		      userNameEdt.sendKeys("admin");
		      passwordEdt.sendKeys("manager");
		      loginBtn.click();
		      
		}
		
		public void logintoApp(String username , String password , String Url) {
			  driver.manage().window().maximize();
		      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		      driver.get(Url);
				//perform an action on elements
		      userNameEdt.sendKeys(username);
		      passwordEdt.sendKeys(password);
		      loginBtn.click();
		      
		}
  

}





