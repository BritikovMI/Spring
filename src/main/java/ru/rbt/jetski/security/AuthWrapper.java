package ru.rbt.jetski.security;

import javax.ws.rs.client.Invocation;
import java.io.UnsupportedEncodingException;

public interface AuthWrapper {
    Invocation.Builder addAuth(Invocation.Builder builder) throws UnsupportedEncodingException;
}
