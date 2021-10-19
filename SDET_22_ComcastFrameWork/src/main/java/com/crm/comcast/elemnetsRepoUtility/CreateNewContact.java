package com.crm.comcast.elemnetsRepoUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import com.crm.comcast.genericUtility.WebDriverUtility;

public class CreateNewContact extends WebDriverUtility{
	WebDriver driver;
    public  CreateNewContact(WebDriver driver) {   
	  this.driver= driver;
	  PageFactory.initElements(driver, this);
	}
    
    @FindBy(name = "lastname")
    private WebElement lastNameEdt;
    
    @FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
    private WebElement orgNameLookUpIcon;
    
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
    
	
	public void createContactWithOrg(String conatctNAme , String orgNAme) {
		lastNameEdt.sendKeys(conatctNAme);
		orgNameLookUpIcon.click();
		
		switchToWindow(driver, "Accounts&action");
		
		Organizations op = new Organizations(driver);
		op.getSearchEdt().sendKeys(orgNAme);
		op.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgNAme+"']")).click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
		
	}

}








