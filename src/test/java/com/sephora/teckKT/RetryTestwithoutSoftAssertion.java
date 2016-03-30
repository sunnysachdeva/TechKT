/**
 * 
 */
package com.sephora.teckKT;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RetryTestwithoutSoftAssertion extends BaseTest {
	
	@BeforeMethod
	public void bm(Method m, ITestResult result){
	}
	
	@Test
	public void testA(){
		try {
			WebElement search=driver.findElement(By.id("site-search-field11"));
			Assert.assertFalse(search.isDisplayed(), "Verify if Search text box is present");
		}catch(Exception e){
			Assert.assertTrue(false, "Some unexpected exception ocurred :: "+ e.getMessage());
		}
			
	}

	
	
}
