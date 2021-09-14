package ch02_DIXML;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.context.support.GenericXmlApplicationContext;

import di03.AuthException;
import di03.AuthFailLogger;
import di03.AuthenticationService;
import di03.PasswordChangeService;
import di03.UserNotFoundException;

public class Main_xml3 {
	static GenericXmlApplicationContext ctx;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ctx = new GenericXmlApplicationContext("classpath:di03/Container3.xml");
		PasswordChangeService pcw = (PasswordChangeService) ctx.getBean("pwChangeSvc");
		System.out.println(pcw);
		
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1111");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "11111");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "111111");
		try {
			authSvc.authenticate("bkchoi2", "1111");
		} catch (UserNotFoundException ex) {
		}
		authSvc.authenticate("bkchoi", "1234");
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1234");
		authSvc.authenticate("bkchoi", "5678");
		ctx.close();
	}
	
	private static void runAuthAndCatchAuthEx(AuthenticationService authSvc, String userId, String password) {
		try {
			authSvc.authenticate(userId, password);
		} catch (AuthException ex) {
		}
	}
}