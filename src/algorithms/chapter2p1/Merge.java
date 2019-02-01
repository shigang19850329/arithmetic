package algorithms.chapter2p1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 自顶而下的归并排序
 */
public class Merge {
    private static Comparable[] aux;//归并所需的辅助数组
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];//一次性分配空间
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        //将数组a[lo..hi]排序
        if (hi<=lo) return;
        int mid = lo+(hi-lo)/2;
        sort(a,lo,mid);//将左半边排序
        sort(a,mid+1,hi);//将右半边排序
        merge(a,lo,mid,hi);//归并结果
    }
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        //将a[lo..mid]和a[mid+1..hi]归并
        int i = lo,j = mid+1;
        for (int k = lo; k <= hi; k++) {//将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];
        }
        for (int k = lo; k <=hi ; k++) {//归并到a[lo..hi]
            if (i>mid) a[k]=aux[j++];
            else if (j>hi) a[k]=aux[i++];
            else if (less(aux[j],aux[i])) a[k]=aux[j++];
            else a[k]=aux[i++];
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

}
