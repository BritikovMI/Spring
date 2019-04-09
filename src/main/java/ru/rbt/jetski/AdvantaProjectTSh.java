package ru.rbt.jetski;

import ru.rbt.jetski.advanta.XMLParse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AdvantaProjectTSh{
    static final String directoryID = "977ff0ae-56f8-40ad-8919-8175788e38c8";
    Map<String, Double> planHours = new HashMap<>();
    String finalSurnameFormat;
    Calendar cal = Calendar.getInstance();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
    Date anyFutureDate;

    

    

    public static void main(String[] args) {
//        System.out.println(getWorkingHoursBetweenTwoDates(new Date(), 1.0));
//        System.out.println(coutingExceptions());
    }

    

    public Map<String, Integer> coutingExceptions() { // Получаем календарь выходных дней и раскладываем его по мапу
        XMLParse xmp = new XMLParse();
        String exceptions = xmp.xmlParser();

        Map<String, Integer> exceptionsMap = new HashMap<>();
        String[] pairs = exceptions.split(";");
        for (int i = 0; i < pairs.length; i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(",");
            exceptionsMap.put(keyValue[0], Integer.valueOf(keyValue[1]));
        }

        return exceptionsMap;
    }

    public boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    
}
