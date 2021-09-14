package ch03_mainAOP;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di05.WriteImpl;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch03_AOPXmlAnno/aop.xml");
		
		WriteImpl bean = ctx.getBean("write",WriteImpl.class);
		bean.write();
	}

}
