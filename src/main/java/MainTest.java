import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * @author chengyongjun
 * @date 5/28/19 5:12 PM
 */
public class MainTest {
    public static void main(String[] args) {

        HashSet<Integer> leftCompare = Sets.newHashSet ();
        HashSet<Integer> compare = Sets.newHashSet ();

        Random random = new Random ();
        random.setSeed (System.currentTimeMillis ());

        List<Integer> leftCompareList = new ArrayList<> ();
        List<Integer> compareList = new ArrayList<> ();

        int[] leftArrayCompareList = new int[10000000];
        int[] rightArrayCompareList = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            leftCompare.add (i);
            compare.add (i);
            leftCompareList.add (i);
            compareList.add (i);
            leftArrayCompareList[i] = i;
            rightArrayCompareList[i] = i;
        }

        System.out.println ("begin");
        long beginTime;
        /*System.gc ();

        beginTime = System.currentTimeMillis ();
        HashSet hashSetLeft = new HashSet (leftCompare);
        HashSet hashSetRight = new HashSet (compare);
        Sets.SetView intersection = Sets.intersection (hashSetLeft, hashSetRight);
        List<Integer> integerList = addInteger (intersection);
        System.out.println ("google set use time:" + (System.currentTimeMillis () - beginTime));*/


        /*
        System.gc ();
        beginTime = System.currentTimeMillis ();
        List<Integer> resultList = getIntersection (leftCompareList, compareList);
        resultList = addInteger (resultList);
        System.out.println ("getIntersection use time:" + (System.currentTimeMillis () - beginTime));*/

        /*System.gc ();

        beginTime = System.currentTimeMillis ();
        getIntersectionLocal (leftArrayCompareList, rightArrayCompareList);
        System.out.println ("getIntersectionLocal use time:" + (System.currentTimeMillis () - beginTime));
*/
        System.gc ();
        beginTime = System.currentTimeMillis ();
        getHighIntersectionLocal (leftArrayCompareList, rightArrayCompareList);
        System.out.println ("getHighIntersectionLocal use time:" + (System.currentTimeMillis () - beginTime));
    }

    private static List<Integer> getIntersection(List<Integer> leftCompare, List<Integer> compare) {
        List<Integer> integerList;
        HashSet<Integer> middle;
        List<Integer> compareList;
        if (leftCompare.size () > compare.size ()) {
            middle = new HashSet<> (leftCompare);
            compareList = compare;
            integerList = new ArrayList<> (compare.size ());

        } else {
            middle = new HashSet<> (compare);
            compareList = leftCompare;
            integerList = new ArrayList<> (leftCompare.size ());
        }

        for (int i = 0; i < compareList.size (); i++) {
            if (middle.contains (compareList.get (i))) {
                integerList.add (compareList.get (i));
            }
        }
        return integerList;
    }

    private static int[] getIntersectionLocal(int[] leftCompare, int[] compare) {
        algorithmUtils algorithmUtils = new algorithmUtils ();
        int[] intersectionSet = algorithmUtils.getIntersectionSet (leftCompare, compare);
        return intersectionSet;
    }

    private static int[] getHighIntersectionLocal(int[] leftCompare, int[] compare) {
        algorithmUtils algorithmUtils = new algorithmUtils ();
        int[] intersectionSet = algorithmUtils.getHighPerformanceIntersectionSetSorted (leftCompare, compare);
        return intersectionSet;
    }


    private static List<Integer> addInteger(List<Integer> list) {
        List<Integer> result = new ArrayList<> (list.size ());
        for (Integer i : list) {
            result.add (i);
        }
        return result;
    }

    private static List<Integer> addInteger(Sets.SetView setView) {
        List<Integer> result = new ArrayList<> (setView.size ());
        UnmodifiableIterator iterator = setView.iterator ();
        while (iterator.hasNext ()) {
            result.add ((Integer) iterator.next ());
        }
        return result;
    }
}