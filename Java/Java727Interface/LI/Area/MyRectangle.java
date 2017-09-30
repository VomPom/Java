package WORK.Java.Java727Interface.LI.Area;

public class MyRectangle implements Area {
	private double width;
	private double height;

	@Override
	public void calculatArea() {
		System.out.println("矩形的面积为："+width*height);
}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}