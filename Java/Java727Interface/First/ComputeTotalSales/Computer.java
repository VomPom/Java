package WORK.Java.Java727Interface.First.ComputeTotalSales;

public class Computer implements ComputeTotalSales{
	private String name;
	private double money;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override 
	public double totalSalesByYear() {
		return money;
		
	}

}
