package practice;

import org.testng.annotations.Test;

public class ContactTest {
	
	@Test
	public void createContact() {
       System.out.println("execute hdfc createContact");
	}	
	
	
	@Test(dependsOnMethods = "createContact")
	public void createContactWithEmail() {
       System.out.println("execute hdfc createContactWithEmail");
	}	
		
	
	@Test(dependsOnMethods = "createContact")
	public void modifyConatct() {
       System.out.println("execute hdfc modifyConatct");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void deleteCoantct() {
       System.out.println("execute hdfc deleteCoantct");
	}
	
	

}
