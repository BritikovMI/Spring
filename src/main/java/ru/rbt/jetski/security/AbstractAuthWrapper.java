package ru.rbt.jetski.security;

import javax.ws.rs.client.Invocation;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public abstract class AbstractAuthWrapper implements AuthWrapper {

    private static final String header = "Authorization";

    public Invocation.Builder addAuth(Invocation.Builder builder) throws UnsupportedEncodingException {
        return builder.header(header, getAuthorizationHeader());
    }

    private String getAuthorizationHeader() throws UnsupportedEncodingException {
        String token = new StringBuilder().append(getEmail()).append(':').append(getToken()).toString();
        token = Base64.getEncoder().encodeToString(token.getBytes("utf-8"));
        return new StringBuilder().append("Basic ").append(token).toString();
    }

    protected abstract String getEmail();

    protected abstract String getToken();
}
