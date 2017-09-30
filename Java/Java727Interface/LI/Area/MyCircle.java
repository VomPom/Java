package WORK.Java.Java727Interface.LI.Area;

public class MyCircle implements Area {
	private double r;
	@Override
	public void calculatArea() {
		System.out.println("圆的面积为："+Math.PI*r*r);
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}

}
