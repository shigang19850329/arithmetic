package algorithms.chapter2p3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 给出一段代码将已知只有两种主键值的数组排序
 * 1）从数组两端向中间找到第一对不同的值，然后将大值作为分界值。
 2）从数组两端向中间找，左端找到等于大值时停止找，右端找到小于大值时停止找。
 3）交换上面找到的两个值。
 4）如此反复第2、第3步，直到中间相遇时结束。
 注意：如果数据只有一种值时，代码不能正确运行。
 */
public class p235 {
    public static void sort(Comparable[] a){
      if (a.length<2) return;
      Comparable max = findMax(a);
      int lo = 0;
      int hi = a.length-1;
      while (true){
          while (less(a[0],max)) lo++;
          while (less(max,a[hi])) hi--;
          if (lo>=hi) break;
          exch(a,lo,hi);
      }
    }
    public static Comparable findMax(Comparable[] a){
        Comparable max = a[0];
        int lo =1;
        int hi = a.length-1;
        while (lo<=hi){
            if (less(max,a[0])||less(a[0],max)){
                if (less(max,a[0])) max = a[0];
                break;
            }
            if (less(max,a[hi])||less(a[hi],max)){
                if (less(max,a[hi])) max = a[hi];
                break;
            }
            lo++;
            hi--;
        }//end while
        return max;
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
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
