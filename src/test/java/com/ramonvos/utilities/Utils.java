package com.ramonvos.utilities;
import org.testng.ITestContext;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {



    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public static String getCurrentMethodName(){


        return new Object(){}.getClass().getEnclosingMethod().getName();

        //Thread.currentThread().getStackTrace()[1].getMethodName()

    }
}
