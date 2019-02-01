package algorithms.chapter5p1;

import edu.princeton.cs.algs4.Insertion;

import java.util.Comparator;

/**
 * 作者: 石刚
 * 时间: 2019/1/21 19:17
 * 版本 1.0
 * 算法5.2 高位优先的字符串排序
 */
public class MSD {
    /**
     * 基数
     */
    private static int R= 256;
    /**
    小数组的切换阈值
     */
    private static final int M=15;
    /**
     * 数据分类的辅助数组
     */
    private static String[] aux;
    private static int charAt(String s,int d){
        if (d<s.length()){
            return s.charAt(d);
        }else{
            return -1;
        }
    }
    public static void sort(String[] a){
        int N=a.length;
        aux=new String[N];
        sort(a,0,N-1,0);
    }
    private static void sort(String[] a, int lo, int hi, int d){
        //以第d个字符为键将a[lo]至a[hi]排序
        if (hi<=lo+M){
            //Insertion.sort(a,lo,hi,d);
            return;
        }
        //计算频率
        int[] count=new int[R+2];
        for (int i = lo; i <=hi ; i++) {
            count[charAt(a[i],d)+2]++;
        }
        //将频率转换为索引
        for (int r = 0; r < R+1; r++) {
            count[r+1]+=count[r];
        }
        //数据分类
        for (int i = lo; i <=hi ; i++) {
            aux[count[charAt(a[i],d)+1]++]=a[i];
        }
        //回写
        for (int i = lo; i <=hi ; i++) {
            a[i]=aux[i-lo];
        }
        //递归的以每个字符为键进行排序
        for (int r = 0; r <R ; r++) {
            sort(a,lo+count[r],lo+count[r+1]-1,d+1);
        }
    }
}
