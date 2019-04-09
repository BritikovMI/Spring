package ru.rbt.jetski.advanta;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class XMLParse {
    public String xmlParser() {
        Calendar cal = Calendar.getInstance();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        String val = new String();
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("http://xmlcalendar.ru/data/ru/2018/calendar.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();


            List<String> names = getDaysAndType(doc, xpath);
            for (String s : names
                    ) {
                val += s;
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return val.replace("\n", "");
    }


    private static List<String> getDaysAndType(Document doc, XPath xpath) {
        List<String> list = new ArrayList<>();
        try {
            XPathExpression expr =
                    xpath.compile("calendar/days/day/@d|calendar/days/day/@t");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                list.add((i%2 == 0)?nodes.item(i).getNodeValue() + "," :nodes.item(i).getNodeValue() + ";");
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }
}
