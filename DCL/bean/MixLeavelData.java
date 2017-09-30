package DCL.bean;

/**
 * Created by Julis on 17/8/28.
 * User:Julis 落叶挽歌
 * Date:17/8/28
 * Time:下午3:11
 */
public final class MixLeavelData {
    /**
     * 横向代表2水平的个数
     * 竖代表3水平的个数
     *
     * 0 没有此方法
     * 1 拟水平
     * 2 赋闲列表
     * 3 原表不变
     */
    public static int [][]table={
            {0,1,2,2,2,2},
            {1,1,2,2,3,0},
            {3,1,1,1,0,0},
            {3,1,1,0,0,0},
            {3,1,0,0,0,0},
            {3,0,0,0,0,0}
    };
}
