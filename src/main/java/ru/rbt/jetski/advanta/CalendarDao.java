/**
 * 
 */
package ru.rbt.jetski.advanta;

import ru.rb.cfg.exception.ConfigurationException;
import streamline.APIProjects;
import streamline.APIProjectsSoap;
import streamline.ArrayOfProjectWrapper;
import streamline.ProjectWrapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author sotnik
 *
 */
public class CalendarDao {
	
	private static final AdvantaConfiguration cfg = AdvantaConfiguration.getInstance();

	public Map<String, String> getMapOfProdCalendars(String sessionId) throws ParseException, ConfigurationException {
		Map<String, String> mapOfProdCalendars = new HashMap<>();
		Calendar cal = Calendar.getInstance();
//		StringBuilder numOfTrueCondition = new StringBuilder();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		Date futureDate = new Date();
		DateFormat month = new SimpleDateFormat("MM");
		DateFormat year = new SimpleDateFormat("yyyy");
		Date date = new Date();
//		int hours = 0;

		date = df.parse(cal.get(Calendar.YEAR) + "-" + ((cal.get(Calendar.MONTH) + 1 < 10)
				? "0" + (cal.get(Calendar.MONTH) + 1) : cal.get(Calendar.MONTH) + 1) + "-01T00:00:00");
		futureDate = df.parse("0001-01-01T00:00:00");

		// String projectUid = "05079029-036f-44cf-a54e-98453c6e2c6a";
		// //Производственный календарь

		APIProjects apiProjects = new APIProjects();

		APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
		ArrayOfProjectWrapper arrayOfProjectWrapper = apiProjectsSoap.getSubprojectsDates(sessionId, cfg.getCalendarProjectId());
		Date finalFutureDate = futureDate;
		Date finalDate = date;
		
		Calendar finalFutureCalendar = Calendar.getInstance();
		finalFutureCalendar.setTime(finalFutureDate);
		finalFutureCalendar.set(Calendar.HOUR, 0);
		finalFutureCalendar.set(Calendar.MINUTE, 0);
		finalFutureCalendar.set(Calendar.SECOND, 0);
		finalFutureCalendar.set(Calendar.MILLISECOND, 0);
		
		Calendar finalCalendar = Calendar.getInstance();
		finalCalendar.setTime(finalDate);
		finalCalendar.set(Calendar.HOUR, 0);
		finalCalendar.set(Calendar.MINUTE, 0);
		finalCalendar.set(Calendar.SECOND, 0);
		finalCalendar.set(Calendar.MILLISECOND, 0);
		
		for(ProjectWrapper pw:arrayOfProjectWrapper.getProjectWrapper()) {
			if (/* mapOfProdCalendars.containsKey(pw.getName()) && */((df
					.parse(String.valueOf(pw.getActualEndDate())).equals(finalFutureDate))
					&& ((year.format(df.parse(String.valueOf(pw.getPlannedEndDate())))
							.equals(year.format(finalDate)))
							&& (Integer.parseInt(
									month.format(df.parse(String.valueOf(pw.getPlannedEndDate())))) >= Integer
											.parseInt(month.format(finalDate)))))
					|| ((df.parse(String.valueOf(pw.getActualEndDate())).equals(finalFutureDate)) && ((Integer
							.parseInt(year.format(df.parse(String.valueOf(pw.getPlannedEndDate())))) > Integer
									.parseInt(year.format(finalDate)))))) {// Берем
																			// только
																			// актуальные
																			// календари
				// if(mapOfProdCalendars.containsKey(pw.getName()) ||
				// mapOfProdCalendars.containsKey(pw.getName().replaceAll(regexFullTemplate,
				// "$1 $2. $3.")))
				mapOfProdCalendars.put(pw.getName(), pw.getUID());
			}
//			Calendar actualEndDate = pw.getActualEndDate().toGregorianCalendar();
//			actualEndDate.set(Calendar.HOUR, 0);
//			actualEndDate.set(Calendar.MINUTE, 0);
//			actualEndDate.set(Calendar.SECOND, 0);
//			actualEndDate.set(Calendar.MILLISECOND, 0);
//			
//			Calendar plannedEndDate = pw.getPlannedEndDate().toGregorianCalendar();
//			plannedEndDate.set(Calendar.HOUR, 0);
//			plannedEndDate.set(Calendar.MINUTE, 0);
//			plannedEndDate.set(Calendar.SECOND, 0);
//			plannedEndDate.set(Calendar.MILLISECOND, 0);
//			
//			System.out.println("actualEndDate=" + actualEndDate.getTime() + " ; plannedEndDate=" + plannedEndDate.getTime() );
//			
//			if (/* mapOfProdCalendars.containsKey(pw.getName()) && */
//					(
//							(actualEndDate.getTime().equals(finalFutureDate))
//							&& (plannedEndDate.get(Calendar.YEAR) == finalCalendar.get(Calendar.YEAR))
//							&& (plannedEndDate.get(Calendar.MONTH) >= finalCalendar.get(Calendar.MONTH))
//					)
//					|| 
//					(
//							(actualEndDate.getTime().equals(finalFutureDate)) 
//							&& 
//							(plannedEndDate.get(Calendar.YEAR) > finalCalendar.get(Calendar.YEAR))
//					)
//				){// Берем
//																			// только
//																			// актуальные
//																			// календари
//				// if(mapOfProdCalendars.containsKey(pw.getName()) ||
//				// mapOfProdCalendars.containsKey(pw.getName().replaceAll(regexFullTemplate,
//				// "$1 $2. $3.")))
//				mapOfProdCalendars.put(pw.getName(), pw.getUID());
//			}
		}
//		.stream().parallel().forEach(pw -> {
//			try {
//				
//				
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//
//		});
		return mapOfProdCalendars;

	}

	public Set<String> getCalendarPrjTasks(String sessionId, String calendarPrjId) {
		APIProjects apiProjects = new APIProjects();
		Set<String> prodCalendarTasks = new HashSet<>();
		APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
		ArrayOfProjectWrapper arrayOfProjectWrapper = apiProjectsSoap.getSubprojectsDates(sessionId, calendarPrjId);
		arrayOfProjectWrapper.getProjectWrapper().stream().forEach(pw -> {
			prodCalendarTasks.add(pw.getUID());
		});
		return prodCalendarTasks;
	}
	
}
