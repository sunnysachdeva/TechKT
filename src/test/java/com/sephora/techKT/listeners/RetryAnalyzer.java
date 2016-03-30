/**
 * 
 */
package com.sephora.techKT.listeners;

import org.openqa.selenium.WebDriverException;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * @author Gspann
 *
 */


public class RetryAnalyzer implements IRetryAnalyzer{
	private int count = 0;
	private int maxCount = 1;
	
	public boolean retry(ITestResult result) {
		{
			if ( !result.isSuccess()  ) {
				//Reporter.log(">>>>><<<<<<"+result.getThrowable(),true);
				if(result.getThrowable() instanceof WebDriverException){
					Reporter.log("***********"+"Test case is an automation Failure",true);
				}
				if(result.getThrowable() instanceof AssertionError){
					Reporter.log("***********"+"Test case is an Functional Failure",true);
				}
			//	if(null!=result.getAttribute("IsRerun")){
					//if(result.getAttribute("IsRerun").equals("true")){
						System.out.println("Test case name :: "+result.getName());
						//System.out.println("Test Case context :: "+result.getAttribute("IsRerun"));
						if ( count < maxCount ) {
							count++;
							result.setStatus( ITestResult.SUCCESS_PERCENTAGE_FAILURE );
							String message = Thread.currentThread().getName() + "Error in '" + result.getName() + "' with status '" + result.getStatus() + 
									"'. Retrying '" + count + "' times.";
							Reporter.log( message, true );
							return true;
						}	
					//}
					
				//}
				
			}
			return false;
		}
	}
	
}
