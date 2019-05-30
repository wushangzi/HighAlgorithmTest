/**
 * @author chengyongjun
 * @date 5/28/19 5:23 PM
 */

public class algorithmUtils {
    static {
        System.loadLibrary ("algorithmUtils");
    }

    /**
     * 注意,本接口的参数必须是已排序状态,正序和逆序都行
     * @param leftCompare 左值筛选数组
     * @param rightCompare 右值筛选数组
     * @return
     */
    public native int[] getHighPerformanceIntersectionSetSorted(int[] leftCompare, int[] rightCompare);

    public native int[] getIntersectionSet(int[] leftCompare, int[] rightCompare);

    public native int[] getUnionSet(int[] leftCompare, int[] rightCompare);


}
