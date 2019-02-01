package algorithms.chapter1p4;

import java.util.Arrays;

/**
 * 1.4.21 无重复值之中的二分查找。用二分查找实现 StaticSETofInts （参见表 1.2.15），保证 contains() 的运行时间为 ~lgR，其中 R 为参数数组中不同整数的数量。

 */
public class StaticSETofInt {
    private int[] a;
    public StaticSETofInt(int[] keys){
      a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }
    public boolean contains(int key){
        return rank(key)!=-1;
    }
    public  int rank(int key){//binarySearch
        int lo = 0;
        int hi = a.length-1;
        while (lo<hi){// Key is in a[lo..hi] or not present.
            int mid = lo+(lo-hi)/2;
            if (key<a[mid]){
               hi = mid-1;
            }else if (key>a[mid]){
                lo = mid+1;
            }else return mid;
        }
        return -1;
    }
}
