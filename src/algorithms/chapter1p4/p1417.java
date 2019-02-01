package algorithms.chapter1p4;
/**
 * 1.4.17 最遥远的一对（一维）。编写一个程序，给定一个含有N个double值的数组a[],在其中找到一对最遥远的值：两者之差（绝对值）最大的两个数。程序在最坏的情况下所需的运行时间应该是线性级别最高的。
 */
public class p1417 {
    public static void fastestPairLinear(double[] a){
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i]>=max)
                max = a[i];
            if (a[i]<min)
                min = a[i];
        }
        System.out.println("最遥远的两个数为:"+max);
        System.out.println("和:"+min);
    }

    public static void main(String[] args) {
        double[] a = {1,2,3,4,5,888,76,45};
        fastestPairLinear(a);
        }
}
