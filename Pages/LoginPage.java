package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	public LoginPage enterUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		return this;
	}
	public LoginPage enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		return this;

	}
	public HomePage clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new HomePage(driver,prop);

	}
}
