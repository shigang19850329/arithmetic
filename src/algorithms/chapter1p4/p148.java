package algorithms.chapter1p4;

import edu.princeton.cs.algs4.BinarySearch;

/**
 * 平方级别：直接二层循环遍历一遍。
 线性对数：只遍历一遍数组，在遍历过程中用二分查找确认在剩余数组中是否有相等的整数。
 */
public class p148 {
    public static int CountEqual(int[] a){
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                if (a[i]==a[j])
                    count++;
            }
        }
        return count;
    }
    public static int CountEqualLog(int[] a){
        int n =a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            //if (BinarySearch.rank(a[i],a,i+1,a.length-1)!=-1)
                count++;
        }
        return count;
    }
}
