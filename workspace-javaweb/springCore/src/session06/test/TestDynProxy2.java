package session06.test;

import session06.dyn_proxy.Calc;
import session06.dyn_proxy.CalcImpl;
import session06.dyn_proxy.DynProxy;

public class TestDynProxy2 {
	public static void main(String args[]) {
		Calc calc = (Calc)new DynProxy (new CalcImpl()).getProxy();
		//pointCut(切點) => session06.dyn_proxy.CalcImpl.add(int x,int y)
		//pointCut(切點) => session06.dyn_proxy.CalcImpl.*(int x,int y)
		//joinPoint(連接點) => add() 方法
		//切點對應遇到連接點 => 縫合
		calc.add(10,20);
		calc.div(10,20);
	}

}
