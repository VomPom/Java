package WORK.Java.Java727Interface.First.ComputeTotalSales;

public class Shop {
	private ComputeTotalSales[] computeTotalSales;

	public ComputeTotalSales[] getComputeTotalSales() {
		return computeTotalSales;
	}

	public void setComputeTotalSales(ComputeTotalSales[] computeTotalSales) {
		this.computeTotalSales = computeTotalSales;
	}
	public void print() {
		double sum=0;
//		for(ComputeTotalSales s:computeTotalSales) {
//			sum+=s.totalSalesByYear();
//			//sum+=s.getMoney();这里为什么不可以调用getMoney
//			}
			Television television= (Television) computeTotalSales[0];
			Computer computer=(Computer)computeTotalSales[1];
			Mobile mobile=(Mobile)computeTotalSales[2];
			sum+=mobile.getMoney()+television.getMoney()+computer.getMoney();

		System.out.println("商店销售额为 "+sum);
			
	}
	
	

}
