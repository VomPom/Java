package WORK.Java.Java725Construction;

/**
 * Created by Julis on 17/7/25.
 * User:Julis 落叶挽歌
 * Date:17/7/25
 * Time:下午1:32
 */
public class GoodTest {
    public static void main(String []args){
        int [] id ={123,12,34,1234,234};
        String []goodName={"香蕉","橘子","苹果","葡萄","荔枝"};
        double []price={12.8,7.0,7.6,5.7,12.9};
        Goods goods=new Goods();
        Goods []goodses=new Goods[5];
        for(int i=0;i<goodName.length;i++){
            goodses[i]=new Goods();
            goodses[i].setId(id[i]);
            goodses[i].setName(goodName[i]);
            goodses[i].setPrice(price[i]);
            System.out.println("添加商品成功:\n"+"ID="+id[i]+"  名字:"+goodName[i]+"  价格为:"+price[i]);
        }
        goods.setGoodses(goodses);
        goods.mostCheapest();

    }
}
