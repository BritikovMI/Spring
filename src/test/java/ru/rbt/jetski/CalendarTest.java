package ru.rbt.jetski;

import java.util.Calendar;
import java.util.Map;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int ruSaturday = Calendar.SATURDAY, ruSunday = Calendar.SUNDAY;
        int workDays = 0;
        System.out.print("Начало месяца: " + cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println(" Конец месяца: " + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.print("Начало недели: " + cal.getActualMinimum(Calendar.DAY_OF_WEEK));
        System.out.println(" Конец недели: " + cal.getActualMaximum(Calendar.DAY_OF_WEEK));
        System.out.print("Суббота: " + ruSaturday);
        System.out.println(" Воскресенье: " + ruSunday);

        //Цикл по всем дням месяца, подсчет рабочих дней
        for (int i = cal.getActualMinimum(Calendar.DAY_OF_MONTH); i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            cal.set(Calendar.DAY_OF_MONTH, i);
            if (cal.get(Calendar.DAY_OF_WEEK) != (ruSaturday) && cal.get(Calendar.DAY_OF_WEEK) != (ruSunday)) {
                ++workDays;
            }
            System.out.println("Сегодня - " + cal.get(Calendar.DAY_OF_MONTH) + " число месяца");
        }
        System.out.println("В этом месяце - " + workDays + " рабочих дней");

    }


}
