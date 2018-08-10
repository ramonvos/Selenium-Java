package com.ramonvos.logger;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ramonvos.utilities.Utils;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.IOException;
import java.lang.reflect.Method;

public class Reporter {

    public static ExtentReports extent;
    public static ExtentTest test;




    //Create an extent report instance
    public static void createNewReport() {

        //if (extent == null) {

            String fileName = "C:\\Selenium\\Screenshots\\Reporter-test " + Utils.getCurrentTimeStamp() + ".html";
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
           // htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
            //htmlReporter.config().setChartVisibilityOnOpen(true);
            //htmlReporter.config().setTheme(Theme.DARK);
            //htmlReporter.config().setDocumentTitle(fileName);
            //htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName(fileName);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
       // }

    }

    public static void  createTest(String testName){

        test = extent.createTest(testName).pass("details");

    }

    public static void addStepsToPass(String text){

        test.log(Status.PASS,text);
    }
    public static void addStepsToFail(String text){

        test.log(Status.FAIL,text);
    }

    public static void addScreeshot(String screenshotPath){


        try {
            MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build();
            test.pass("details", mediaModel);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //
        //
    }


    public static void  generateReporter(){

        extent.flush();
    }




}
