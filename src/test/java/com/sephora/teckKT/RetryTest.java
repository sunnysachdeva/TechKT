/**
 * 
 */
package com.sephora.teckKT;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class RetryTest extends BaseTest {
	private SoftAssert s_Assert;
	//private String IsRerun;
	protected ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeClass
	public void bc(){
		extent=ExtentManager.getInstance();
	}
	
	@BeforeMethod
	public void bm(Method m, ITestResult result){
		test =extent.startTest(m.getName());
		s_Assert=new SoftAssert(driver,test);
	}
	
	@Test
	public void testA(){
		try {
			WebElement search=driver.findElement(By.id("site-search-field"));
			s_Assert.assertFalse(search.isDisplayed(), "Verify if Search text box is present");
		} catch (WebDriverException e) {
			s_Assert.onAutomationFailure(e);
		} catch(Exception ex){
			s_Assert.assertTrue(false,"Failed because of some exception ");
		}finally{
			s_Assert.assertAll();
		}
		
	}

	@AfterMethod
	public void am(){
		extent.endTest(test);
	}
	
	
}
