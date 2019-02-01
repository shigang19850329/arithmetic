package algorithms.chapter2p1;
//选择排序
public class SelectionSort {
    public static void selection(int[] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i+1; j < n; j++) {
                 if (a[j]<a[k])
                 {
                     k = j;
                 }
            }
            //将最小值放到未排序记录的第一个位置
            if (k>i){
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] b = { 49, 38, 65, 97, 76, 13, 27, 50 };
        selection(b);
        for (int i : b)
            System.out.print(i + " ");
    }
}
