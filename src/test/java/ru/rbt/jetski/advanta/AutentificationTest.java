package ru.rbt.jetski.advanta;

import org.junit.Test;
import ru.rb.cfg.exception.ConfigurationException;

import static org.junit.Assert.assertNotNull;

public class AutentificationTest {
    @Test
    public void Autentification() throws ConfigurationException {
        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();

        AdvantaAccess access = new AdvantaAccess();
        String sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());

        System.out.println(sessionId);

        assertNotNull(sessionId);
    }
}
