package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.elemnetsRepoUtility.Login;

public class CreateOrganization_Pratice {
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
      Login l = new Login(driver);
		l.logintoApp();
      
      
		
		
	}

}
