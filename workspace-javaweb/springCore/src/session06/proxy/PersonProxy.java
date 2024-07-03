package session06.proxy;

import java.util.concurrent.ExecutionException;

public class PersonProxy implements Person{
	
	//代理對象
	private Person person;
	
	//建構子注入
	public PersonProxy (Person person) {
		this.person = person;
	}

	@Override
	public void work() {
		
		//before:公用邏輯
		System.out.println("Put on Masks");
		
		try {
			//執行代理對象的業務方法
			person.work();
		}catch(Exception e) {
			//exception : 公用邏輯
			System.out.println("error occur, 紀錄 log");
		}

		
		//end:公用邏輯
		System.out.println("Wash your fucking hands.");
	}

}
