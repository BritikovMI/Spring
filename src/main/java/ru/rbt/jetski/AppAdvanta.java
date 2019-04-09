package ru.rbt.jetski;

import ru.rbt.jetski.advanta.*;

import java.text.DateFormatSymbols;
import java.util.*;
import java.util.logging.Logger;

public class AppAdvanta {
	private static final Logger logger = Logger.getLogger(AppAdvanta.class.getName());
	public static void main(String[] args) {
		String period = (args[0] != null && args[0] != "")?args[0]:"week";
		try {
			AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();

			AdvantaAccess access = new AdvantaAccess();
			long start = System.currentTimeMillis();
			String sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());
			long finish = System.currentTimeMillis();
			System.out.println("Init session time: " + (finish - start) + " ms");
			// final String projectId = "214baa59-e8b4-40a2-bd12-fc6854caa9fb";
			Date stDate = new Date();
			Date currDate = new Date();

			StringBuilder mailContent = new StringBuilder();
			StringBuilder recepientsSB = new StringBuilder();
			Calendar cal = Calendar.getInstance();
			Map<String, Double> planHours = new HashMap<>();
			Map<String, Double> mainPlanHours = new HashMap<>();
			Map<String, Double> factHours = new HashMap<>();
			Map<String, Double> mainFactHours = new HashMap<>();
			List<Map<String, Double>> userInfo = new LinkedList<>();
			Mail mail = new Mail();
			ProjectWsDao pwd = new ProjectWsDao();
			String mailDummy = "BritikovMI@rbtechnologies.ru";
			TreeSet<String> requiredRecepients = new TreeSet<>();

			CalendarDao calendar = new CalendarDao();
			start = System.currentTimeMillis();
			Map<String, String> mapOfProdCalendars = calendar.getMapOfProdCalendars(sessionId); // Получаем
																								// map
																								// производственных
																								// календарей
																								// сотрудников
			finish = System.currentTimeMillis();
			System.out.println("getMapOfProdCalendars time: " + (finish - start) + " ms");

			start = System.currentTimeMillis();
			Set<String> projects = pwd.getSetOfProjects(sessionId); // DummyProjectSet
																	// start
			finish = System.currentTimeMillis();
			System.out.println("getSetOfProjects time: " + (finish - start) + " ms");

			int numOfProjects = projects.size();

			
			while (projects.remove(null))
				;
			PersonsWsDao prws = new PersonsWsDao();
			
			start = System.currentTimeMillis();
			Map<String, String> employeesInfo = prws.getPersons(sessionId);// Получаем
																			// Map
																			// сотрудников
																			// (Фио,
																			// email)
			finish = System.currentTimeMillis();
			System.out.println("getPersons time: " + (finish - start) + " ms");

			// Iterator<String> projectsIterator = projects.iterator();
			// while (projectsIterator.hasNext()) {
			// System.out.println(projectsIterator.next());
			// }

			AdvantaProjectTSh ats = new AdvantaProjectTSh();

			ProjectWsDao prjDao = new ProjectWsDao();
			for (String row : projects) {
				start = System.currentTimeMillis();
				if (row != null && row != "" && !row.equals("")) {
					
					System.out.println("\n" + row + " :project");
					userInfo = prjDao.advantaProjectTSh(sessionId, row, mapOfProdCalendars, period); // Returns
																								// List<Map<String,
																								// Double>>
					planHours = userInfo.get(0);
					factHours = userInfo.get(1);

					for (String planRow : planHours.keySet()) {
						if (!mainPlanHours.containsKey(planRow))
							mainPlanHours.put(planRow, planHours.get(planRow));
					}
					for (String factRow : factHours.keySet()) {
						if (!mainFactHours.containsKey(factRow))
							mainFactHours.put(factRow, factHours.get(factRow));
						else
							mainFactHours.put(factRow, mainFactHours.get(factRow) + factHours.get(factRow));
					}
					
				}
				finish = System.currentTimeMillis();
				currDate = new Date();
				System.out.println("Complete: " + getIndex(projects, row) + "/" + numOfProjects + " прошло: "
						+ computeDiff(stDate, currDate) + " ; " + (finish - start) + " ms");
				
			}

			for (String row : mainFactHours.keySet()) {
				if (!mainPlanHours.get(row).equals(mainFactHours.get(row)))
					requiredRecepients.add(row);
			}

			for (String a : requiredRecepients) {
				// recepientsSB.append(employeesInfo.get(a) + ","); //TODO:
				// Распаковать, чтобы отправить всем нужным пользователям
				mailContent.append(String.format(
						"<tr>\n" + "                    <th scope=\"row\">%S</th>\n"
								+ "                    <td data-title=\"Должно быть списано, ч\">%S</td>\n"
								+ "                    <td data-title=\"Списано, ч\">%S</td>\n"
								+ "                    <td data-title=\"Отклонение от плана, ч\">%S</td>\n"
								+ "                </tr>",
						a, mainPlanHours.get(a), mainFactHours.get(a), (mainPlanHours.get(a) - mainFactHours.get(a))));
			}
			recepientsSB.append(mailDummy + ","); // Dummy
			recepientsSB.append(":,");

			System.out.println(mail.mailSender(recepientsSB.toString().replace(",:,", ""),
					new DateFormatSymbols().getMonths()[cal.get(Calendar.MONTH)], mailContent.toString()));
			// for (String a : keys
			// ) {
			// if (Integer.parseInt(mapHours.get(a).split(":")[2]) -
			// Integer.parseInt(mapHours.get(a).split(":")[1]) != 0)
			// //(Получаели через запятую, Фио через запятую, Плановые часы,
			// Месяц строкой, Фактические часы
			// Отправляем на почту только если количество плановых часов с
			// коэффициэнтом не равно количеству списанных часов
			// mail.mailSender(/*mapHours.get("employee"))*/"supercep110@gmail.com",
			// mapHours.get(a).split(":")[0],
			// Integer.parseInt(mapHours.get(a).split(":")[2]), new
			// DateFormatSymbols().getMonths()[cal.get(Calendar.MONTH)],
			// Integer.parseInt(mapHours.get(a).split(":")[1]));
			//// mail.mailSender(mapHours.get(/*employeeProps.get("employee"))*/"supercep110@gmail.com",
			// mapHours.get("s").split(":")[1],
			// Integer.parseInt(mapHours.get("s").split(":")[3]), new
			// DateFormatSymbols().getMonths()[cal.get(Calendar.MONTH)],
			// Integer.parseInt(mapHours.get("s").split(":")[2]));
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getIndex(Set<? extends Object> set, Object value) {
		int result = 1;
		for (Object entry : set) {
			if (entry.equals(value))
				return result;
			result++;
		}
		return -1;
	}

	public static String computeDiff(Date d1, Date d2) {
		long elapsed = d2.getTime() - d1.getTime();

		int hours = (int) Math.floor(elapsed / 3600000);

		int minutes = (int) Math.floor((elapsed - hours * 3600000) / 60000);

		int seconds = (int) Math.floor((elapsed - hours * 3600000 - minutes * 60000) / 1000);

		return hours + ":" + minutes + ":" + seconds;
	}
}
