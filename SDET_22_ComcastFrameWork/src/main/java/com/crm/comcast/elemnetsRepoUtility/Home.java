package com.crm.comcast.elemnetsRepoUtility;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.WebDriverUtility;
/**
 * 
 * @author Deepak
 *
 */
public class Home  extends WebDriverUtility{
	
	WebDriver driver;
    public  Home(WebDriver driver) {   
	  this.driver= driver;
	  PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLnk;
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement singnOutLnk;

	
	
	public WebElement getAdminstratorIcon() {
		return adminstratorIcon;
	}

	public WebElement getSingnOutLnk() {
		return singnOutLnk;
	}

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}
	/**
	 * logout from app
	 */
	public void logout() {
		mouseOver(driver, adminstratorIcon);
		singnOutLnk.click();
		
	}
	

}
