package WORK.Java.Java727Interface.Fifth.aowin.define;

public class Mouse implements Usb,Input{

	@Override
	public void link() {
		System.out.println("连接鼠标设备");
	}
	
	//重写 父类的default方法
	@Override
	public void linkU() {
		//Usb.super.linkU();//调用Usb接口中的父类方法
		Input.super.linkU();//调用Input接口中的父类方法
		System.out.println("鼠标不是一个u盘");
	}
	
	//这个方法是类本身的方法 跟接口无关
	public static void chargeEle(){
		System.out.println("鼠标不用充电的");
	}

	@Override
	public void input(String str) {
		System.out.println("鼠标复制了内容："+str);
		
	}
}
