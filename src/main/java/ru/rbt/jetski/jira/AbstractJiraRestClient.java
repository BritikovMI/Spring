package ru.rbt.jetski.jira;

import ru.rbt.jetski.security.AuthWrapper;
import ru.rbt.jetski.security.BritikovMIWrapper;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ru.rbt.jetski.api.RestApiMediaType.JSON_UTF8;
import static ru.rbt.jetski.api.RestApiPathNames.PATH_ECHO;

/**
 * Created by misha on 14.08.2018.
 */
public abstract class AbstractJiraRestClient implements JiraRestClient {

    private static final Logger logger = Logger.getLogger(AbstractJiraRestClient.class.getName());

    private static final String restApiUrl = "https://rbtechnologies.atlassian.net";
    private final AuthWrapper auth = new BritikovMIWrapper();

    protected abstract String getContext();

    @Override
    public String echo() {
        return get(getContext() + PATH_ECHO, String.class, MediaType.TEXT_PLAIN);
    }

    @Override
    public <E> int create(E entity) {
        return post(getContext(), JSON_UTF8, entity);
    }

    @Override
    public <I, E> E read(I id) {
        GenericType<E> resultClass = new GenericType<E>(){};
        Class<E> cl = (Class<E>) resultClass.getClass();
        return get(getContext() + "/" + id, cl, JSON_UTF8);
    }

    @Override
    public <I, E> int update(I id, E entity) {
        return put(getContext() + "/" + id, JSON_UTF8, entity);
    }

    @Override
    public <I> int delete(I id) {
        return del(getContext() + "/" + id);
    }

    @Override
    public <E> List<E> list(Integer offset, Integer length) {
        return search(getContext(), JSON_UTF8);
    }

    protected <T> T get(String path, Class<T> resultClass, String mediaType) {
        return wrap(ClientBuilder.newClient().target(restApiUrl).path(path).request(mediaType)).get(resultClass);
    }

    protected <T> List<T> search(String path, String mediaType) {
        return wrap(ClientBuilder.newClient().target(restApiUrl).path(path).request(mediaType)).get(getListGenericType());
    }

    protected <T> int post(String path, String mediaType, T entity) {
        return wrap(ClientBuilder.newClient().target(restApiUrl).path(path).request(mediaType))
                .post(Entity.entity(entity, mediaType)).getStatus();
    }

    protected <T> int put(String path, String mediaType, T entity) {
        return wrap(ClientBuilder.newClient().target(restApiUrl).path(path).request(mediaType))
                .put(Entity.entity(entity, mediaType)).getStatus();
    }

    protected <T> int del(String path) {
        return wrap(ClientBuilder.newClient().target(restApiUrl).path(path).request(JSON_UTF8))
                .delete().getStatus();
    }

    protected <E> GenericType<E> getGenericType() {
        return new GenericType<E>(){};
    }

    protected <T> GenericType<List<T>> getListGenericType() {
        return new GenericType<List<T>>(){};
    }

    private Invocation.Builder wrap(Invocation.Builder builder) {
        try {
            return auth.addAuth(builder);
        } catch (UnsupportedEncodingException e) {
            logger.log(Level.SEVERE, "Unsupported exception: " + e.getMessage(), e);
            return null;
        }
    }
}
