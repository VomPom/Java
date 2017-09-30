package WORK.Java.Java725Construction;

/**
 * Created by Julis on 17/7/25.
 * User:Julis 落叶挽歌
 * Date:17/7/25
 * Time:下午1:30
 */
public class Goods {

    private int id;
    private String name;
    private double price;
    public Goods [] goodses;
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setGoodses(Goods[] goodses) {
        this.goodses = goodses;
    }


    public void mostCheapest(){
        double min=goodses[0].price;
        int flag=0;
        for(int i=1;i<this.goodses.length;i++){
            if(goodses[i].price<min){
                min=goodses[i].price;
                flag=i;
            }
        }
        System.out.println("最便宜的商品为:"+goodses[flag].name+"价格为:"+goodses[flag].price);
    }


}



