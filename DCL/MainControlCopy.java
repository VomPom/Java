package DCL;

import DCL.bean.MixLeavelData;
import DCL.util.ExcelUtils;
import DCL.util.RUtils;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.RVector;
import org.rosuda.JRI.Rengine;


/**
 *
 * Created by Julis on 17/8/5.
 * User:Julis 落叶挽歌
 * Date:17/8/5
 * Time:下午2:56
 */

public class MainControlCopy {
    public static void main(String []args){

//         mainJudge();
//        mixture(3,2);
        constrmixture();
}
    /**
     * 主判断程序主要根据对vkb等相关参数
     */

    public static void mainJudge(){
         int b=1;//区组数
         int []ki={3,1,2,3};//每个区的数
         int k=minOfK(ki);//每个区的最小的容纳水平数
         /**
         *  f1 f2 f3  相关数据设计
         */
         int []viF1={3,3,3,2,2};//f1     每个因子的水平
         int v=viF1[0];//水平数   单因子的话 就一个,多因子 v1 v2 v3 f1

         int f1=viF1.length;  //可控因子水平个数
         int []viF2={}; //噪声因子的水平数目 f2 每个因子的水平
         int []viF3={}; //信号因子的水平数目 f3 每个因子的水平
         int f3=viF3.length;    //信号因子个数
         int f2=viF2.length+f3; //噪声因子个数
         double[]range=new double[]{200,50,30,10,1.66,0.58,0.7,0.3,2.5,-2.5};


         int l=0;   //随机效应
         int lamda=0;   //相遇数
         int cost=1;    //成本
         int []qi={1,0,1,0,0};  //定性1 定量0 和vi'的个数相对应
         int z=0;   //是否可以综合噪声 0没综合
         int n=21;  //根据实验条件获取
         int j=0;   //交互作用的类型
         int f=f1+f2+f3;    //总因子数
         int m=v/b;
         int regressionType=1;  //1代表 一次回归分析,2代表 2次分析,
         int t=0;   //数据特性   0 望目 －1 望小 1望大

        /*碰到定性离散化
        范围A-B
        定性的最小的水平数：m
        */

//        int A=0,B=0;
//        switch(m){
//            case 2:
//                break;
//            case 3:
//                int q1=A+(B-A)/4;
//                int q2=A+(B-A)/4;
//                int q3=A+(B-A)/4;
//                break;
//            case 4:
//                break;
//        }



        switch (cost){
            case 0:
            case 1:
                break;
            case 2:
                //均匀设计
                break;

        }
         if(f1 == 1) {//单因子
             if (m >= 2) {
                System.out.println("链式法则");
                chainArea(n,b,v,k);
                return;
            }
         /**
          * 链式法则
          */
            if (k == v) {
                CBD(b,v);
                return;
            }
            if (b >= v) {
                int rInt=(b * k) / v;//处理的重复数
                int rJudge = (b * k) % v;
                if (rJudge == 0) {
                    lamda = (rInt * (k - 1)) % (v - 1);
                    if (lamda == 0) {
                        blockDesignMatrix(v,k,b);
                        return;
                    }
                }
            }
            CBD(b,v);
            return;
        }else if(f1 >= 2){//多因子

             if(f1>7) {
                System.out.println("筛选代码块");    //饱和设计
                saturationDesign(f1);
                return;
            }

            if(f2>0){
                System.out.println("参数设计");
                if(f3>0){
                    System.out.println("动态设计");
                    parameterDesign(f1,viF1[0],f2,viF2[0]);//一般参数设计
                    return;
                }
                if(z==1){
                    System.out.println("综合噪声");
                    syntheticNoise(f1,v);//综合噪声
                    return;
                }
                    System.out.println("一般参数设计");
                    parameterDesign(f1,viF1[0],f2,viF2[0]);//一般参数设计
                    return;
            }

            System.out.println("成本分析"); //人工处理
            System.out.println("时间和金钱成本");
                if(maxOfQi(qi)>0){    //有定性因子
                    System.out.println("正交设计");
                    if(isEqualOfVi(viF1)){    //因子水平数相等
                        System.out.println("等水平");
                        orthogonal(j,v,f1,cost);//标准正交表
                        return;
                    }
                    //因子水平数不相等==>混合水平
                        System.out.println("混合水平");
                        mixLeavel(viF1);  //混合水平
                        return;
                }
                    System.out.println("回归分析");
                    switch (regressionType){
                        case 1:
                            regressionAnalysisOnce(m, f1, range);
                            break;
                        case 2:
                            regressionAnalysisTwice(m,f1);
                            break;
                        default:
                            System.out.println("Not Found");
                            break;
                    }
                    return;
            }
        }


    public static void constrmixture(){

//        Rengine engine=RUtils.loadR("constrmixture.R");
//        String  order="constrmixture1("+"c(0,0.8,0.1,0.95, 0.05,0.50)"+","+2+","+3+","+2+")";
//        System.out.println(order);
//        REXP rexp = engine.eval(order);
//        System.out.println(rexp);
//        RUtils.printRreturnData(rexp);

//
//        Rengine engine=RUtils.loadR("constrmixture.R");
//        String  order="constrmixture3("+"c(0,0.8,0.1,0.95, 0.05,0.50)"+","+2+","+3+","+2+","+2+")";
//        System.out.println(order);
//        REXP rexp = engine.eval(order);
//        System.out.println(rexp);
//        RUtils.printREAL(rexp);



        Rengine engine=RUtils.loadR("constrmixture.R");
        String  order="constrmixture3("+"c(0,0.8,0.1,0.95, 0.05,0.50)"+","+2+","+3+","+2+","+2+")";
        System.out.println(order);
        REXP rexp = engine.eval(order);
        System.out.println(rexp);
        RUtils.printREAL(rexp);
    }
    public static void mixture(int k,int q){


        Rengine engine=RUtils.loadR("mixture.R");
//        RVector vector=new RVector();
//        vector.add(0.2);
//        vector.add(0.2);
//        vector.add(0.2);
//        String  order="lowergriddesign("+k+","+q+",c(0.2, 0.2, 0.2)"+")";
//        System.out.println(order);
//        REXP rexp = engine.eval(order);
//        RUtils.printREAL(rexp);



    }

    /**
     * 赋闲列
     * @param countOfF2 2水平因子个数
     * @param countOfF3 3水平因子个数
     */

    public static void idleColcum(int countOfF2,int countOfF3){
        Rengine engine=RUtils.loadR("idleColcum.R");
        String  order="myfunfx("+countOfF2+","+countOfF3+")";
        REXP rexp = engine.eval(order);
        RUtils.printRreturnData(rexp);
    }
    /**
     * 二次回归分析
     * @param m 重复试验次数
     * @param f1 因子个数
     */
    public static void regressionAnalysisTwice(int m,int f1){

        Rengine engine=RUtils.loadR("regressionAnalysisTwice.R");

        String  order="myfun("+m+","+f1+")";
        REXP rexp = engine.eval(order);

       RUtils.printRegressionAnalysisData(rexp,new double[]{});

    }
    /**
     * 一次回归分析
     * @param m 重复试验次数
     * @param f1 因子个数
     * @param range 取值范围
     */
    public static void regressionAnalysisOnce(int m,int f1,double[]range){

        Rengine engine=RUtils.loadR("regressionAnalysis.R");
        engine.assign("c2",range);
        String  order="myfun("+m+","+f1+",c2)";
        REXP rexp = engine.eval(order);


        RUtils.printRegressionAnalysisData(rexp,range);

    }
    /**
     * 综合噪声
     * @param f1
     * @param v
     */
    public static void syntheticNoise(int f1,int v){
        Rengine engine=RUtils.loadR("syntheticNoise.R");
        String  order="myfunzh("+f1+","+v+")";
        REXP rexp = engine.eval(order);
        RUtils.printRreturnData(rexp);
    }
    /**
     * 一般参数设计
     *
     */
    public static void  parameterDesign(int f1,int v1,int f2,int v2){

        Rengine engine=RUtils.loadR("parameterDesign.R");
        String order="myfuncs("+f1+","+v1+","+f2+","+v2+")";
        REXP rexp = engine.eval(order);

        RUtils.printRreturnData(rexp);
    }
    /**
     *  完全不平衡区组设计矩阵表
     * @param v
     * @param k
     * @param b
     */
    public static void blockDesignMatrix(int v,int k,int b)  {
        ExcelUtils.printVKBDesign(v,k,b);
    }
    /**
     * 正交设计
     * @param f1 可控因子个数
     * @param v 水平数
     * @param j 交互作用类型 分为 0 1 2 3
     */
    public static void orthogonal(int j,int v,int f1,int cost){
        Rengine engine=RUtils.loadR("Orthogonal.R");
        REXP rexp=null;

        if(cost==1){
            rexp=engine.eval("myfunzj("+j+","+v+","+f1+")");
        }else{
            rexp=engine.eval("myfunzj1("+j+","+v+","+f1+")");
        }

        RUtils.printRreturnData(rexp);
    }
    /**
     * 饱和设计
     * @param f1
     */
    public static void saturationDesign(int f1){
        Rengine engine=RUtils.loadR("SaturationDesign.R");
        String order=null;
        if(f1<12){
            order="myfun12("+f1+")";
        }else if(f1>=12&&f1<20){
            order="myfun20("+f1+")";
        }else if(f1>=20&&f1<28){
            order="myfun28("+f1+")";
        }else if(f1>=28&&f1<32){
            order="myfun32("+f1+")";
        }else{
            System.out.println("大于32个水平");
        }
        REXP rexp = engine.eval(order);
        //System.out.println(rexp);
        RUtils.printRreturnData(rexp);
    }
    /**
     * 混合水平
     * @param vi 各个因子的水平数组
     */
    public static void mixLeavel(int []vi){
        int []leavelCount=leavelJudge(vi);//获取到各个水平的数量
        int twoLeavelsPostion=leavelCount[2]-1;//二水平数组索引
        int threeLeavelsPostion=leavelCount[3]-1;//三水平数组索引
        System.out.println(twoLeavelsPostion+"  "+threeLeavelsPostion);
         int TYPE_OF_MIXLEAVE=MixLeavelData.table[threeLeavelsPostion][twoLeavelsPostion];//获取判断的类型

        switch (TYPE_OF_MIXLEAVE){
            case 0:
                System.out.println("没有此方法");
                break;
            case 1:
                System.out.println("拟水平方法");
                pseudoHorizontal(vi);//拟水平法
                break;
            case 2:
                System.out.println("赋闲列方法");
                idleColcum(leavelCount[2],leavelCount[3]);//赋闲列方法
                break;
            case 3:
                System.out.println("原表不变");
                pseudo2137(leavelCount[2]+leavelCount[3],leavelCount[3]);
                break;
            default:
                System.out.println("混合设计不存在的选项");
                break;
        }

    }
    /**
     * 调用拟水平方法
     * @param vi
     */
    public static void pseudoHorizontal(int []vi){
        String order="";
        Rengine engine=RUtils.loadR("pesudoHorizontal.R");
        int leavelCount[]=leavelJudge(vi);
        if(leavelCount[2]!=0){
            order="myfundesnsp("+leavelCount[2]+",2,"+leavelCount[3]+",3)";
        }else{
            order="myfundesnsp("+leavelCount[3]+",3,"+leavelCount[4]+",4)";
        }
        REXP rexp = engine.eval(order);

        RUtils.printRreturnData(rexp);
    }
    /**
     * 调用 2137
     *
     * @param f1
     * @param f2
     */
    public static void pseudo2137(int f1,int f2){
        Rengine engine=RUtils.loadR("2137.R");
        // 直接调用无参的函数，将结果保存到一个对象中
        String order="myfundesnsp1("+f1+","+f2+")";
        REXP rexp = engine.eval(order);
        RUtils.printRreturnData(rexp);


    }
    /**
     * 调用CBD方法
     * @param b 区组数
     * @param v 因子个数
     */
    public static void CBD(int b,int v){
        Rengine engine=RUtils.loadR("CBD.R");
        // 直接调用无参的函数，将结果保存到一个对象中
        String order="myfunbd("+b+","+v+")";
        REXP rexp = engine.eval(order);
        RUtils.printRreturnData(rexp);
    }
    /**
     * 链式设计方案
     * @param n 可容纳的最大次数
     * @param b 区组数
     * @param v 水平数
     * @param k 最小的...
     */
    public static void chainArea(int n,int b,int v,int k) {

        int g=(b*k-v)/b; // 每个小组容纳的个数
        System.out.println("k="+k);
        System.out.println("b="+b);
        System.out.println("n="+n);
        System.out.println("v="+v);
        System.out.println("g="+g);
        if(g<=v/2&&g>1){

            int[][] number = new int[b][g];
            int num = 0;
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < g; j++)
                    number[i][j] = ++num;
            }

            for (int j = 0; j < g; j++) {
                for (int i = 0; i < b; i++)
                    System.out.print(String.format("%-4d",number[i][j]));
                 System.out.println();
            }
            for (int j = 0; j < g; j++) {
                for (int i = 1; i < b; i++)
                    System.out.print(String.format("%-4d",number[i][j]));
                System.out.print(String.format("%-4d",number[0][j]));
                System.out.println();
            }
            int count=1;
            for(int i=g*b+1;i<=v;i++,count++){
                System.out.print(String.format("%-4d",i));
                if(count%b==0){
                    System.out.println();
                }
            }
        }else{
            System.out.println("不能做实验");
        }

    }
    /**
     * 判断 2 3 4 5 因子水平的个数
     * @param vi 因子水平数
     * @return
     */
    public static int []leavelJudge(int []vi){
        int []leavelJudge=new int[6];// 为方便记忆,设因子个数数组索引以水平数目作为索引
        for(int i=0;i<leavelJudge.length;i++)
            leavelJudge[i]=0;
        for(int i=0;i<vi.length;i++){
            switch (vi[i]){
                case 2:
                    leavelJudge[2]++;
                    break;
                case 3:
                    leavelJudge[3]++;
                    break;
                case 4:
                    leavelJudge[4]++;
                    break;
                case 5:
                    leavelJudge[5]++;
                    break;
            }

        }
        return leavelJudge;
    }
    /**
     * 找Ki的最小值
     * @param k
     * @return
     */
    public static int minOfK(int []k){
        int min=k[0];
        for(int i=0;i<k.length;i++)
            if (k[i]<min)
                min=k[i];
        return min;
    }

    /**
     * 找qi的最大值
     * @param k
     * @return
     */
    public static int maxOfQi(int []k){
        int max=k[0];
        for(int i=0;i<k.length;i++)
            if (k[i]>max)
                max=k[i];
        return max;
    }
    /**
     * 判断是否是等因子
     * @param vi
     * @return
     */
    public static boolean isEqualOfVi(int []vi){
        int temp=vi[0];
        boolean flag=true;
        for(int i=1;i<vi.length;i++){
            if(temp!=vi[i]){
                flag=false;
                return flag;
            }
        }
        return flag;
    }
}










