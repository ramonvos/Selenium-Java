package com.ramonvos.utilities;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.internal.TestResult;
import org.testng.internal.annotations.ITest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

public class Utils {



    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public static String getCurrentMethodName(){

        return  null;

        //Thread.currentThread().getStackTrace()[1].getMethodName()

    }

    public static String replaceEmptyValue(String value){
        value = value.trim();
        if ( value == ""  || value == null ){
            value = "[vazio]";
            return value;
        }else return value;
    }
    public static boolean hasValue(String value){
        value = value.trim();
        if ( value == ""  || value == null ){

            return false;
        }else return true;
    }


    public static String getAttributeElement(WebElement element) {

        String elementAttibute = "";
        try {
            if (hasValue(element.getAttribute("id"))) {
                elementAttibute = element.getAttribute("id");
            }

        }catch(NoSuchElementException nexc) {
            if(hasValue(element.getAttribute("name"))){
                elementAttibute = element.getAttribute("name");
            }
        }
        finally {
            if ( hasValue(elementAttibute) ){
                return elementAttibute;
            }else return "Elemento sem identificador";
        }





    }
}
