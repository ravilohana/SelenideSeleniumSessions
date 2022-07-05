package org.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpencartTest {
	
	WebDriver driver =null;;
	@Parameters("Browser")
	@Test
	public void openCartApp(String browserName) {
		
		if(browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.opencart.com/index.php?route=common/home&language=en-gb");
		String homeTitle = driver.getTitle();
		String expectedTitle = "Your Store";
		
		Assert.assertEquals(homeTitle, expectedTitle);
		
		driver.quit();
		
		
		
		
	}

}
