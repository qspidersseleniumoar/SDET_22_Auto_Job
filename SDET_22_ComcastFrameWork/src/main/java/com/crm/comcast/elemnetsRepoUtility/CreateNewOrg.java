package com.crm.comcast.elemnetsRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.WebDriverUtility;

public class CreateNewOrg extends WebDriverUtility{
	WebDriver driver;
    public  CreateNewOrg(WebDriver driver) {   
	  this.driver= driver;
	  PageFactory.initElements(driver, this);
	}
    
	@FindBy(name="accountname")
    private WebElement orgNameEdt;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
	
	@FindBy(name="industry")
    private WebElement industriesEdt;
	
	@FindBy(name="employees")
    private WebElement empEdt;
	
	
	@FindBy(name="email2")
    private WebElement emailEdt;
	
	


	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * create new org with mandatory info
	 * @param orgName
	 */
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	/**
	 * create new org with industries & emp count info
	 * @param orgName
	 */
	public void createOrg(String orgName, String industries , String emp) {
		orgNameEdt.sendKeys(orgName);
		SelectOption(industriesEdt, industries);
		empEdt.sendKeys(emp);
		saveBtn.click();
	}
	
	public void createOrg(String orgName, String industries , String emp ,String email) {
		orgNameEdt.sendKeys(orgName);
		SelectOption(industriesEdt, industries);
		empEdt.sendKeys(emp);
		emailEdt.sendKeys(email);
		saveBtn.click();
	}
	
	
	
}





