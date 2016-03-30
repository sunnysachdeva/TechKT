/**
 * 
 */
package com.sephora.teckKT;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	
	private static ExtentReports extent;
	public static ExtentReports getInstance() {
        if (extent == null) {
           // extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\OLR_AutomationReport.html",true);
            extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\AutomationReport.html",true);
        }
        return extent;
    }

}
