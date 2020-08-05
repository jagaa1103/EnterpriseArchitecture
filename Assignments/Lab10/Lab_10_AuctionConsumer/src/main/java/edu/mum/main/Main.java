package edu.mum.main;
//
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

	private final static String[] configFilesLab10 = {
			"/spring/common.xml",
	 		"/spring/amqp-item-app-context.xml",
			"/spring/jms-queue-app-context.xml",
			"/spring/item-app-context.xml"
		};
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("    Loading Lab 10 Consumer ...");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFilesLab10, Main.class);
		System.out.println("    Waiting ...");
	}
}
