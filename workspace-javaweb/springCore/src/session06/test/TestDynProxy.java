package session06.test;

import session06.dyn_proxy.Calc;
import session06.dyn_proxy.CalcImpl;
import session06.dyn_proxy.DynProxy;
import session06.proxy.Man;
import session06.proxy.Person;
import session06.proxy.Woman;

public class TestDynProxy {
	
	public static void main(String args[]) {
		Calc calc = (Calc)new DynProxy(new CalcImpl()).getProxy();
		System.out.println(calc.add(20,5));
		System.out.println(calc.div(10,5));
		
		Person man =(Person) new DynProxy(new Man()).getProxy();
		man.work();
		
		Person woman =(Person) new DynProxy(new Woman()).getProxy();
		woman.work();
	}

}
