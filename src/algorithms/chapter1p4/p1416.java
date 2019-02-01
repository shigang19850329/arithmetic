package algorithms.chapter1p4;

import java.util.Arrays;

/**
 * 1.4.16 最接近的一对（一维）。编写一个程序，给定含有N个double值的数组a[],在其中找到一对最接近的值；两者之差（绝对值）最小的两个数。程序在最坏情况下所需的运行时间应该是线性对数级别的。
 */
public class p1416 {
    public static void closerPairFaster(double[] a){
        Arrays.sort(a);
        double minNum = Double.MAX_VALUE;
        int minI = 0 ;
        for (int i = 0; i < a.length-1; i++) {
            if (a[i+1]-a[i]<minNum){
                minI = i;
                minNum = a[i+1]-a[i];
            }
        }
        System.out.println("最接近的两个数为："+ a[minI]);
        System.out.println("和："+a[minI+1]);
    }

    public static void main(String[] args) {
        double[] a = {1,3,6,4,888,76,45};
        closerPairFaster(a);
        }
}
