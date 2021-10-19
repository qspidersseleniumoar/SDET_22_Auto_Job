package com.crm.comcast.elemnetsRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
    public  ContactInfoPage(WebDriver driver) {   
	  this.driver= driver;
	  PageFactory.initElements(driver, this);
	}
	
	@FindBy(className ="dvHeaderText")
	private WebElement orgHeaderSucFInfo;

	public WebElement getOrgHeaderSucFInfo() {
		return orgHeaderSucFInfo;
	}


	
	
}
