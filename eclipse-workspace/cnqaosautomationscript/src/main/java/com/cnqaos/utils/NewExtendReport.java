package com.cnqaos.utils;


import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewExtendReport 
{
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static ExtentTest logger1;
    public static ExtentTest logger2;
    public static ExtentTest logger3;
    public static ExtentTest logger4;
    public static ExtentTest logger5;
   


    public static void newReport(String reportname,String hmlflenme) throws IOException
    {
    	
    	
    	 String currentDir = System.getProperty("user.dir");
        htmlReporter = new ExtentHtmlReporter(currentDir + "/extentreports/" + hmlflenme + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "CNQAOS.com");
        extent.setSystemInfo("Environment", "Automation Testing");
        extent.setSystemInfo("Test By", "Nitin Tajane");

        htmlReporter.config().setDocumentTitle("Tamplo automation script");
        htmlReporter.config().setReportName(reportname);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);



    }
    

}
