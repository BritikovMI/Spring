/**
 * 
 */
package ru.rbt.jetski;

import java.util.ResourceBundle;

import streamline.AuthenticationResponse;
import streamline.LoginSoap;
import streamline.Login_Service;

/**
 * @author sotnik
 *
 */
public class TestAdvantaLogin {

	public static final String advantaUser = "BritikovMI";
	public static final String advantaPswd = "Profi2018";

	public static final void main(String [] args) {
		try {
//			ResourceBundle rb = ResourceBundle.getBundle("connection");
			Login_Service loginSrv = new Login_Service();
			LoginSoap loginSoap = loginSrv.getLoginSoap();
			AuthenticationResponse responce = loginSoap.authenticate(advantaUser, advantaPswd);
			String sessionId = responce.getASPNETSessionId();
			System.out.println(sessionId);
		} finally {
			
		}
	}
	
}
