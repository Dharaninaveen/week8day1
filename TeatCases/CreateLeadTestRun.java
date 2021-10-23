package TeatCases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethods;
import Pages.LoginPage;

public class CreateLeadTestRun extends ProjectSpecificMethods {

	@BeforeTest
	public void setFileName() {
		excelFileName="CreateLead";
		testName="Create Lead";
		testDescription="CreateLead with LeafTaps application";
		testAuthor="Dharani";
		testCategory="Smoke";
		
	}
	
	@Test(dataProvider="fetchData")
	public void runCreateLead(String username,String password,String cname,String fname,String lname,String phnum) {
		LoginPage lp=new LoginPage(driver,prop);
		lp.enterUserName(username).enterPassword(password).clickLogin().clickCrmsfaLink().clickLead().clickCreateLead().enterCompanyName(cname)
		.enterFirstName(fname).enterLastName(lname).enterPhoneNumber(phnum).clickSubmit().verifyFirstName(fname);
	}
}
