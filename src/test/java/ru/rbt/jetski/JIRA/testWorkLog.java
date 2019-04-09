package ru.rbt.jetski.JIRA;

import com.atlassian.jira.rest.client.domain.BasicUser;
import com.atlassian.jira.rest.client.domain.Worklog;
import org.junit.Test;
import ru.rbt.jetski.DateUtils;
import ru.rbt.jetski.jira.dao.IssueJiraDao;
import ru.rbt.jetski.jira.dao.WorklogJiraDao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

public class testWorkLog {

    public static void main(String[] args) {
        String jiraIssueKey = "FRSE-253";
        WorklogJiraDao worklogJiraDao = new WorklogJiraDao();
        Iterator<Worklog> newWorkLog = worklogJiraDao.worklogList(jiraIssueKey).iterator();

        Worklog w = null;
        while (newWorkLog.hasNext()) {
            w = newWorkLog.next();
            System.out.println("Дата: " + w.getStartDate() + " Время: " + w.getMinutesSpent()/60);
        }

    }

    @Test
    public void setWorklogQuery() {
        WorklogJiraDao wl = new WorklogJiraDao();

        List<Worklog> list = wl.worklogList("FRSE-231");

        for (Worklog row :
                list) {
            System.out.println(row);
        }
    }

    @Test
    public void getWeekTs() {
        WorklogJiraDao wl = new WorklogJiraDao();

        List<Worklog> list = wl.worklogList("FRSE-231");

        Map<BasicUser, Integer> planHours = new HashMap<>();
        LocalDate startDate = LocalDate.now(); // first period initiallization
        TemporalField fieldISO = WeekFields.of(Locale.getDefault()).dayOfWeek();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate thisMonday = startDate.with(fieldISO, 1);
        LocalDate endDate = LocalDate.now();

        if (startDate.equals(thisMonday)) {
            startDate = startDate.minusWeeks(1).with(DayOfWeek.MONDAY);
            endDate = endDate.minusWeeks(1).with(DayOfWeek.SUNDAY);
        } else {
            startDate = thisMonday;
            endDate = endDate.with(fieldISO, 7);
        }

        for (Worklog row :
                list) {
            LocalDate date = LocalDate.parse(row.getStartDate().toLocalDate().toString(), formatter);
            if (date.isAfter(startDate.minusDays(1)) && date.isBefore(endDate.plusDays(1)))
                if (!planHours.containsKey(row.getAuthor()))
                    planHours.put(row.getAuthor(), row.getMinutesSpent()/60);
                else
                    planHours.put(row.getAuthor(), planHours.get(row.getAuthor()) + row.getMinutesSpent()/60);
        }

        System.out.println(planHours);

    }
}
