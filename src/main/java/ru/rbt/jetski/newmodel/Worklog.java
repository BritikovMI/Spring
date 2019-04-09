/**
 * 
 */
package ru.rbt.jetski.newmodel;

import org.joda.time.DateTime;

/**
 * @author sotnik
 *
 */
public class Worklog {

	private Executor executor;
	
	private int factWorkHours;

	private DateTime startDate;

	private String subtask;

	public Executor getExecutor() {
		return executor;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}

	public int getFactWorkHours() {
		return factWorkHours;
	}

	public void setFactWorkHours(int factWorkHours) {
		this.factWorkHours = factWorkHours;
	}

	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	public String getSubtask() {
		return subtask;
	}

	public void setSubtask(String subtask) {
		this.subtask = subtask;
	}
}
