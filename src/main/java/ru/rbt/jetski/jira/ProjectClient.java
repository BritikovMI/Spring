package ru.rbt.jetski.jira;


import java.util.List;

import static ru.rbt.jetski.api.RestApiContextNames.API_PROJECT;

/**
 * Created by misha on 14.08.2018.
 */
public class ProjectClient extends AbstractJiraRestClient {

    @Override
    protected String getContext() {
        return API_PROJECT;
    }

	@Override
	public <E> List<E> list(Integer offset, Integer length) {
		List<?> list = super.list(offset, length);
		return (List<E>) list;
	}
    
    
}
