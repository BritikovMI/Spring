package ru.rbt.schedule.advanta;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Mail {
    static final String username = "tastytest549@gmail.com";
    static final String password = "tastytest549tastytest549";
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    static Properties props = System.getProperties();

    {
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
//        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
    }


    public static String mailSender(String recepient, String month, String content) {
        // recepient email
        month = month.replace("ря", "рь").replace("ля", "ль").replace("та", "т").replace("ня", "нь");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session); // email message

            message.addRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(recepient));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));

            message.setSubject("тш " + month); // subject line

            // actual mail body
            message.setText(top + content + bottom, "utf-8", "html");

            // Send message
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

        return "Email Sent successfully....";
    }

    static String top = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\n" +
            "    <meta charset=\"utf-8\">\n" +
            "\n" +
            "    <title>Message</title>\n" +
            "\n" +
            "\n" +
            "    <style>\n" +
            "        /*$bp-maggie: 15em; $bp-lisa: 30em; $bp-bart: 48em; $bp-marge: 62em; $bp-homer: 75em;*/\n" +
            "        * {\n" +
            "            -webkit-box-sizing: border-box;\n" +
            "            -moz-box-sizing: border-box;\n" +
            "            box-sizing: border-box;\n" +
            "        }\n" +
            "\n" +
            "        *:before,\n" +
            "        *:after {\n" +
            "            -webkit-box-sizing: border-box;\n" +
            "            -moz-box-sizing: border-box;\n" +
            "            box-sizing: border-box;\n" +
            "        }\n" +
            "\n" +
            "        body {\n" +
            "            font-family: \"Helvetica Neue\", \"Helvetica\", \"Roboto\", \"Arial\", sans-serif;\n" +
            "            color: #5e5d52;\n" +
            "        }\n" +
            "\n" +
            "        a {\n" +
            "            color: #337aa8;\n" +
            "        }\n" +
            "\n" +
            "        a:hover,\n" +
            "        a:focus {\n" +
            "            color: #337aa8;\n" +
            "        }\n" +
            "\n" +
            "        .container {\n" +
            "            margin: 5% 3%;\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .container {\n" +
            "                margin: 2%;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 75em) {\n" +
            "            .container {\n" +
            "                margin: 2em auto;\n" +
            "                max-width: 75em;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table {\n" +
            "            border: 1px solid #1d96b2;\n" +
            "            width: 100%;\n" +
            "            margin-bottom: 1.5em;\n" +
            "            border-spacing: 0;\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table {\n" +
            "                font-size: .9em;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 62em) {\n" +
            "            .responsive-table {\n" +
            "                font-size: 1em;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table thead {\n" +
            "            position: absolute;\n" +
            "            clip: rect(1px 1px 1px 1px);\n" +
            "            /* IE6, IE7 */\n" +
            "            padding: 0;\n" +
            "            border: 0;\n" +
            "            height: 1px;\n" +
            "            width: 1px;\n" +
            "            overflow: hidden;\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table thead {\n" +
            "                position: relative;\n" +
            "                clip: auto;\n" +
            "                height: auto;\n" +
            "                width: auto;\n" +
            "                overflow: auto;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table thead th {\n" +
            "            background-color: #1d96b2;\n" +
            "            border: 1px solid #1d96b2;\n" +
            "            font-weight: normal;\n" +
            "            text-align: center;\n" +
            "            color: white;\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table thead th:first-of-type {\n" +
            "            text-align: left;\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table tbody,\n" +
            "        .responsive-table tr,\n" +
            "        .responsive-table th,\n" +
            "        .responsive-table td {\n" +
            "            display: block;\n" +
            "            padding: 0;\n" +
            "            text-align: left;\n" +
            "            white-space: normal;\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table tr {\n" +
            "                display: table-row;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table th,\n" +
            "        .responsive-table td {\n" +
            "            padding: .5em;\n" +
            "            vertical-align: middle;\n" +
            "            \n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "\n" +
            "            .responsive-table th,\n" +
            "            .responsive-table td {\n" +
            "                padding: .75em .5em;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "\n" +
            "            .responsive-table th,\n" +
            "            .responsive-table td {\n" +
            "                display: table-cell;\n" +
            "                padding: .5em;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 62em) {\n" +
            "\n" +
            "            .responsive-table th,\n" +
            "            .responsive-table td {\n" +
            "                padding: .75em .5em;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 75em) {\n" +
            "\n" +
            "            .responsive-table th,\n" +
            "            .responsive-table td {\n" +
            "                padding: .75em;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table caption {\n" +
            "            margin-bottom: 1em;\n" +
            "            font-size: 1em;\n" +
            "            font-weight: bold;\n" +
            "            text-align: center;\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table caption {\n" +
            "                font-size: 1.0em;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table tbody {\n" +
            "                display: table-row-group;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table tbody tr {\n" +
            "            margin-bottom: 1em;\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table tbody tr {\n" +
            "                display: table-row;\n" +
            "                border-width: 1px;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table tbody tr:last-of-type {\n" +
            "            margin-bottom: 0;\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table tbody tr:nth-of-type(even) {\n" +
            "                background-color: rgba(94, 93, 82, 0.1);\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table tbody th[scope=\"row\"] {\n" +
            "            background-color: #1d96b2;\n" +
            "            color: white;\n" +
            "            font-weight: normal;\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table tbody th[scope=\"row\"] {\n" +
            "                border-left: 1px solid #1d96b2;\n" +
            "                border-bottom: 1px solid #1d96b2;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table tbody th[scope=\"row\"] {\n" +
            "                background-color: transparent;\n" +
            "                color: #5e5d52;\n" +
            "                text-align: left;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table tbody td {\n" +
            "            text-align: right;\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table tbody td {\n" +
            "                border-left: 1px solid #1d96b2;\n" +
            "                border-bottom: 1px solid #1d96b2;\n" +
            "                text-align: center;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table tbody td:last-of-type {\n" +
            "                border-right: 1px solid #1d96b2;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table tbody td[data-type=currency] {\n" +
            "            text-align: right;\n" +
            "        }\n" +
            "\n" +
            "        .responsive-table tbody td[data-title]:before {\n" +
            "            content: attr(data-title);\n" +
            "            float: left;\n" +
            "            font-size: .8em;\n" +
            "            color: rgba(94, 93, 82, 0.75);\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table tbody td[data-title]:before {\n" +
            "                font-size: .9em;\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        @media (min-width: 0em) {\n" +
            "            .responsive-table tbody td[data-title]:before {\n" +
            "                content: none;\n" +
            "            }\n" +
            "        }\n" +
            "    </style>\n" +
            "\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "    <div class=\"container\">\n" +
            "        <table class=\"responsive-table\">\n" +
            "            <caption>Уважаемые коллеги, добрый день. <br>\n" +
            "                Просьба списать недостающее время за текущий месяц в Адванте:\n" +
            "            </caption>\n" +
            "            <thead>\n" +
            "                <tr>\n" +
            "                    <th scope=\"col\">Сотрудник</th>\n" +
            "                    <th scope=\"col\">Должно быть списано, ч</th>\n" +
            "                    <th scope=\"col\">Списано, ч</th>\n" +
            "                    <th scope=\"col\">Отклонение от плана</th>\n" +
            "                </tr>\n" +
            "            </thead>\n" +
            "            <tbody>";
    static String bottom = "</tbody>\n" +
            "        </table>\n" +
            "    </div>\n" +
            "</body>\n" +
            "</html>";
}

