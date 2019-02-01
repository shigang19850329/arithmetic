package algorithms.chapter1p4;

import java.util.Arrays;

/**1.4.23 分数的二分查找。设计一个算法，使用对数级别的比较次数找出有理数 p/q，其中 0<p<q<N，比较形式为给定的数是否小于 x?提示：两个分母均小于N的有理数之差不小于1/N2。
 *
 */
public class FractionBinarySearch {
    public static int rank(double key,double[] a){
        //数组必须是有序的。
        int lo = 0;
        int hi = a.length-1;
        double threshold = 1.0/(a.length*a.length);
        while (lo<=hi){
            int mid = lo+ (hi-lo)/2;
            //这里的判定条件做一下改动
            if (Math.abs(a[mid]-key)<=threshold){
                return mid;
            }else if (key>a[mid]) {
                lo = mid + 1;
            }else hi = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        double[] fractions = {1.0/2.0,2.0/3.0,3.0/4.0,4.0/5.0,5.0/6.0};
        Arrays.sort(fractions);
        int index = rank(4.0/5.0,fractions);

        System.out.println("4.0/5.0 在第" + index + "个");
    }
}
