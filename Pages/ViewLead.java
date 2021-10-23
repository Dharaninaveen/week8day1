package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Base.ProjectSpecificMethods;

public class ViewLead extends ProjectSpecificMethods {

	public ViewLead(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}

	public void viewInfo() {
		System.out.println("Created Lead");
	}
	
	public ViewLead verifyFirstName(String username) {
		String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		Assert.assertEquals(username, text);
		return this;
	}


	
}
