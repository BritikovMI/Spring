package ru.rbt.jetski.advanta;

import org.junit.Before;
import org.junit.Test;
import ru.rbt.jetski.advanta.ws.apiprojects.ProjectWrapper;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class ProjectWsDaoTest {

    private ProjectWsDao projectWsDaoUnderTest;

    @Before
    public void setUp() {
        projectWsDaoUnderTest = new ProjectWsDao();
    }

    @Test
    public void testGet() {
        // Setup
        final String sessionId = "sessionId";
        final String uid = "uid";
        final ProjectWrapper expectedResult = null;

        // Run the test
        final ProjectWrapper result = projectWsDaoUnderTest.get(sessionId, uid);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetSetOfProjects() throws Exception {
        // Setup
        final String sessionId = "sessionId";
        final Set<String> expectedResult = new HashSet<>();

        // Run the test
        final Set<String> result = projectWsDaoUnderTest.getSetOfProjects(sessionId);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetProjectTasks() {
        // Setup
        final String sessionId = new AdvantaAccess().initSession("BritikovMI", "Profi2018");
        final String projectId = "214baa59-e8b4-40a2-bd12-fc6854caa9fb";
        final Set<String> expectedResult = new HashSet<>();

        // Run the test
        final Set<String> result = projectWsDaoUnderTest.getProjectTasks(sessionId, projectId);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetFiredDates() throws Exception {
        // Setup
        final String sessionId = "sessionId";
        final Map<String, Date> expectedResult = new HashMap<>();

        // Run the test
        final Map<String, Date> result = projectWsDaoUnderTest.getFiredDates(sessionId);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetClosedTasks() throws Exception {
        // Setup
        final String sessionId = "sessionId";
        final String projectId = "projectId";
        final Set<String> expectedResult = new HashSet<>();

        // Run the test
        final Set<String> result = projectWsDaoUnderTest.getProjectTasks(sessionId, projectId);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetResourceAssignments() {
        // Setup
        final String sessionId = "sessionId";
        final String uid = "uid";
        final double expectedResult = 0.0;

        // Run the test
        final double result = projectWsDaoUnderTest.getResourceAssignments(sessionId, uid);

        // Verify the results
        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testAdvantaProjectTSh() throws Exception {
        // Setup
        final String sessionId = "sessionId";
        final String projectId = "projectId";
        final Map<String, String> mapOfProdCalendars = new HashMap<>();
        final String period = "period";
        final List<Map<String, Double>> expectedResult = Arrays.asList();

        // Run the test
        final List<Map<String, Double>> result = projectWsDaoUnderTest.advantaProjectTSh(sessionId, projectId, mapOfProdCalendars, period);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetWorkingHoursBetweenTwoDates() {
        // Setup
        final LocalDate localDate1 = LocalDate.of(2017, 1, 1);
        final LocalDate localDate2 = LocalDate.of(2017, 1, 1);
        final Double coeff = 0.0;
        final Double expectedResult = 0.0;

        // Run the test
        final Double result = projectWsDaoUnderTest.getWorkingHoursBetweenTwoDates(localDate1, localDate2, coeff);

        // Verify the results
        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testHoursCorrection() {
        // Setup
        final LocalDate localDate1 = LocalDate.of(2017, 1, 1);
        final LocalDate localDate2 = LocalDate.of(2017, 1, 1);
        final int expectedResult = 0;

        // Run the test
        final int result = projectWsDaoUnderTest.hoursCorrection(localDate1, localDate2);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetWeekDayNameForInt() {
        // Setup
        final int num = 0;
        final String expectedResult = "result";

        // Run the test
        final String result = projectWsDaoUnderTest.getWeekDayNameForInt(num);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
