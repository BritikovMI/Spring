/**
 * 
 */
package ru.rbt.jetski.newmodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sotnik
 *
 */
public class Project {
	
	private String name;
	
	private String advantaId;
	
	private String jiraId;
	
	private Date startDate;
	
	private Date finishDate;
	
	private int year;

	private List<Component> components = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdvantaId() {
		return advantaId;
	}

	public void setAdvantaId(String advantaId) {
		this.advantaId = advantaId;
	}

	public String getJiraId() {
		return jiraId;
	}

	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}
	
}
