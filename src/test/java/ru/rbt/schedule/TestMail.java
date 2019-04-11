package ru.rbt.schedule;

import org.junit.Test;
import ru.rbt.schedule.advanta.Mail;

public class TestMail {

    @Test
    public void senderTest() {

        String delimitedMails = "supercep110@gmail.com,";
        String mailContent =
                (String.format("                    <tr>" +
                        "                            <td rowspan=\"1\">%S</td><td rowspan=\"1\">%S</td><td rowspan=\"1\">%S</td>\n\n" +
                        "                        </tr>\n", "Иванов И. И.", "60", "50"));
        Mail.mailSender(delimitedMails,
                "Сентябрь", mailContent);
    }
}
