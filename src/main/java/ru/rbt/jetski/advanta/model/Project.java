package ru.rbt.jetski.advanta.model;

import ru.rb.cfg.exception.ConfigurationException;
import ru.rbt.jetski.advanta.AdvantaAccess;
import ru.rbt.jetski.advanta.AdvantaConfiguration;
import ru.rbt.jetski.advanta.ProjectWsDao;
import ru.rbt.jetski.advanta.ws.apiprojects.APIProjects;
import ru.rbt.jetski.advanta.ws.apiprojects.APIProjectsSoap;
import ru.rbt.jetski.advanta.ws.apiprojects.ArrayOfProjectWrapper;
import ru.rbt.jetski.advanta.ws.apiprojects.ProjectWrapper;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;

/**
 * Created by BritikovMI on 07.03.2019.
 */
public class Project {
    public static final int STATUS_ALLEGED = 1;

    public static final int STATUS_IN_PROGRESS = 3;

    public static final int STATUS_NEEDS_ATTENTION = 4;

    public static final int STATUS_HIGHEST_PRIORITY = 5;

    public static final int STATUS_CLOSED = 6;

    public static final int STATUS_CANCELED = 7;

    public static final int STATUS_IN_HOLD = 8;

    public static final int STATUS_READY_TO_CHECK = 9;


    public static final String OUTSTAFF_ID = "10216319-a4a2-4fc8-98ab-620a4d476e73";

    public static final String FORECAST_ID = "8f47915f-a716-4ad9-9f35-f721e3752e2f";

    private String UID;
    private String ParentProjectId;
    private String Name;
    private String OwnerId;
    private String ResponsibleId;
    private int PercentComplete;
    private int Status;
    private int Level = -1;

    private XMLGregorianCalendar actualStartDate;
    private XMLGregorianCalendar actualEndDate;
    private XMLGregorianCalendar plannedStartDate;
    private XMLGregorianCalendar plannedEndDate;
    private XMLGregorianCalendar systemStartDate;
    private XMLGregorianCalendar systemEndDate;

    private ProjectWrapper projectWrapper;

    protected Project parent;

    public void setUID(String UID) {
        this.UID = UID;
    }

    public void setParentProjectId(String parentProjectId) {
        ParentProjectId = parentProjectId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    public void setResponsibleId(String responsibleId) {
        ResponsibleId = responsibleId;
    }

    public void setPercentComplete(int percentComplete) {
        PercentComplete = percentComplete;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public void setActualStartDate(XMLGregorianCalendar actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public void setActualEndDate(XMLGregorianCalendar actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public void setPlannedStartDate(XMLGregorianCalendar plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public void setPlannedEndDate(XMLGregorianCalendar plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public void setSystemStartDate(XMLGregorianCalendar systemStartDate) {
        this.systemStartDate = systemStartDate;
    }

    public void setSystemEndDate(XMLGregorianCalendar systemEndDate) {
        this.systemEndDate = systemEndDate;
    }

    public void setParent(Project parent) {
        this.parent = parent;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public void setProjectWrapper(ProjectWrapper projectWrapper) {
        this.projectWrapper = projectWrapper;
    }

    public String getUID() {
        return UID;
    }

    public String getParentProjectId() {
        return ParentProjectId;
    }

    public String getName() {
        return Name;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public String getResponsibleId() {
        return ResponsibleId;
    }

    public int getPercentComplete() {
        return PercentComplete;
    }

    public int getStatus() {
        return Status;
    }

    public XMLGregorianCalendar getActualStartDate() {
        return actualStartDate;
    }

    public XMLGregorianCalendar getActualEndDate() {
        return actualEndDate;
    }

    public XMLGregorianCalendar getPlannedStartDate() {
        return plannedStartDate;
    }

    public XMLGregorianCalendar getPlannedEndDate() {
        return plannedEndDate;
    }

    public XMLGregorianCalendar getSystemStartDate() {
        return systemStartDate;
    }

    public XMLGregorianCalendar getSystemEndDate() {
        return systemEndDate;
    }

    public Project getParent() {
        return parent;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public int getLevel() {
        return Level;
    }

    public ProjectWrapper getProjectWrapper() {
        return projectWrapper;
    }


    protected List<Project> projects;

    public List<Project> projectsList() {
        if (projects == null) {
            projects = new ArrayList<Project>();
        }
        return this.projects;
    }

    public List<Project> buildAdvantaProjectHierarchy(String mainParentProjectId) { // Id проекта, от которого строим иерархию, включая его
        Project rootProject = new Project();
        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();

        AdvantaAccess access = new AdvantaAccess();
        String sessionId = null;
        try {
            sessionId = access.initSession(advantaCfg.getLogin(), advantaCfg.getPassword());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        ProjectWsDao projectWsDao = new ProjectWsDao();

        Map<String, ProjectWrapper> idMap = new LinkedHashMap<>();

        APIProjects apiProjects = new APIProjects();
        APIProjectsSoap apiProjectsSoap = apiProjects.getAPIProjectsSoap12();
        ArrayOfProjectWrapper arrayOfProjectWrapper = null;

        arrayOfProjectWrapper = apiProjectsSoap.getSubprojectsDates(sessionId, mainParentProjectId);

        //Ручное добавление родительского проекта
        ProjectWrapper projectWrapper1 = projectWsDao.taskWrapper(sessionId, mainParentProjectId);
        projectWrapper1.setParentProjectId(null);

        idMap.put(mainParentProjectId, projectWrapper1);
        //Ручное добавление родительского проекта

        arrayOfProjectWrapper.getProjectWrapper().stream().forEach(pw -> {
            idMap.put(pw.getUID(), pw);
        });
        Set<String> idSet = idMap.keySet();

        Map<String, Project> projectMap = new LinkedHashMap<>();
        for (String pWrapper :
                idSet) {
            ProjectWrapper pw = idMap.get(pWrapper);
            Project project = new Project();

            String parentId = pw.getParentProjectId();
            project.setUID(pw.getUID());
            project.setParentProjectId(pw.getParentProjectId());
            project.setName(pw.getName());
            project.setOwnerId(pw.getOwnerId());
            project.setResponsibleId(pw.getResponsibleId());
            project.setPercentComplete((pw.getPercentComplete() != null) ? pw.getPercentComplete() : 0);
            project.setActualStartDate(pw.getActualStartDate());
            project.setActualEndDate(pw.getActualStartDate());
            project.setPlannedStartDate(pw.getPlannedStartDate());
            project.setPlannedEndDate(pw.getPlannedEndDate());
            project.setSystemStartDate(pw.getSystemStartDate());
            project.setSystemEndDate(pw.getSystemEndDate());
            project.setProjectWrapper(pw);
            project.setStatus((pw.getStatus() != null) ? pw.getStatus() : 0);
            if (parentId != null) {
                Project parentProject = projectMap.get(parentId);
                project.setParent(parentProject);
            }

            projectMap.put(pw.getUID(), project);

        }

        Set<Project> projectSet = rootProject.countLevel(projectMap);

        projectSet.forEach(project -> {
            if (!rootProject.projectStatusChecker(project)) //Фильтр по статусу проекта.
                // Отфильтровывает Закрытые, отмененные, отложенные
                rootProject.projectsList().add(project);
        });


       /* for (Project pw :
                rootProject.projectsList()) {
            if ("10216319-a4a2-4fc8-98ab-620a4d476e73".equals(pw.getParentProjectId()) || "8f47915f-a716-4ad9-9f35-f721e3752e2f".equals(pw.getParentProjectId())){  //Forecast, Outstaff
                System.out.println(pw.getUID() + " " + pw.getName() + " level: " + pw.getLevel() + " " + ((pw.getParent() != null) ? pw.getParent().getUID() : null));
            } else if(pw.getLevel() == 3){
                System.out.println(pw.getUID() + " " + pw.getName() + " level: " + pw.getLevel() + " " + ((pw.getParent() != null) ? pw.getParent().getUID() : null));
            }

        }*/

        return rootProject.projectsList();
    }

    public static void main(String[] args) {
        Project p = new Project();

        List<Project> s = p.buildAdvantaProjectHierarchy("4826bdc1-41c1-4f94-b15b-096236618adc");


        s.forEach(sw -> System.out.println(sw.getName() + " " + sw.getStatus() + " " + sw.getLevel()));
    }

    public Set<Project> countLevel(Map<String, Project> projectMap) { //Hierarchy level calculation
        Set<Project> projectSet = new LinkedHashSet<>(projectMap.values());
        AdvantaConfiguration advantaCfg = AdvantaConfiguration.getInstance();
        String CLOSED_PAYED_PROJECT_ID = null;
        try {
            CLOSED_PAYED_PROJECT_ID = advantaCfg.getClosedPayedProjectId();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        for (Project listRow :
                projectSet) {
            if (listRow.getParentProjectId() == null) {
                listRow.setLevel(0);
            } else if (listRow.getParentProjectId().equals(OUTSTAFF_ID) || listRow.getParentProjectId().equals(FORECAST_ID)) {
                listRow.setLevel(projectMap.get(listRow.getParentProjectId()).getLevel() + 2);
            } else if (listRow.getParentProjectId().equals(CLOSED_PAYED_PROJECT_ID)) {
                listRow.setLevel(projectMap.get(listRow.getParentProjectId()).getLevel() + 3);
            } else if (0 == projectMap.get(listRow.getParentProjectId()).getLevel()) {
                listRow.setLevel(1);
            } else if (listRow.getLevel() == -1) {
                listRow.setLevel(projectMap.get(listRow.getParentProjectId()).getLevel() + 1);
            }
        }
        return projectSet;
    }

    public Boolean projectStatusChecker(Project project) {
        Boolean flag = false;
        if (project.getStatus() == STATUS_CLOSED
                || project.getStatus() == STATUS_CANCELED
                || project.getStatus() == STATUS_IN_HOLD) {
            flag = true;
        }
        return flag;
    }

    public boolean findById(List<Project> projects, String uid) {
        Boolean flag = false;
        for (Project project :
                projects) {
            if (project.getUID() == uid) {
                flag = true;
            }
        }
        return flag;
    }
}
