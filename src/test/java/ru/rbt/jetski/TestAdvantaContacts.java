package ru.rbt.jetski;

import ru.rbt.jetski.advanta.ProjectWsDao;

import java.util.ArrayList;
import java.util.List;

public class TestAdvantaContacts {
    public static void main(String[] args) {
        ProjectWsDao projectDao = new ProjectWsDao();
        List<String> projects = new ArrayList<>(); //DummyProjectList
        projects.add("214baa59-e8b4-40a2-bd12-fc6854caa9fb");
        projects.add("d4352053-7f48-4561-8a54-347360553a4b");
        projects.add("4826bdc1-41c1-4f94-b15b-096236618adc");
        projects.add("09cace2f-ac42-4cb6-97f0-f17456bb786e");
        projects.add("099704f5-6178-4b5a-9bf4-68e1902887c1");
        for (String proj: projects
             ) {
            System.out.println("\nProject " +  proj + " start");
//            String userRate = projectDao.getResourceAssignments(proj); //Получаем String(id:Rate)
//        System.out.println(getWorkingHoursBetweenTwoDates(new Date(), 1.0));
//        System.out.println(coutingExceptions());
//            System.out.println((userRate.trim() != null && userRate.trim() != ""  && !userRate.trim().equalsIgnoreCase(""))? userRate: "NO SUCH PROJECT INFO");
            System.out.println("Project " +  proj + " end\n");


        }
    }
}
