package algorithms.chapter2p1;

//希尔排序java
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int[] b = {3, 2, 4, 5, 1};
        System.out.println("排序之前");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        sort1(a);
    }
   public static void sortDouble(double[] a){
        int N =a.length;
        for (int h =N/2;h>0;h/=2){
            for (int i = h; i < N; i++) {
                for (int j = i; j>=h&&a[j]<a[j-h] ; j-=h) {
                    double temp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = temp;
                }
            }
        }
   }
    public static void sort(int[] a) {
        //希尔排序
        int d = a.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i += d) {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j -= d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1)
                break;
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void sort1(int[] a) {
        int N = a.length;
        for (int h = N / 2; h > 0; h /= 2) {//增量
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    int temp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    public static void sort3(int[] a){
        int N = a.length;
        for (int h = N/2; h >0; h/=2 ){
            for (int i = h; i < N; i++) {
                for (int j = i; j >=h&&a[j]<a[j-h] ; j-=h) {
                    int temp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = temp;
                }
            }
        }
    }
}
