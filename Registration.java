package com.seleniumproject.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumproject.qa.tests.Utilities;

public class Registration {
	
	WebDriver driver;
	
	@AfterMethod
	public void teadDown() {

		System.out.println("After Method- Close Browser");

		driver.quit();

	}

	@BeforeMethod
	public void setUp() {

		String browserName = "edge";

		if (browserName.equals("chrome")) {

			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {

			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();

		driver.findElement(By.linkText("Register")).click();

	}

	@Test
	public void VerifyUserRegistrationWithAlreadyRegisteredUser() throws InterruptedException {

	
		driver.findElement(By.id("input-firstname")).sendKeys("demouser1234");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("demolname");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys("8979879879");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(4000);

	
	}
	


}
