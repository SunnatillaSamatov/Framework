package org.example.utils;

import org.openqa.selenium.WebElement;

public class StringUtils {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static Double getMonthlyCost(String item){
        String stringItem = item.replace(",","");
        String[] elements = stringItem.split(" ");
        double monthlyCost=0.0;
        for (String element:elements) {

            if(isNumeric(element)){
                monthlyCost= Double.parseDouble(element);
                break;
            }
        }
        return monthlyCost;
    }

}
