package WORK.Java.Java727Interface.Third;

import WORK.Java.Java727Interface.Third.ClassName;

/**
 * Created by Julis on 17/7/27.
 * User:Julis 落叶挽歌
 * Date:17/7/27
 * Time:下午1:51
 */
public class Cat implements ClassName {
    @Override
    public String getClassName() {
       return this.getClass().getName();
    }
}
