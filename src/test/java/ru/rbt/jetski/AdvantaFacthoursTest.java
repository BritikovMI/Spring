package ru.rbt.jetski;

import ru.rbt.jetski.advanta.FieldWsDao;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AdvantaFacthoursTest {
    static final String directoryID = "977ff0ae-56f8-40ad-8919-8175788e38c8";
    static final String projectId = "4faae6d5-0ce3-4962-ac5c-828922334c19";

    public static String subCalc() {
        Calendar cal = Calendar.getInstance();
        Map<String, Double> employeeProps = new HashMap<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss'Z'");
        DateFormat month = new SimpleDateFormat("MM");
        Double curMonth = null, curYear = null, tshMonth = null, tshYear = null;
        DateFormat year = new SimpleDateFormat("yyyy");
        Date date = new Date();
        try {
            date = df.parse(cal.get(Calendar.YEAR) + "-" + ((cal.get(Calendar.MONTH) + 1 < 10) ? "0" + (cal.get(Calendar.MONTH) + 1) : cal.get(Calendar.MONTH) + 1) + "-01 00:00:00Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        FieldWsDao fieldDao = new FieldWsDao();
        //TODO unwrap this later
       /* StringBuilder sb = fieldDao.get(projectId, directoryID);
        String[] arrayOfFields = sb.toString().replace(";#:#X", "").split(";#:#");
        System.out.println("\n\n\n" + date + "\n\n\n");
        System.out.println(sb.toString());

        for (String a : arrayOfFields) {
            try {
                if(a.contains("Вид деятельности")) {
                    tshMonth = Double.parseDouble(month.format(df.parse(a.split(";")[3])));
                    curMonth = Double.parseDouble(month.format(date));
                    tshYear = Double.parseDouble(year.format(df.parse(a.split(";")[3])));
                    curYear = Double.parseDouble(year.format(date));
                } else{
                    tshMonth = Double.parseDouble(month.format(df.parse(a.split(";")[1])));
                    curMonth = Double.parseDouble(month.format(date));
                    tshYear = Double.parseDouble(year.format(df.parse(a.split(";")[1])));
                    curYear = Double.parseDouble(year.format(date));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (!a.equalsIgnoreCase("X"))
                try {
                    if(a.contains("Вид деятельности")) {
                        System.out.println("Field: " + month.format(df.parse(a.split(";:;")[3])) + " = " + month.format(date) + " yy " + year.format(df.parse(a.split(";:;")[3])) + " = " + year.format(date));
                    }else {
                        System.out.println("Field: " + month.format(df.parse(a.split(";:;")[1])) + " = " + month.format(date) + " yy " + year.format(df.parse(a.split(";:;")[1])) + " = " + year.format(date));
                    }
                    if(a.contains("Вид деятельности")) {//TODO: это изменить с учетом сдвига на Вид деятельности
                        if (tshMonth == curMonth && tshYear == curYear) {
                            if (a.contains("описание") && a.contains("Сверхурочные")) {
                                //TODO: Учесть сверхурочные
                                if (a.split(";:;")[5] != null && a.split(";:;")[11] != null) {
                                    if (employeeProps.containsKey(a.split(";:;")[5])) {
                                        employeeProps.put(a.split(";:;")[5], employeeProps.get(a.split(";:;")[5]) + Double.valueOf(a.split(";:;")[11]));
                                        System.out.println("С описанием и сверхурочными, обновляем: " + a.split(";:;")[5] + " : " + Double.valueOf(a.split(";:;")[11]));
                                    } else {
                                        employeeProps.put(a.split(";:;")[5], Double.valueOf(a.split(";:;")[11]));
                                        System.out.println("С описанием и сверхурочными: " + a.split(";:;")[5] + " : " + Double.valueOf(a.split(";:;")[11]));
                                    }
                                }
                            } else if (!a.contains("описание") && a.contains("Сверхурочные")) {
                                if (a.split(";:;")[3] != null && a.split(";:;")[9] != null) {
                                    if (employeeProps.containsKey(a.split(";:;")[3])) {
                                        employeeProps.put(a.split(";:;")[3], employeeProps.get(a.split(";:;")[3]) + Double.valueOf(a.split(";:;")[9]));
                                        employeeProps.put(a.split(";:;")[3], employeeProps.get(a.split(";:;")[3]) + Double.valueOf(a.split(";:;")[5]));// Добавляем сверхурочных
                                        System.out.println("Без описания и со сверхурочными, обновляем: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[9]));
                                    } else {
                                        employeeProps.put(a.split(";:;")[3], Double.valueOf(a.split(";:;")[9]));
                                        if (employeeProps.get(a.split(";:;")[3]) == 0)
                                            employeeProps.put(a.split(";:;")[3], Double.valueOf(a.split(";:;")[5])); // добавляем сверхурочных
                                        else
                                            employeeProps.put(a.split(";:;")[3], employeeProps.get(a.split(";:;")[3]) + Double.valueOf(a.split(";:;")[5]));// Добавляем сверхурочных
                                        System.out.println("Без описания и со сверхурочными: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[9]));
                                    }
                                }
                            } else if (a.contains("описание") && !a.contains("Сверхурочные")) {
                                if (a.split(";:;")[3] != null && a.split(";:;")[9] != null) {
                                    if (employeeProps.containsKey(a.split(";:;")[3])) {
                                        employeeProps.put(a.split(";:;")[3], employeeProps.get(a.split(";:;")[3]) + Double.valueOf(a.split(";:;")[9]));
                                        System.out.println("С описанием и без сверхурочных, обновляем: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[9]));
                                    } else {
                                        employeeProps.put(a.split(";:;")[3], Double.valueOf(a.split(";:;")[9]));
                                        System.out.println("С описанием и без сверхурочных: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[9]));
                                    }
                                }
                            } else {
                                if (a.split(";:;")[3] != null && a.split(";:;")[7] != null) {
                                    if (employeeProps.containsKey(a.split(";:;")[3])) {
                                        employeeProps.put(a.split(";:;")[3], employeeProps.get(a.split(";:;")[3]) + Double.valueOf(a.split(";:;")[7]));
                                        System.out.println("С описанием и без сверхурочных, обновляем: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[7]));
                                    } else {
                                        employeeProps.put(a.split(";:;")[3], Double.valueOf(a.split(";:;")[7]));
                                        System.out.println("С описанием и без сверхурочных: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[7]));
                                    }
                                }
                            }
                        }
                    } else{
                        if (tshMonth == curMonth && tshYear == curYear) {
                            if (a.contains("описание") && a.contains("Сверхурочные")) {
                                //TODO: Учесть сверхурочные
                                if (a.split(";:;")[5] != null && a.split(";:;")[11] != null) {
                                    if (employeeProps.containsKey(a.split(";:;")[5])) {
                                        employeeProps.put(a.split(";:;")[5], employeeProps.get(a.split(";:;")[5]) + Double.valueOf(a.split(";:;")[11]));
                                        System.out.println("С описанием и сверхурочными, обновляем: " + a.split(";:;")[5] + " : " + Double.valueOf(a.split(";:;")[11]));
                                    } else {
                                        employeeProps.put(a.split(";:;")[5], Double.valueOf(a.split(";:;")[11]));
                                        System.out.println("С описанием и сверхурочными: " + a.split(";:;")[5] + " : " + Double.valueOf(a.split(";:;")[11]));
                                    }
                                }
                            } else if (!a.contains("описание") && a.contains("Сверхурочные")) {
                                if (a.split(";:;")[3] != null && a.split(";:;")[9] != null) {
                                    if (employeeProps.containsKey(a.split(";:;")[3])) {
                                        employeeProps.put(a.split(";:;")[3], employeeProps.get(a.split(";:;")[3]) + Double.valueOf(a.split(";:;")[9]));
                                        employeeProps.put(a.split(";:;")[3], employeeProps.get(a.split(";:;")[3]) + Double.valueOf(a.split(";:;")[5]));// Добавляем сверхурочных
                                        System.out.println("Без описания и со сверхурочными, обновляем: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[9]));
                                    } else {
                                        employeeProps.put(a.split(";:;")[3], Double.valueOf(a.split(";:;")[9]));
                                        if (employeeProps.get(a.split(";:;")[3]) == 0)
                                            employeeProps.put(a.split(";:;")[3], Double.valueOf(a.split(";:;")[5])); // добавляем сверхурочных
                                        else
                                            employeeProps.put(a.split(";:;")[3], employeeProps.get(a.split(";:;")[3]) + Double.valueOf(a.split(";:;")[5]));// Добавляем сверхурочных
                                        System.out.println("Без описания и со сверхурочными: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[9]));
                                    }
                                }
                            } else if (a.contains("описание") && !a.contains("Сверхурочные")) {
                                if (a.split(";:;")[3] != null && a.split(";:;")[9] != null) {
                                    if (employeeProps.containsKey(a.split(";:;")[3])) {
                                        employeeProps.put(a.split(";:;")[3], employeeProps.get(a.split(";:;")[3]) + Double.valueOf(a.split(";:;")[9]));
                                        System.out.println("С описанием и без сверхурочных, обновляем: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[9]));
                                    } else {
                                        employeeProps.put(a.split(";:;")[3], Double.valueOf(a.split(";:;")[9]));
                                        System.out.println("С описанием и без сверхурочных: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[9]));
                                    }
                                }
                            } else {
                                if (a.split(";:;")[3] != null && a.split(";:;")[7] != null) {
                                    if (employeeProps.containsKey(a.split(";:;")[3])) {
                                        employeeProps.put(a.split(";:;")[3], employeeProps.get(a.split(";:;")[3]) + Double.valueOf(a.split(";:;")[7]));
                                        System.out.println("С описанием и без сверхурочных, обновляем: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[7]));
                                    } else {
                                        employeeProps.put(a.split(";:;")[3], Double.valueOf(a.split(";:;")[7]));
                                        System.out.println("С описанием и без сверхурочных: " + a.split(";:;")[3] + " : " + Double.valueOf(a.split(";:;")[7]));
                                    }
                                }
                            }
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
        }
        System.out.println(Arrays.toString(employeeProps.entrySet().toArray()));*/

        return null;
    }

    public static void main(String[] args) {
        subCalc();
    }
}
