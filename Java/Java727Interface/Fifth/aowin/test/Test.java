package WORK.Java.Java727Interface.Fifth.aowin.test;

import WORK.Java.Java727Interface.Fifth.aowin.define.Computer;
import WORK.Java.Java727Interface.Fifth.aowin.define.Input;
import WORK.Java.Java727Interface.Fifth.aowin.define.Mouse;
import WORK.Java.Java727Interface.Fifth.aowin.define.Usb;

public class Test {
	public static void main(String[] args) {
		Usb u = new Mouse();
		String version = Usb.VERSION;
		System.out.println("usb的版本号："+version);
		u.link();
		//接口中静态方法的调用
		Usb.chargeEle();
		//调用default方法
		System.out.println("-----------");
		u.linkU();
		System.out.println("---------");
		
		
		Computer c = new Computer();
		Usb mouse = new Mouse();
		c.linkUsb(mouse);
		Input i = (Input) mouse;//类型强制转换
		c.input(i, "今天学习了接口的使用");
		
		
	}

}
