package ru.rbt.jetski.advanta;

import ru.rbt.jetski.advanta.ws.login.AuthenticationResponse;
import ru.rbt.jetski.advanta.ws.login.LoginSoap;
import ru.rbt.jetski.advanta.ws.login.Login_Service;

public class AdvantaAccess {

	public String initSession(String login, String pswd) {
		Login_Service loginService = new Login_Service();
		LoginSoap loginSoap12 = loginService.getLoginSoap12();
		AuthenticationResponse authenticate = loginSoap12.authenticate(login, pswd);
		String aspnetSessionId = authenticate.getASPNETSessionId();
		System.out.println("aspnetSessionId = " + aspnetSessionId);
		return aspnetSessionId;
	}

}
