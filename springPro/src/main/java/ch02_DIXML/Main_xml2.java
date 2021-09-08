package ch02_DIXML;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main_xml2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext factory = 
				new GenericXmlApplicationContext("classpath:di01/Container2.xml");
		System.out.println();
	}

}
