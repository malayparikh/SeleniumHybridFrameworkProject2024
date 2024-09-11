package com.seleniumproject.tests;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.jdi.Method;

public class Login {

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

		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		System.out.println("Before Method- Open URL and navigate");

	}

	WebDriver driver;

	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() throws InterruptedException {

		driver.findElement(By.id("input-email")).sendKeys("john.peter1@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		System.out.println("Test Method-1");

	}

	@Test(priority = 2)
	public void VerifyLoginWithValidEmailInvalidPassword() throws InterruptedException {

		driver.findElement(By.id("input-email")).sendKeys("john.peter1" + generateTimestamp() + "@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234556789");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String actualMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert')]")).getText();
		String expectedMessage = "Warning: No match for E-Mail Address and/or Password";
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		System.out.println("Test Method-2");

	}

	@Test(priority = 3)
	public void VerifyLoginWithInValidEmaiValidPassword() throws InterruptedException {

		driver.findElement(By.id("input-email")).sendKeys("john.peter112" + generateTimestamp() + "@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234556789");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String actualMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert')]")).getText();
		String expectedMessage = "Warning: No match for E-Mail Address and/or Password";
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		System.out.println("Test Method-3");

	}

	@Test(priority = 4)
	public void VerifyLoginWithInValidEmaiInValidPassword() throws InterruptedException {

		driver.findElement(By.id("input-email")).sendKeys("john.peter145" + generateTimestamp() + "@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234556789");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String actualMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert')]")).getText();
		String expectedMessage = "Warning: No match for E-Mail Address and/or Password";
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		System.out.println("Test Method-4");

	}

	@Test(priority = 5)
	public void VerifyLoginWithBlankEmailAndPassword() throws InterruptedException {

		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String actualMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert')]")).getText();
		String expectedMessage = "Warning: No match for E-Mail Address and/or Password";
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		System.out.println("Test Method-5");

	}

	public String generateTimestamp() {

		Date date = new Date();

		return date.toString().replace(" ", "_").replace(":", "_");

	}

	// ValidEmail and Invalid Password
	// Both invalid credentials

}
