package com.crm.comcast.elemnetsRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
	WebDriver driver;
    public  Contacts(WebDriver driver) {   
	  this.driver= driver;
	  PageFactory.initElements(driver, this);
	}
    
    @FindBy(xpath = "//img[@alt='Create Contact...']")
    private WebElement  createContactBtn;
	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
    
    
	

}
