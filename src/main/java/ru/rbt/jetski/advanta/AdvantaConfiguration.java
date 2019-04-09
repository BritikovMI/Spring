/**
 * 
 */
package ru.rbt.jetski.advanta;

import ru.rb.cfg.SystemConfiguration;
import ru.rb.cfg.exception.ConfigurationException;
import ru.rb.cfg.prop.PropertiesConfiguration;

/**
 * @author sotnik
 *
 */
public class AdvantaConfiguration {

	public static final String ADVANTA_PROPERTY_NAME = "ADVANTA";

	private static final AdvantaConfiguration INSTANCE = new AdvantaConfiguration();

	private static final SystemConfiguration cfg = SystemConfiguration.getInstance();

	private AdvantaConfiguration() {
	}

	public static final AdvantaConfiguration getInstance() {
		if (!cfg.containsConfig(ADVANTA_PROPERTY_NAME)) {
			try {
                System.out.println(System.getProperty("user.dir"));
                cfg.add(PropertiesConfiguration.create(ADVANTA_PROPERTY_NAME, "src/main/properties/advanta.properties"));
			} catch (ConfigurationException ex) {
				throw new RuntimeException(ex);
			}
		}
		return INSTANCE;
	}

	public String getLogin() throws ConfigurationException {
		return cfg.getString("advanta.login");
	}

	public String getPassword() throws ConfigurationException {
		return cfg.getString("advanta.pswd");
	}

	public String getCalendarProjectId() throws ConfigurationException {
		return cfg.getString("advanta.calendar.prj.id");
	}
	@Deprecated //Ресурсного плана больше нет в Advanta
	public String getResourcePlanProjectId() throws ConfigurationException {
		return cfg.getString("advanta.resourceplan.prj.id");
	}

	public String getPayedProjectId() throws ConfigurationException {
		return cfg.getString("advanta.payed.prj.id");
	}

	public String getClosedPayedProjectId() throws ConfigurationException {
		return cfg.getString("advanta.payed.prj.clsd.id");
	}

	public String getClosedInvestProjectId() throws ConfigurationException {
		return cfg.getString("advanta.invest.clsd.prj.id");
	}

	public String getClosedIntAdmProjectId() throws ConfigurationException {
		return cfg.getString("advanta.admin.clsd.prj.id");
	}

	public String getClosedPresaleProjectId() throws ConfigurationException {
		return cfg.getString("advanta.presale.clsd.prj.id");
	}

	public String getDirectoryId() throws ConfigurationException {
		return cfg.getString("advanta.directory.id");
	}

}
