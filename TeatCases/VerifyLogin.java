package TeatCases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.LoginPage;




public class VerifyLogin extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		excelFileName="CreateLead";
		testName="VerifyLogin";
		testDescription="Login with positive credential";
		testAuthor="Dharani1";
		testCategory="Smoke";
		
	}
	
	@Test
	public void runLogin() throws InterruptedException {
		
		
		LoginPage lp = new LoginPage(driver,prop);
		lp.enterUserName("demosalesmanager")
		.enterPassword("crmsfa")
		.clickLogin()
		.verifyHomePage();

	}

}
