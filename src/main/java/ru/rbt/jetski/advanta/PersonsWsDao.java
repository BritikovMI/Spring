package ru.rbt.jetski.advanta;

import ru.rbt.jetski.advanta.ws.persons.PersonQueryResult;
import ru.rbt.jetski.advanta.ws.persons.Persons;
import ru.rbt.jetski.advanta.ws.persons.PersonsSoap;

import java.util.HashMap;
import java.util.Map;


public class PersonsWsDao {

    /**
     *
     */
    public String get(String sessionId, String pid) {
        try {
            StringBuilder sb = new StringBuilder();
            Persons persons = new Persons();
            PersonsSoap personsSoap = persons.getPersonsSoap12();
            PersonQueryResult personQueryResult = personsSoap.getPerson(sessionId, pid);
            personQueryResult.getPersons().getSlPerson().stream().forEach(slp -> {
                sb.append(slp.getFullName() + ";" + slp.getEMail() + ";" + slp.getUID());
            });
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, String> getPersons(String sessionId) {
//        String sessionId = initSession();
        Map<String, String> employeesInfo = new HashMap<>();
        try {
            Persons persons = new Persons();
            PersonsSoap personsSoap = persons.getPersonsSoap12();
            PersonQueryResult personQueryResult = personsSoap.getPersons(sessionId);
            personQueryResult.getPersons().getSlPerson().stream().forEach(slp -> {
                employeesInfo.put(slp.getFullName(), slp.getEMail());
            });
            return employeesInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
