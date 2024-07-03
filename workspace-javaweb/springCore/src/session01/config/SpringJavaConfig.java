package session01.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
//SpringJavaConfig 是一個傳統 .xml 配置的替代品

import session01.bean.Hello;
import session01.bean.Lotto;

@Configuration
public class SpringJavaConfig {
	
	@Bean(name = "hello") // name 相當於 id
	@Scope("singleton") // 預設, 可以不寫
	public Hello getHello() {
		Hello hello = new Hello();
		return hello;
	}
	
	@Bean(name="lotto")
	@Scope("prototype")
	public Lotto getLotto() {
		Lotto lotto = new Lotto();
		return lotto;
	}
	
}
