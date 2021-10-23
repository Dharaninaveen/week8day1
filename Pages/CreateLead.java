package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.ProjectSpecificMethods;

public class CreateLead extends ProjectSpecificMethods {
	
	public CreateLead(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	public CreateLead enterFirstName(String fname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		return this;
	}
	public CreateLead enterLastName(String lname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		return this;
	}
	public CreateLead enterCompanyName(String cname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		return this;
	}
	public CreateLead enterPhoneNumber(String phnum) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnum);
		return this;
	}
	public ViewLead clickSubmit() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLead(driver,prop);
	}
	

}
