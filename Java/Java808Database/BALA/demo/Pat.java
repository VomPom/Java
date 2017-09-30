package WORK.Java.Java808Database.BALA.demo;

public class Pat {

	private String name;
	private String color;
	private double price;
	
	
	public Pat() {
		super();
	}
	public Pat(String name, String color, double price) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Pat [name=" + name + ", color=" + color + ", price=" + price + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
