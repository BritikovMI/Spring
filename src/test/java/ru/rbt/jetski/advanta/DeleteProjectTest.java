package ru.rbt.jetski.advanta;

import org.junit.Test;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.advanta.ws.apiprojects.ProjectIdDataContract;

public class DeleteProjectTest {
    @Test
    public void projectDeletion() {
        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();

        AdvantaAccess access = new AdvantaAccess();
        String projectUid ="82c322c0-9b9f-41d7-9ea6-68adc0e9ffc5";
        String sessionId = null;
        try {
            sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        ProjectWsDao pwd = new ProjectWsDao();
        ProjectIdDataContract contract = pwd.makeProjectIdDataContract(sessionId, projectUid);
                                     // APIProjectsSoap.deleteProject is void
        pwd.deleteProject(contract); //FIXME:  Deleting projects needs to be tested
    }
}
