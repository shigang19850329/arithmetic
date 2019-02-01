package algorithms.chapter1p4;

import java.util.Arrays;

/**
 * 1.4.12 编写一个程序，有序打印给定的两个有序数组（含有N个int值）中的所有公共元素，程序在最坏的情况下所需的运行时间应该和N成正比。
 */
public class p1412 {
    public static void sameElements(int[] a,int[] b){
        //2N次访问数组，数组a和数组b各一遍
        for (int i = 0,j = 0;i<a.length&&j<b.length;) {
            if (a[i]<b[j]){
                i++;
            }
           else if (a[i]>b[j]){
                j++;
            }
            else{
                System.out.println(" "+a[i]);
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] b = {1,2,3,4,5,6,7,8,9,10};
        int[] a = {2,3,4,5,6};
        Arrays.sort(a);
        Arrays.sort(b);
        sameElements(a,b);
    }
}
