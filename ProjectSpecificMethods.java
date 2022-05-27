package week5.day2.assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Utility.ReadExcelDataIntegration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods  {
	public RemoteWebDriver driver;
	public String excelFileName;

	@Parameters({ "browserName", "URL" })
	@BeforeMethod
	public void startBrowser(String browserName, String url) {
		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} /*else if (browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} */
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod
	public void endBrowser() {
		driver.close();
	}	
	@DataProvider
	public String[][] readData() throws IOException {
	return ReadExcelDataIntegration.readData(excelFileName);
	}
}