package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	public void setup(String br) throws IOException {

		switch (br) {

		case "chrome":
			driver = new ChromeDriver(); break;
		case "firefox":
			driver = new FirefoxDriver(); break;
		case "edge":
			driver = new EdgeDriver();break;
			
		default : System.out.println("Invalid browser..."); return;
		}

		FileInputStream propFile = new FileInputStream(".\\src\\test\\resources\\cofig.properties");
		Properties po = new Properties();
		po.load(propFile);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(po.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

	public String randomNum() {

		String randNum = RandomStringUtils.randomNumeric(4);

		return randNum;
	}

	public String randomAlpha() {

		String randApha = RandomStringUtils.randomAlphabetic(3);

		return randApha;
	}

}
