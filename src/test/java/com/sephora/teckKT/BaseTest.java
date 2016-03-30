/**
 * 
 */
package com.sephora.teckKT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTest {

	WebDriver driver=null;

	@BeforeSuite
	public void beforeSuite(){
		driver = new FirefoxDriver();
		driver.get("http://www.sephora.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//waitForPageLoad();
	}




	@AfterSuite
	public void afterSuite(){
		System.out.println(null==driver);
		driver.close();
	}


	private boolean waitForPageLoad() {
		boolean isLoaded = false;
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30,500);
		wait.until(pageLoadCondition);
		isLoaded = true;
		return isLoaded;
	}
}
