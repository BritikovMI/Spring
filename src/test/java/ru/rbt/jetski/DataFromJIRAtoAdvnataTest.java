package ru.rbt.jetski;

import org.apache.log4j.BasicConfigurator;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.advanta.AdvantaAccess;
import ru.rbt.jetski.advanta.AdvantaConfiguration;
import ru.rbt.jetski.advanta.ProjectWsDao;
import ru.rbt.jetski.advanta.ws.apiprojects.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

public class DataFromJIRAtoAdvnataTest {
    public static void main(String[] args) {
        DataFromJIRAtoAdvnataTest dtf = new DataFromJIRAtoAdvnataTest();

        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();
        AdvantaAccess access = new AdvantaAccess();

        String sessionId = null;
        try {
            sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        System.out.println(dtf.updateAdvantaProject(sessionId));
    }

    public String updateAdvantaProject(String sessionId) {
        APIProjects apiProjects = new APIProjects();
        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();

        ProjectWsDao pwd = new ProjectWsDao();

        DateUtils du = new DateUtils();
        LocalDate ld = LocalDate.now();

        XMLGregorianCalendar factEndDate = du.localDateToXMLGregorianCalendar(ld);

        ProjectWrapper pw = pwd.taskWrapper(sessionId, "53b37067-fe82-458d-9fb5-80fb25f2ab2f");
        pw.setActualEndDate(factEndDate);
        pw.setPercentComplete(100);
        pw.setStatus(6);

        UpdateProjectDataContract ps = new UpdateProjectDataContract();
        ps.setASPNETSessionId(sessionId);
        ps.setProject(pw);

        String result = apiProjectsSoap.updateProject(ps);

        return result;
    }
}
