package ru.rbt.jetski.advanta;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.advanta.ws.apiprojects.APIProjects;
import ru.rbt.jetski.advanta.ws.apiprojects.APIProjectsSoap;
import ru.rbt.jetski.advanta.ws.apiprojects.CreateProjectDataContract;
import ru.rbt.jetski.jira.JiraConfiguration;

import java.time.LocalDate;

public class AdvantaTestCreateProject {

    public static void main(String[] args) throws ConfigurationException {
//        BasicConfigurator.configure();
        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();

        AdvantaAccess access = new AdvantaAccess();

        ProjectWsDao projectDao = new ProjectWsDao();
        String sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());
        String parentUId = "09cace2f-ac42-4cb6-97f0-f17456bb786e";
        String name = "Testing project";
        String ownerID = "eac9da1f-0abe-4175-a07e-1dd23ec5ab47";
        String projectTypeId = "4fd6c579-66ff-45f6-8bce-9970aad83b10";
        String responsibleId = "eac9da1f-0abe-4175-a07e-1dd23ec5ab47";
        LocalDate startDate = LocalDate.now(), endDate = startDate.plusDays(1);

        CreateProjectDataContract contract = projectDao.makeDataContract(sessionId, parentUId, name, projectTypeId, ownerID, responsibleId, startDate, endDate);
        System.out.println(contract);

        APIProjects apiProjects = new APIProjects();
        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
        String result = apiProjectsSoap.createProject(contract);
        System.out.println(result);
    }
}
