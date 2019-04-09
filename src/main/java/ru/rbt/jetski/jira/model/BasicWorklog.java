package ru.rbt.jetski.jira.model;

import com.atlassian.jira.rest.client.domain.BasicUser;

import java.util.ArrayList;
import java.util.List;

public class BasicWorklog {
    private String parentSubtaskKey;
    private BasicUser Employee;
    private Integer worklogHours;

    protected List<BasicWorklog> worklogs;

    public List<BasicWorklog> worklogList() {
        if (worklogs == null) {
            worklogs = new ArrayList<>();
        }
        return this.worklogs;
    }

    public BasicUser getEmployee() {
        return Employee;
    }

    public Integer getWorklogHours() {
        return worklogHours;
    }

    public void setWorklogHours(Integer worklogHours) {
        this.worklogHours = worklogHours;
    }

    public void setEmployee(BasicUser employee) {
        Employee = employee;
    }

    public String getParentSubtaskKey() {
        return parentSubtaskKey;
    }

    public void setParentSubtaskKey(String parentSubtaskKey) {
        this.parentSubtaskKey = parentSubtaskKey;
    }
}
