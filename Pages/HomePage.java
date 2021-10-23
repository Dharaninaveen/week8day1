package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {
	
	public HomePage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}

	public MyHomePage clickCrmsfaLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage(driver,prop);
	}
	
	public HomePage verifyHomePage() {
		
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		Assert.assertTrue(displayed);
		
		return this;
	}


}
