package ch02_DIXML;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import di01.AlreadyMemberException;
import di01.ChangePasswordService;
import di01.IdPasswordNotMatchingException;
import di01.Member;
import di01.MemberNotFoundException;
import di01.MemberRegisterService;
import di01.RegisterRequest;

public class Main_xml2 {
	static GenericXmlApplicationContext ctx;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ctx = new GenericXmlApplicationContext("classpath:di01/Container2.xml");
		System.out.println();
		Scanner reader = new Scanner(System.in);

		while (true) {
			System.out.print("명령어를 입력하세요: ");
			String command = reader.nextLine();

			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}else if (command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			}else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
		}
	}

	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp(); return;
		}
		ChangePasswordService changePwdSvc = 
				ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
		changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
		System.out.println("암호를 변경 하였습니다.");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.\n");
		}
		System.out.println(changePwdSvc.getDao().selectAll());
	}
	
	public static void processNewCommand(String[] arg) {
		if (arg.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);

		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);

		if (!arg[3].equals(arg[4])) {
			System.out.println("패스워드 확인 안됨");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록 했습니다");

		} catch (AlreadyMemberException e) {
			System.out.println("이미 존재하는 이메일 입니다");
		}
	}

	public static void printHelp() {
		System.out.println("\n잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
		System.out.println("명령어 사용법 : new 이메일 이름 암호 암호확인");
	}
	
}
