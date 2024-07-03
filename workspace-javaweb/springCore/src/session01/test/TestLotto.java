package session01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import session01.bean.Hello;
import session01.bean.Lotto;

public class TestLotto {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
		//因為 scope = prototype, 所以會實現多例而非預設的singleton(建出很多個 bean)
		Lotto lotto1 = ctx.getBean("lotto", Lotto.class); // 指定 id
		System.out.println(lotto1.getNumbers());
		Lotto lotto2 = ctx.getBean("lotto", Lotto.class);
		System.out.println(lotto2.getNumbers());
	}

}
