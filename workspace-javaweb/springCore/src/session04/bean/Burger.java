package session04.bean;

import org.springframework.stereotype.Component;

@Component("burger")
public class Burger implements FoodItem{
	
	@Override
	public String serve() {
		return "fish";
	}

}
