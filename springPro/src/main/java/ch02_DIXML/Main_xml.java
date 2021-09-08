package ch02_DIXML;

import org.springframework.context.support.GenericXmlApplicationContext;

import di01.Greeter;

public class Main_xml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext factory = 
				new GenericXmlApplicationContext("classpath:di01/Container1.xml");
		Greeter g1 = factory.getBean("greeter", Greeter.class);
		Greeter g2 = factory.getBean("greeter", Greeter.class);
		System.out.println();
		System.out.println("g1과 g2는 같은 객체 ? " + (g1 == g2)); //true
		System.out.println();
		System.out.println("greet 실행");
		System.out.println(g1.greet("Spring"));
	}

}
