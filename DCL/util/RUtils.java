package DCL.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.rosuda.JRI.*;

import java.io.*;

/**
 * Created by Julis on 17/8/26.
 * User:Julis 落叶挽歌
 * Date:17/8/26
 * Time:下午9:22
 */
public class RUtils {
    /**
     * 打印回归分析的结果
     * 这里的打印结果和其他的打印有差异,所以这里单独罗列输出结构
     * @param rexp
     */
    public static void printRegressionAnalysisData(REXP rexp,double[]range){

        /**
         * 读取返回结果,并转换为java数据结构
         */
        RList list = rexp.asList();
        // 解析rexp对象，转换数据格式
        String[] key = list.keys();
        if(key != null){
            int i = 0;
            while (i < key.length){
                i++;
            }
        }
        System.out.print("    ");
        for(int i=2;i<key.length;i++){
            System.out.print(String.format("%8s",key[i]));
        }
        System.out.println();


        RVector vector =  rexp.asVector();
        double [][]data=new double[vector.size()-2][];
        for(int i=0; i<vector.size()-2; i++){
            REXP rexpTemp = (REXP) vector.get(i+2);

            if(REXP.REALSXP == rexpTemp.rtype){
                double []tempData=rexpTemp.asDoubleArray();
                int size=rexpTemp.asDoubleArray().length;
                data[i]=new double[size];
                for(int h=0;h<size;h++){
                    data[i][h]=tempData[h] ;
                }
            }

        }

        int count=1;
        int length=data[0].length;
        for(int j=0;j<length;j++){
            System.out.print(String.format("%4d",count++));
            for(int i=0;i<data.length;i++) {
//                if(data[i][j]==1){
//                    System.out.print(String.format("%8.2f", data[i][j])+"|"+range[i]);
//                }else if(data[i][j]==-1){
//                    System.out.print(String.format("%8.2f", data[i][j])+"|"+range[i+1]);
//                }else if(data[i][j]==0){
//                    System.out.print(String.format("%8.2f", data[i][j])+"|"+(range[i+1]+range[i])/2);
//                }else{
//                    System.out.print(String.format("%8.2f", data[i][j]));
//                }
                if(data[i][j]==1){
                    System.out.print(String.format("%8.2f", range[i]));
                }else if(data[i][j]==-1){
                    System.out.print(String.format("%8.2f", range[i+1]));
                }else if(data[i][j]==0){
                    System.out.print(String.format("%8.2f", (range[i+1]+range[i])/2));
                }else{
                    System.out.print(String.format("%8.2f", data[i][j]));
                }

            }
            System.out.println();
        }

    }

    /**
     * 打印R执行返回结果
     * @param rexp
     */
    public static void printRreturnDataWithName(REXP rexp){

        /**
         * 读取返回结果,并转换为java数据结构
         */
        RList list = rexp.asList();
        // 解析rexp对象，转换数据格式
        String[] key = list.keys();
        if(key != null){
            int i = 0;
            while (i < key.length){
                i++;
            }
        }
        System.out.println("\n\n==============试验计划表================");
        System.out.println("======================================");
        System.out.print("序号");
        for(int i=0;i<key.length;i++){

            if(key[i].equals("A")){
                System.out.print(String.format("%5s","粉炭灰"));
            }else if(key[i].equals("B")){
                System.out.print(String.format("%5s","生石灰"));
            }else if(key[i].equals("C")){
                System.out.print(String.format("%6s","炉渣"));
            }else if(key[i].equals("D")){
                System.out.print(String.format("%7s","不锈钢渣"));
            }

        }
        System.out.println();

        RVector vector =  rexp.asVector();
        int [][]cbdData=new int[vector.size()][];
        for(int i=0; i<vector.size(); i++){
            REXP rexpTemp = (REXP) vector.get(i);
            if(REXP.INTSXP == rexpTemp.rtype){
                RFactor factor=rexpTemp.asFactor();
                cbdData[i]=new int[factor.size()];
                for(int h=0;h<factor.size();h++){
                    cbdData[i][h]=Integer.parseInt(factor.at(h));
                }
            }
        }

        int count=1;
        int length=cbdData[0].length;
        for(int j=0;j<length;j++){
            System.out.print(String.format("%2d",count++));
            for(int i=0;i<cbdData.length;i++){
                if(i==0){
                    if(cbdData[i][j]==1){
                        System.out.print(String.format("%8s","40.5%"));
                    }else if(cbdData[i][j]==2){
                        System.out.print(String.format("%8s","52.2%"));
                    }else if(cbdData[i][j]==3){
                        System.out.print(String.format("%8s","68.5%"));
                    }
                }else if(i==1){
                    if(cbdData[i][j]==1){
                        System.out.print(String.format("%8s","6.5%"));
                    }else if(cbdData[i][j]==2){
                        System.out.print(String.format("%8s","8.2%"));
                    }else if(cbdData[i][j]==3){
                        System.out.print(String.format("%8s","12.5%"));
                    }
                }else if(i==2){
                    if(cbdData[i][j]==1){
                        System.out.print(String.format("%8s","12.5%"));
                    }else if(cbdData[i][j]==2){
                        System.out.print(String.format("%8s","15.8%"));
                    }else if(cbdData[i][j]==3){
                        System.out.print(String.format("%8s","20.5%"));
                    }
                }else if(i==3){
                    if(cbdData[i][j]==1){
                        System.out.print(String.format("%8s","15.3%"));
                    }else if(cbdData[i][j]==2){
                        System.out.print(String.format("%8s","20.5%"));
                    }else if(cbdData[i][j]==3){
                        System.out.print(String.format("%8s","28.0%"));
                    }
                }

            }
            System.out.println();
        }
        System.out.println("======================================");
    }

    public static void printRreturnData(REXP rexp){

        /**
         * 读取返回结果,并转换为java数据结构
         */
        RList list = rexp.asList();
        // 解析rexp对象，转换数据格式
        String[] key = list.keys();
        if(key != null){
            int i = 0;
            while (i < key.length){
                i++;
            }
        }
        System.out.print("    ");
        for(int i=0;i<key.length;i++){
           // System.out.print(String.format("%4s",key[i]));
            if(key[i].equals("A")){

            }
        }
        System.out.println();

        RVector vector =  rexp.asVector();
        int [][]cbdData=new int[vector.size()][];
        for(int i=0; i<vector.size(); i++){
            REXP rexpTemp = (REXP) vector.get(i);
            if(REXP.INTSXP == rexpTemp.rtype){
                RFactor factor=rexpTemp.asFactor();
                cbdData[i]=new int[factor.size()];
                for(int h=0;h<factor.size();h++){
                    cbdData[i][h]=Integer.parseInt(factor.at(h));
                }
            }
        }

        int count=1;
        int length=cbdData[0].length;
        for(int j=0;j<length;j++){
            System.out.print(String.format("%4d",count++));
            for(int i=0;i<cbdData.length;i++)
                System.out.print(String.format("%4d",cbdData[i][j]));
            System.out.println();
        }
    }
    /**
     * 载入R引擎文件
     * @param fileName
     * @return 返回引擎,进行下一步操作
     */
    public static Rengine loadR(String fileName){
        String tempPath= FileUtils.getNowFilePath();
        // R文件全路径
        String filePath = tempPath+"/src/DCL/rData/"+fileName;
        // 初始化R解析类
        Rengine engine=new Rengine (new String [] {"--vanilla"}, false, null);
        // 等待解析类初始化完毕
        if (!engine.waitForR()) {
            System.out.println("Cannot load R");
            return null;
        }
        // System.out.println(filePath);
        // 将文件全路径复制给R中的一个变量
        engine.assign("fileName", filePath);
        // 在R中执行文件。执行后，文件中的两个函数加载到R环境中，后续可以直接调用
        engine.eval("source(fileName)");
        return  engine;
    }

}
