package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods {
	
	public MyHomePage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}

	public MyLeads clickLead() {
		driver.findElement(By.linkText(prop.getProperty("MyHomePage.Leads.LinkText"))).click();
		return new MyLeads(driver,prop);
	}

}
