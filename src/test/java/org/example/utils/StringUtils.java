package org.example.utils;


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

    public static String getFirstPart(String item){
        String[] elements = item.split(" ");
        return elements[0].toUpperCase();

    }

    public static String replaceSpaceToUnderscore(String item){
        return item.replace(" ","_").toUpperCase();
    }

    public static String getFirstNumber(String item){
        String[] elements = item.split("x");
        return elements[0];
    }

    public static String getInsideParentheses(String item){
        String[] elments = item.split(" ");
        return elments[1].replace("(","").replace(")","");

    }
}
