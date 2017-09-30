package DCL.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Julis on 17/8/28.
 * User:Julis 落叶挽歌
 * Date:17/8/28
 * Time:下午1:52
 */
public class ExcelUtils {
    public static void printVKBDesign(int v,int k,int b){
        String tempPath=FileUtils.getNowFilePath();//获取项目路径
        String filePath=tempPath+"/src/DCL/rData/martix/"+v+"-"+k+"-"+b+".xlsx";
        File excelFile = new File(filePath);
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = wb.getSheetAt(0);//获取第一个sheet
        for (Row row : sheet) {//遍历行
            for (Cell cell : row) {//遍历行中的各个数据
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getRichStringCellValue().getString());
                        System.out.print("|");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.print(String.valueOf(cell.getDateCellValue()));
                        } else {
                            System.out.print(new Double(cell.getNumericCellValue()).intValue());
                        }
                        System.out.print("\t");
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        System.out.print("|");
                        break;
                    default:
                }
            }
            System.out.println();
        }
    }
}
