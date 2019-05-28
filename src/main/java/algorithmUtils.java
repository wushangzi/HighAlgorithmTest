/**
 * @author chengyongjun
 * @date 5/28/19 5:23 PM
 */

public class algorithmUtils {
    static {
        System.loadLibrary ("algorithmUtils");
    }

    public native int[] getIntersectionSet(int[] leftCompare, int[] rightCompare);

    public native int[] getUnionSet(int[] leftCompare, int[] rightCompare);

}
