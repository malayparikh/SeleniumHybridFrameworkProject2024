package com.seleniumproject.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {

	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();

		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys("john.peter1@gmail.com");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");

		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}
	
	@Test
	public void VerifyLoginWithInvalidCredentials() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("john.peter1234@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234556789");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		
		String actualMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert')]")).getText();
		String expectedMessage = "Warning: No match for E-Mail Address and/or Password";
		
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		
		//System.out.println(actualMessage);
		
		Thread.sleep(3000);
		driver.quit();
		
						
	}

}
