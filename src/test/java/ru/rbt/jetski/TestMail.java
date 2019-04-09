package ru.rbt.jetski;

import ru.rbt.jetski.advanta.Mail;

public class TestMail {
    public static void main(String[] args) {
        Mail mail = new Mail();
        String mailContent = (String.format("                    <tr>" +
                "                            <td rowspan=\"1\">%S</td><td rowspan=\"1\">%S</td><td rowspan=\"1\">%S</td>\n\n" +
                "                        </tr>\n", "Иванов И. И.", "60", "50"));
        mail.mailSender("supercep110@gmail.com,britikovmi@rbtechnologies.ru", "Сентябрь", mailContent);
    }
}
