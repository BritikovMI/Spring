package ru.rbt.jetski.newmodel;

import java.util.ArrayList;
import java.util.List;

public class Subtask {

	private String jiraId;

	private String name;
	
	private int planWorkHours;
	
	private List<Worklog> workLogs = new ArrayList<>();
	
	public String getJiraId() {
		return jiraId;
	}

	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlanWorkHours() {
		return planWorkHours;
	}

	public void setPlanWorkHours(int planWorkHours) {
		this.planWorkHours = planWorkHours;
	}

	public List<Worklog> getWorkLogs() {
		return workLogs;
	}

	public void setWorkLogs(List<Worklog> workLogs) {
		this.workLogs = workLogs;
	}

	public int getFactWorkHours() {
		int sum = 0;
		for(Worklog worklog:workLogs) {
			sum += worklog.getFactWorkHours();
		}
		return sum;
	}
}
