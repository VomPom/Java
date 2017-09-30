package WORK.Java.Java727Interface.First.ComputeTotalSales;

public class Test {

	public static void main(String[] args) {
		Television t=new Television();
		t.setName("电视");
		t.setMoney(100000);
		
		Computer c=new Computer();
		c.setName("电脑");
		c.setMoney(500000);
		
		Mobile m=new Mobile();
		m.setName("电话");
		m.setMoney(100000);
		
		System.out.println(t.getName()+" "+t.totalSalesByYear());
		System.out.println(c.getName()+" "+c.totalSalesByYear());
		System.out.println(m.getName()+" "+m.totalSalesByYear());
		Shop s=new Shop();
		s.setComputeTotalSales(new ComputeTotalSales[] {t,c,m});
		s.print();
	}
}
