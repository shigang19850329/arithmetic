package algorithms.chapter2p1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class p2112 {
    /**
     * 查询最后结果，可以发现相同的h在数组大小不同时所产生的比值非常接近
     */
    public static int compareTimes = 0;
    public static int maxRate = 0;

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            compareTimes = 0;
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            if (compareTimes / N > maxRate) maxRate = compareTimes / N;
            StdOut.printf("N=%d,h=%d,compareTimes=%d,rate=%d\n", N, h, compareTimes, compareTimes / N);
            h = h / 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        compareTimes++;
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        //测试数组元素是否有序
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int N = 100; N <= 10000000; N *= 10) {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform(100.0, 100000000.0);
            sort(a);
        }
        StdOut.println("maxRate=" + maxRate);
    }
}
