package ru.rbt.jetski;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by BritikovMI on 08.04.2019.
 */
@RestController
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ru.rbt.jetski.ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @RequestMapping("/")
//    @Scheduled(cron = "0 0 21 * * ?")// Каждый день в 21:00
    @Scheduled(cron = "*/60 * * * * *") //Каждую минуту
    //second, minute, hour, day of month, month, day(s) of week
    //* "0 0 * * * *" = the top of every hour of every day.
    //* "*/10 * * * * *" = every ten seconds.
    //* "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
    //* "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
    //* "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
    //* "0 0 0 25 12 ?" = every Christmas Day at midnight
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));

        System.out.println("Test");
    }
}
