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
public class Epic {
	
	private String advantaId;
	
	private String jiraId;
	
	private String epicName;

	private List<Subtask> tasks = new ArrayList<>();
	
	private int planWorkHours;

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

	public String getEpicName() {
		return epicName;
	}

	public void setEpicName(String epicName) {
		this.epicName = epicName;
	}

	public List<Subtask> getTasks() {
		return tasks;
	}

	public void setTasks(List<Subtask> tasks) {
		this.tasks = tasks;
	}

	public int getPlanWorkHours() {
		return planWorkHours;
	}

	public void setPlanWorkHours(int planWorkHours) {
		this.planWorkHours = planWorkHours;
	}
	
	public int getFactWorkHours() {
		int sum = 0;
		for(Subtask task:tasks) {
			sum += task.getFactWorkHours();
		}
		return sum;
	}
}
