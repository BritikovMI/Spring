package ru.rbt.jetski;

import java.util.ResourceBundle;

import streamline.APIProjects;
import streamline.APIProjectsSoap;
import streamline.ArrayOfFilterWrapper;
import streamline.ArrayOfProjectWrapper;
import streamline.ArrayOfSortWrapper;
import streamline.AuthenticationResponse;
import streamline.FilterWrapper;
import streamline.LoginSoap;
import streamline.Login_Service;
import streamline.ProjectIdDataContract;
import streamline.ProjectWrapper;

public class TestAdvantaProjects {

    public static final String advantaUser = "BritikovMI";
    public static final String advantaPswd = "Profi2018";

    public static final void main(String[] args) {
        try {
//            ResourceBundle rb = ResourceBundle.getBundle("connection");
            Login_Service loginSrv = new Login_Service();
            LoginSoap loginSoap = loginSrv.getLoginSoap();
            AuthenticationResponse responce = loginSoap.authenticate(advantaUser, advantaPswd);
            String sessionId = responce.getASPNETSessionId();
            System.out.println(sessionId);

            APIProjects projectService = new APIProjects();
            APIProjectsSoap projectSoap = projectService.getAPIProjectsSoap();

//			FilterWrapper filter = new FilterWrapper();
//			filter.setField("name");
//			filter.setOperation();

            ArrayOfProjectWrapper prjWrapArray = projectSoap.getProjects(sessionId, new ArrayOfFilterWrapper(), new ArrayOfSortWrapper(), true);
            prjWrapArray.getProjectWrapper().stream().filter(prj -> prj.getName().equals("ТестЗаказ")).forEach(prj -> System.out.println(prj.getUID() + " : " + prj.getName()));

            ProjectIdDataContract prjId = new ProjectIdDataContract();
            prjId.setASPNETSessionId(sessionId);
            ProjectWrapper prjWrap = projectSoap.getProject(prjId);
//			prjWrap.get
            System.out.println(prjWrap.getProjectType());

        } finally {

        }
    }

}
