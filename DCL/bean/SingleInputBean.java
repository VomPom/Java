package DCL.bean;

/**
 * Created by Julis on 17/8/5.
 * User:Julis 落叶挽歌
 * Date:17/8/5
 * Time:下午3:30
 */
public class SingleInputBean {
    private int factor;
    private int group;
    private int leves;
    private int k;


    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getLeves() {
        return leves;
    }

    public void setLeves(int leves) {
        this.leves = leves;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "SingleInputBean{" +
                "factor=" + factor +
                ", group=" + group +
                ", leves=" + leves +
                ", k=" + k +
                '}';
    }
}
