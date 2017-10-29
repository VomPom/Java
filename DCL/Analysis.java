package DCL;

import DCL.util.RUtils;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class Analysis {
    public static void main(String[]args){


    }
    /**
     *  单因子正态性检验
     */

    public static void NormalTest(){
        String url="/Users/mac/Desktop/Java/JavaWorking/src/DCL/rData/analysis/data/CBD.csv";
        Rengine engine= RUtils.loadR("analysis/单因子正态性检验.txt");
        REXP rexp = engine.eval("myfunnormaltest(\""+url+"\")");
        System.out.println(rexp);
    }
    /**
     *  各水平重复次数，alpha为置信度，effect=0表示固定效应，effect=1表示随机效应
     * @param m
     * @param alpha
     * @param effect
     */
    public static void CBDAnalysis(int m, double alpha,int effect){

        String url="/Users/mac/Desktop/Java/JavaWorking/src/DCL/rData/analysis/data/CBD.csv";
        Rengine engine= RUtils.loadR("analysis/CBD方差分析.txt");
        REXP rexp = engine.eval("myfunBlockVarAnalysis(\""+url+"\","+m+","+alpha+","+effect+")");
        System.out.println(rexp);
    }



    /**
     * BIBD方差分析
     * @param effect effect中1为随机效应，0为固定效应
     */
    public static void BIBDAnalysis(int effect){

        Rengine engine= RUtils.loadR("analysis/BIBD方差分析.txt");
        REXP rexp = engine.eval("myfunBIBD("+effect+")");
        System.out.println(rexp);
       //RUtils.printRreturnData(rexp);
    }
}
