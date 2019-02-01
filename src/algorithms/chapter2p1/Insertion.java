package algorithms.chapter2p1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

//插入排序
public class Insertion {
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
    public static void sort(Comparable[] a){
        //将a按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j>0&&less(a[j],a[j-1]) ; j--) {
                exch(a,j,j-1);
            }
        }
    }
    public static void main(String[] args) {
        //从标准输入中读取字符串，将它们排序并输出
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
