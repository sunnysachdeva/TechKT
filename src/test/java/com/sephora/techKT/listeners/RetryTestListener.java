/**
 * 
 */
package com.sephora.techKT.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author Gspann
 *
 */
public class RetryTestListener implements IAnnotationTransformer  {

	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		if (retry == null)	{
			annotation.setRetryAnalyzer(RetryAnalyzer.class);
		}
	}
	
}
