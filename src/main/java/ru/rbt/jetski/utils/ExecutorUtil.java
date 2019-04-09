package ru.rbt.jetski.utils;

import com.atlassian.jira.rest.client.domain.BasicUser;
import ru.rbt.jetski.newmodel.Executor;

/**
 * Created by BritikovMI on 02.04.2019.
 */
public class ExecutorUtil {
    public static Executor initilizeExecutor(com.atlassian.jira.rest.client.domain.Worklog worklog) {
        Executor executor = new Executor();
        BasicUser basicUser = worklog.getAuthor();

        executor.setName(basicUser.getName());

        return executor;
    }
}
