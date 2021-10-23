package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.ProjectSpecificMethods;


public class MyLeads extends ProjectSpecificMethods {

	public MyLeads(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}

	public CreateLead clickCreateLead() {
		driver.findElement(By.linkText(prop.getProperty("MyLeadsPage.createlead.LinkText"))).click();
		return new CreateLead(driver,prop);
	}
}
