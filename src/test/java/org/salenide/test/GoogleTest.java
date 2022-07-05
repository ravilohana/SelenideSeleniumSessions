package org.salenide.test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;

import io.github.bonigarcia.wdm.WebDriverManager;


public class GoogleTest {
	
	//WebDriver driver =null;
	@Parameters("Browser")
	@Test
	public void googleSearch(String browserName) {
		if(browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			open("https://www.google.com");
		}else if(browserName.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			open("https://www.google.com");
			
		}
		
		$(By.name("q")).setValue("Naveen AutomationLabs");
		$(By.name("btnK")).click();
		$(By.id("logo")).shouldHave(Condition.appear);
		String header = $(By.xpath("//h3[text()='Welcome to Naveen AutomationLabs - naveen automationlabs']")).getText();
		System.out.println(header);
		Assert.assertEquals(header, "Welcome to Naveen AutomationLabs - naveen automationlabs");
		int headerCount = $$(By.cssSelector(".LC20lb.DKV0Md")).size();
		System.out.println(headerCount);
		$$(By.cssSelector(".LC20lb.DKV0Md")).shouldHave(CollectionCondition.size(9));
		closeWebDriver();
	}
	

}
