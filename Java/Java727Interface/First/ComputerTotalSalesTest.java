package WORK.Java.Java727Interface.First;

/**
 * Created by Julis on 17/7/27.
 * User:Julis 落叶挽歌
 * Date:17/7/27
 * Time:下午1:17
 */
public class ComputerTotalSalesTest {
    public static void main(String []args){
        Televison televison=new Televison();
        Computer computer=new Computer();
        Mobile mobile=new Mobile();
        ComputerTotalSales []computerTotalSales={computer,televison,mobile};
        Shop shop=new Shop();

        shop.computerTotalSales=computerTotalSales;

        System.out.println("Televison年销售额为:"+shop.computerTotalSales[0].totalSalesByYear());
        System.out.println("Computer年销售额为:"+shop.computerTotalSales[1].totalSalesByYear());
        System.out.println("Mobile年销售额为:"+shop.computerTotalSales[2].totalSalesByYear());
    }
}

class Televison implements ComputerTotalSales{
    @Override
    public double totalSalesByYear() {
        return 10000.00;
    }
}

class Computer implements ComputerTotalSales{
    @Override
    public double totalSalesByYear() {
        return 20000.00;
    }
}

class Mobile implements ComputerTotalSales{
    @Override
    public double totalSalesByYear() {
        return 30000.00;
    }
}



