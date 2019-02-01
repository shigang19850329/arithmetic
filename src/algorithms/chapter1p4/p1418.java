package algorithms.chapter1p4;
/**
 * 1.4.18 数组的局部最小元素。编写一个程序，给定一个含有N个不同整数的数组，找到一个局部最小元素：满足a[i]<a[i-1]
 且a[i]<a[i+1]的索引i。程序在最坏情况下所需的比较次数为~2lgN。
 答;检查数组的中间值a[N/2]以及和它的相邻的元素a[N/2-1]和
 a[N/2+1]。如果a[N/2]是一个局部最小值则算法终止；否则则在较小的相邻元素的半边中继续查找。
 */
public class p1418 {
    public static int localMinimum(int[] x){
        if (x.length==0||x==null)
            return -1;
        if (x.length==1||x[0]<x[1])
            return 0;
        if (x[x.length-1]<x[x.length-2])
            return x.length-1;
        int mid = 0;
        int left = 1;
        int right = x.length-2;
        while (left<right){
            mid = (left+right)/2;
            if (x[mid]-1<x[mid])
                right = mid-1;
           else if (x[mid+1]<x[mid])
               left = mid+1;
           else
               return mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 4, 5, 6, 11, 14, 8, 25};
        int index = localMinimum(a);
        System.out.println("局部最小元素，" + "a[" + index + "]值为" + a[index]);
    }
}
