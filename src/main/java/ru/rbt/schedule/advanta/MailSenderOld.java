package ru.rbt.schedule.advanta;

/**
 * Created by BritikovMI on 10.04.2019.
 */
public class MailSenderOld {

    public static void sendMail() {

        String delimitedMails = "supercep110@gmail.com,";
        String mailContent =
                (String.format("                    <tr>" +
                        "                            <td rowspan=\"1\">%S</td><td rowspan=\"1\">%S</td><td rowspan=\"1\">%S</td>\n\n" +
                        "                        </tr>\n", "Иванов И. И.", "60", "50"
                ));

        Mail.mailSender(delimitedMails,
                "Сентябрь", mailContent);
    }
}
