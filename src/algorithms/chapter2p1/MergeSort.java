package algorithms.chapter2p1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class MergeSort {
    private static Comparable[] aux;//归并所需的辅助数组

    public static void merge(Comparable[] a,int lo,int mid,int hi){
       //将a[lo..mid] 和a[mid+1..hi]归并
        int i = lo,j = mid+1;
        for (int k = lo; k <=hi ; k++) {//将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];
        }
        for (int k = lo; k <=hi ; k++) {//归并回到a[lo...hi]
            if (i>mid)  a[k] = aux[j++];//如果左半边用尽，则取右半边的元素
            else if (j>hi) a[k] =aux[i++];//如果右半边用尽，则取左半边的元素
            else if (less(aux[j],aux[i])) a[k] = aux[j++];//左右两边哪边的元素小则取哪个元素
            else a[k] = aux[i++];
        }
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

    public static void main(String[] args) {
        //从标准输入中读取字符串，将它们排序并输出
        String[] a = In.readStrings();
        merge(a,0,a.length/2,a.length);

        show(a);
    }
}
