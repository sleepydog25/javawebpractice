package session04.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import session04.bean.ComboMeal;

public class FoodTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("food.xml");
		ComboMeal comboMeal = ctx.getBean("comboMeal", ComboMeal.class);
		System.out.println(comboMeal.serveMeal());
		comboMeal.serveMeal();
		
	}

}
