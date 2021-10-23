package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;


public class ProjectSpecificMethods {
	
	public ChromeDriver driver;
	public String excelFileName;
	public Properties prop;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName,testDescription,testAuthor,testCategory;
	
	@BeforeSuite
	public void startMethod() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@DataProvider(name="fetchData",indices=0)
	public String[][] sendData() throws IOException{
		return ReadExcel.readData(excelFileName);
	}
	
	@BeforeClass
	public void setTestCaseDetails() {
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testAuthor);
		test.assignAuthor(testCategory);
	}
	@Parameters({"language"})
	@BeforeMethod
	public void preCondition(String lang) throws IOException {
		FileInputStream fis=new FileInputStream("./src/main/resources/"+ lang +".properties");
		prop=new Properties();
		prop.load(fis);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	@AfterSuite
	public void stopMethod() {
		extent.flush();
	}
}
