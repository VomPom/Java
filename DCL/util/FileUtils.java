package DCL.util;

import java.io.File;

/**
 * Created by Julis on 17/8/26.
 * User:Julis 落叶挽歌
 * Date:17/8/26
 * Time:下午9:19
 */
public class FileUtils {
        /**
         * 获取项目路径
         * @return
         */
    public static String getNowFilePath(){
        File directory = new File("");//设定为当前文件夹
        String tempPath=null;
        try{
            tempPath = directory.getAbsolutePath();//获取标准的路径
            //System.out.println(directory.getAbsolutePath());//获取绝对路径
        }catch(Exception e){
        }
        return tempPath;
    }
}
