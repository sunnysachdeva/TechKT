package com.sephora.teckKT;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





public class SoftAssert extends org.testng.asserts.SoftAssert
{
	private final Map<AssertionError, IAssert>	m_errors	= Maps.newHashMap();
	private  WebDriver					driver;
	// private static UISoftAssert objSoftAssert;
	private ExtentTest test;
	public SoftAssert(WebDriver driver) {
		this.driver = driver;
	}

	public SoftAssert(WebDriver driver, ExtentTest test ) {
		this.driver = driver;
		this.test=test;
	}


	protected void doAssert(IAssert assertCommand) {
		onBeforeAssert(assertCommand);
		try {
			executeAssert(assertCommand);
			onAssertSuccess(assertCommand);
		} catch(AssertionError ex) {
			m_errors.put(ex, assertCommand);
			onAssertFailure(assertCommand, ex);
			//  throw ex;
		} finally {
			onAfterAssert(assertCommand);
		}
	}

	@Override
	public void executeAssert(IAssert a)
	{
		try {
			a.doAssert();
		} catch (AssertionError ex) {
			m_errors.put(ex, a);
			//onAssertFailure(a, ex);
			throw ex;
		}
	}

	@Override
	public void assertAll()
	{
		if (!m_errors.isEmpty()) {
			StringBuilder sb = new StringBuilder("The following asserts failed:\n");
			boolean first = true;
			for (Map.Entry<AssertionError, IAssert> ae : m_errors.entrySet()) {
				if (first) {
					first = false;
				} else {
					sb.append(", ");
				}
				sb.append(ae.getValue().getMessage());
			}
			throw new AssertionError(sb.toString());
		}
	}

	@Override
	public void onAfterAssert(IAssert a)
	{
		//super.onAfterAssert(a);
	}

	@Override
	public void onBeforeAssert(IAssert a)
	{
		//		Reporter.log("");
		//		Reporter.log("ASSERT DESCRIPTION: " + a.getMessage());

	}

	@Override
	public void onAssertFailure(IAssert a, AssertionError ex)
	{
		try {
			//String sScreenshotPath= driver.getScreenshot();
			test.log(LogStatus.FAIL, "<pre><b><font color='red'>" +"FUNCTIONAL FAILURE ::"+ex.getMessage()+"."+ "</font></b></pre>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onAssertSuccess(IAssert a){
		try{
			test.log(LogStatus.PASS,"<b><font color='green'>"+a.getMessage()+"</font></b>");
		}catch(Exception e){

		}
	}

	public void onAutomationFailure(Exception e) {
		test.log(LogStatus.FATAL, "<pre><b><font color='red'>" +"FUNCTIONAL FAILURE ::"+e.getMessage()+"."+ "</font></b></pre>");
		throw new WebDriverException(e.getMessage());
	}


}
