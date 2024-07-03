package session02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import session02.bean.Beverage;
import session02.bean.BeverageMachine;
import session02.bean.Coffee;
import session02.bean.Tea;

//飲料配置
@Configuration
public class BeverageConfig {
	
	//方法名稱和name相同，名字可省略不寫
	//@Bean(name = "coffee")
	@Bean
	public Beverage coffee() {
		return new Coffee();
	}
	
	@Bean
	public Beverage tea() {
		return new Tea();
	}
	
	@Bean
	public BeverageMachine coffeeBeverageMachine() {
		BeverageMachine machine = new BeverageMachine(coffee());
		return machine;
	}
	
	@Bean
	public BeverageMachine teaBeverageMachine() {
		BeverageMachine machine = new BeverageMachine(tea());
		return machine;
	}
	

}
