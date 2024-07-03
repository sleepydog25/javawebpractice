package session06.dyn_proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyPrintArgsAspect {
	
	public static void before(Method method, Object[]args) {
		System.out.printf("方法名稱:%s 參數:%s%n",method.getName(),Arrays.toString(args));
	}

}
