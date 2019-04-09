package ru.rbt.jetski;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    /**
     * Convert {@link LocalDate} to {@link org.joda.time.DateTime}
     */
    public DateTime toDateTime(LocalDate localDate) {
        return new DateTime(DateTimeZone.UTC).withDate(
                localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()
        ).withTime(0, 0, 0, 0);
    }


    /**
     * Convert {@link org.joda.time.DateTime} to {@link LocalDate}
     */
    public LocalDate toLocalDate(DateTime dateTime) {
        DateTime dateTimeUtc = dateTime.withZone(DateTimeZone.UTC);
        return LocalDate.of(dateTimeUtc.getYear(), dateTimeUtc.getMonthOfYear(), dateTimeUtc.getDayOfMonth());
    }

    /**
     * Convert {@link LocalDate} to {@link XMLGregorianCalendar}
     */
    public XMLGregorianCalendar localDateToXMLGregorianCalendar(LocalDate date) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        return xmlCalendar;
    }
}
