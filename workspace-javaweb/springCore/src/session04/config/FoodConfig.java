package session04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import session04.bean.Burger;
import session04.bean.Coke;
import session04.bean.ComboMeal;
import session04.bean.Fries;

@Component
public class FoodConfig {
	
	@Bean
	public Burger burger() {
	    return new Burger()	;
	}
	
	@Bean
	public Coke coke() {
	    return new Coke();
	}
	@Bean
	public Fries fries() {
		return new Fries();
	}
	
	@Bean 
	public ComboMeal combomeal() {
		return new ComboMeal(burger(), coke(), fries());
	}
	

}
