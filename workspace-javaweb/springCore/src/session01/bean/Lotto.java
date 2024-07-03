package session01.bean;

import java.util.LinkedHashSet;

import java.util.Random;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Lotto {
	private Set<Integer> numbers;
	
	public Lotto() {
		System.out.println("Lotto 建構子");
		//自動產生1-39不重複的號碼 5 個 (今彩539)
		Random random = new Random();
		numbers = new LinkedHashSet<>();
		while (numbers.size() <5) {
			int number = random.nextInt(39) +1;
			numbers.add(number);// 自動去除重複
		}
		
	}
	public Set<Integer> getNumbers(){
		return numbers;
	}
	

}
