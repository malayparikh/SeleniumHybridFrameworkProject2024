package com.seleniumproject.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

		driver.quit();
	}

}
