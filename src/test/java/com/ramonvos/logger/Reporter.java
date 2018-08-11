package com.ramonvos.logger;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ramonvos.constants.Constants;
import com.ramonvos.utilities.Utils;
import com.ramonvos.webdriver.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class Reporter extends TestBase{

    public static ExtentReports extent;
    public static ExtentTest test;


    public  static String fileName;

    //Create an extent report instance
    public static void createNewReport() {

       if (extent == null) {

            fileName = "C:\\Selenium\\Screenshots\\Reporter-test " + Utils.getCurrentTimeStamp() + ".html";
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
            htmlReporter.config().setReportName(fileName);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
       }

    }

    public static void  createTest(String testName, String suiteName){

        test = extent.createTest(testName).assignCategory(suiteName);

    }

    public static void addStepsToPass(String text){

        Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);

        test.pass(m);

    }
    public static void addStepsToPassMarkup(String text){

        Markup markup = MarkupHelper.createLabel(text, ExtentColor.GREEN);

        test.pass(markup);

    }
    public static void addStepsToFail(String text){

        test.fail(text);
        Assert.assertTrue(false);
    }
    public static void addStepsToFailMarkup(String text){

        Markup markup = MarkupHelper.createLabel(text, ExtentColor.RED);

        test.fail(markup);
        Assert.assertTrue(false);
    }
    public static void addStepsToException(Exception ex){

        test.log(Status.FAIL,ex);
    }


    public static void addScreeshot(String screenshotPath){


        try {
            MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build();
            test.info("URL final: "+ driver.getCurrentUrl(), mediaModel);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void  generateReporter(){

        extent.flush();


        //Comentar essa linha para o relatorio não abrir ao finalizar o teste!
        String file = fileName;
        File htmlFile = new File(fileName);
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
