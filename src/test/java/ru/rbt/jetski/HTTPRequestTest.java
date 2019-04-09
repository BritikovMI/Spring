package ru.rbt.jetski;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HTTPRequestTest {

    private HTTPRequest httpRequestUnderTest;

    @Before
    public void setUp() {
        httpRequestUnderTest = new HTTPRequest();
    }

    @Test
    public void testGetHttpAuthentication() {
        // Setup
        final String expectedResult = "result";

        // Run the test
        final String result = httpRequestUnderTest.getHttpAuthentication();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDoDelete() {
        // Setup
        final String url = "url";
        final String username = "username";
        final String password = "password";
        final String expectedResult = "result";

        // Run the test
        final String result = httpRequestUnderTest.doDelete(url, username, password);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testMain() {
        // Setup
        final String[] args = new String[]{};

        // Run the test
        HTTPRequest.main(args);

        // Verify the results
    }
}
