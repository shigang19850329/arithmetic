package algorithms.chapter2p3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);//消除对输入的依赖
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a, int lo,int hi){
        if (hi<=lo) return;
        int j = partition(a,lo,hi);//切分，详见快速排序的切分
        sort(a,lo,j-1);//将左半部分a[lo...j-1]排序
        sort(a,j+1,hi);//将右半部分a[j+1...hi]排序
    }
    private static int partition(Comparable[] a,int lo,int hi){
        //将数组切分成a[lo...i-1],a[i],a[i+1,hi]
        int i = lo,j = hi;//左右扫描指针
        Comparable v = a[lo];//切分元素
        while (true){
            //扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i],v)) if (i==hi)break;
            while (less(v,a[--j])) if (j==lo)break;
            if (i>=j)break;
            exch(a,i,j);
        }
        exch(a,lo,j);//将v=a[j]放入正确的位置
        return j;//a[lo...j-1]<=a[j]<=a[j+1,hi]达成
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];a[i] = a[j];a[j] = t;
    }
    private static void show(Comparable[] a){
        //单行中打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i]+" ");
            StdOut.println();
        }
    }
    public static boolean isSorted(Comparable[] a){
        //测试数组元素是否有序
        for (int i = 0; i < a.length; i++) {
            if (less(a[i],a[i-1])) return false;
        }
        return true;
    }
}
