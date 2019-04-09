/**
 * 
 */
package ru.rbt.jetski.newmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sotnik
 *
 */
public class Component {
	
	private String jiraId;
	
	private String advantaId;
	
	private String componentName;

	private String parentProjectName;

	private List<Epic> epics = new ArrayList<>();

	public String getJiraId() {
		return jiraId;
	}

	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}

	public String getAdvantaId() {
		return advantaId;
	}

	public void setAdvantaId(String advantaId) {
		this.advantaId = advantaId;
	}

	public List<Epic> getEpics() {
		return epics;
	}

	public void setEpics(List<Epic> epics) {
		this.epics = epics;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getParentProjectName() {
		return parentProjectName;
	}

	public void setParentProjectName(String parentProjectName) {
		this.parentProjectName = parentProjectName;
	}
}
