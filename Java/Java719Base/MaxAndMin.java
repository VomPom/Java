package WORK.Java.Java719Base;

/**
 * Created by Julis on 17/7/19.
 * User:Julis 落叶挽歌
 * Date:17/7/19
 * Time:下午3:51
 */
public class MaxAndMin {
    private static final int SIZE_OF_ARRAY =10;
    private static int Max(int[] array){
        int max = array[0];
        for(int i=0;i<=array.length-1;i++){
            max=max>array[i]?max:array[i];
        }
        return max;
    }
    private static int Min(int[] array){
        int min = array[0];
        for(int i=0;i<=array.length-1;i++){
            min=min<array[i]?min:array[i];
        }
        return min;
    }
    public static void main(String []args){

        int []array=new int[SIZE_OF_ARRAY];
        System.out.println("数组对元素为:");
        for(int i=0;i<SIZE_OF_ARRAY;i++){//装填数组,这里产生随机数
            array[i]=(int)(Math.random()*100);
            System.out.print(array[i]+" ");
        }
        System.out.println("\n最大值为:"+Max(array));
        System.out.println("最小值为:"+Min(array));
    }
}




