package ch01_sample;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp_Di {
		static Message bean;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext factory = 
				new GenericXmlApplicationContext("classpath:ch01_sample/bean.xml");
		bean = factory.getBean("aaa", Message.class);
		bean.sayHello("Spring");
		bean = factory.getBean("bbb", Message.class);
		bean.sayHello("Spring");
	}

}
