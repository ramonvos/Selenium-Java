package com.ramonvos.utilities;
import org.openqa.selenium.WebElement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.UUID;

public class Utils {
    // Metodo para retornar a data hora atual
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
    //Metodo para substituir quando for passado um valor vazio ou null no relatorio
    public static String replaceEmptyValue(String value){
        value = value.trim();
        if ( value == ""  || value == null ){
            value = "[vazio]";
            return value;
        }else return value;
    }
    //Metodo para testar se a String tem valor
    public static boolean hasValue(String value){
        value = value.trim();
        if ( value == ""  || value == null ){

            return false;
        }else return true;
    }
    // Metodo para retornar o atributo Id ou Name do Elemento
    public static String getAttributeElement(WebElement element) {

        String elementAttibute = "";
        try {
            if (hasValue(element.getAttribute("id"))) {
                elementAttibute = element.getAttribute("id");
            }

        }catch(NullPointerException e) {
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
    // Método para retornar o path do projeto (Raiz)
    public static String getCurrentProjectPath(){

        return System.getProperty("user.dir");
    }

    public static String randomUUID(int len){
        String random = UUID.randomUUID().toString();
        if (len < 36){
        return random.substring(len);}
        else return  random;
    }

}
