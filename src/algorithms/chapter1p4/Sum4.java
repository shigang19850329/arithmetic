package algorithms.chapter1p4;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

/**
 * 1.4.14 4-sum。为4-sum设计一个算法。
 * N^3*logN
 */
public class Sum4 {
    public static int FourSumFast(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j <N; j++) {
                for (int k = j+1; k <N ; k++) {
                    if (BinarySearch.rank(-a[i]-a[j]-a[k],a)>k)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}
