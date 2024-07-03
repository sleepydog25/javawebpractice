package session01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import session01.bean.Hello;

public class TestHello {
	
	public static void main(String[] args) {
//		//傳統:自行建立物件，沒有使用可能會造成系統很大的負擔
//		Hello hello1 = new Hello();
//		System.out.println(hello1.getToday());
		
		//使用 spring 來管理物件: 利用 Ioc 技術來建立物件 
		//配置文件: conf/beans-config.xml
		//spring 會根據配置文件的設定來自動建立 bean 實體
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
//		Hello hello1 = ctx.getBean(Hello.class); // 自行去找實踐 Hello.class 的 bean
//		System.out.println(hello1.getToday());
//		Hello hello2 = ctx.getBean(Hello.class);
//		System.out.println(hello2.getToday());
//		System.out.println(hello1 == hello2);
		
		Hello hello1 = ctx.getBean("hello", Hello.class); // 指定 id
		Hello hello2 = ctx.getBean("hello2", Hello.class); // 指定 id
		System.out.println(hello1.getToday());
		System.out.println(hello2.getToday());
		System.out.println(hello1 == hello2);
	}

}
