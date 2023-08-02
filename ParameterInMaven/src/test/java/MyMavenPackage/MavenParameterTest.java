package MyMavenPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.log4testng.Logger;

public class MavenParameterTest {
	WebDriver _driver;

	@Test
	public void InputDatainSearchTextBox() throws IOException {
		Properties prop = new Properties();
		prop.load(MavenParameterTest.class.getClassLoader().getResourceAsStream("ContentSearch.properties"));

		String ValueToBeSearched = prop.getProperty("sContent");
		_driver.findElement(By.name("q")).sendKeys(ValueToBeSearched);
	}

	@BeforeTest
	public void beforeTest() {
		_driver = new ChromeDriver();
		_driver.get("https://www.google.com");
	}

	@AfterTest
	public void afterTest() {
		_driver.close();

	}

}
