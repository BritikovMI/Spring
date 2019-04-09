package ru.rbt.jetski.jira;

import java.util.List;

/**
 * Created by misha on 14.08.2018.
 */
public interface JiraRestClient {
    String echo();
    <E> int create(E entity);
    <I, E> E read(I id);
    <I, E> int update(I id, E entity);
    <I> int delete(I id);
    <E> List<E> list(Integer offset, Integer length);
}
