package session02.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import session02.bean.BeverageMachine;
import session02.bean.Coffee;
import session02.bean.Tea;
import session02.config.BeverageConfig;


//使用 java 配置在執行上要加上 VM 參數:--add-opens java.base/java.lang=ALL-UNNAMED
public class TestBeverage {
	
	public static void main(String[] args) {
		// 傳統作法
//		Coffee coffee = new Coffee();
//		Tea tea = new Tea();
//		BeverageMachine machine1 = new BeverageMachine(coffee);
//		BeverageMachine machine2 = new BeverageMachine();
//		machine2.setBeverage(tea);
//		System.out.println(machine1.serveBeverage());
//		System.out.println(machine2.serveBeverage());
		
		
		//spring 作法
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config3.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeverageConfig.class);
		BeverageMachine machine1 = ctx.getBean("coffeeBeverageMachine", BeverageMachine.class);
		System.out.println(machine1.serveBeverage());
		BeverageMachine machine2 = ctx.getBean("teaBeverageMachine", BeverageMachine.class);
		System.out.println(machine2.serveBeverage());
		
		
	}

}
