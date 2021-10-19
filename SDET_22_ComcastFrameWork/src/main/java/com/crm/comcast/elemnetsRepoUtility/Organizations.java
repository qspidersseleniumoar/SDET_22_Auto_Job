package com.crm.comcast.elemnetsRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	
	WebDriver driver;
    public  Organizations(WebDriver driver) {   
	  this.driver= driver;
	  PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt = 'Create Organization...']")
	private WebElement createOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	

	
	

	public WebElement getSearchEdt() {
		return searchEdt;
	}






	public WebElement getSearchBtn() {
		return searchBtn;
	}






	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}
	
	

}
