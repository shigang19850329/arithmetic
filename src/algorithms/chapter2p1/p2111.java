package algorithms.chapter2p1;

//2.1.11 将希尔排序中实时计算递增数列改为预先计算并储存在一个数组中。
public class p2111 {
    public static void sort(int[] a) {
        int n = a.length;
        int[] h = new int[2];//预先准备好的h值数组

        int hTemp = 1;
        int sequenceSize = 0;
        for (sequenceSize = 0; hTemp < n; sequenceSize++) {
            if (sequenceSize >= h.length)//如果数组不够大则扩容
            {
                int[] expand = new int[h.length * 2];
                for (int i = 0; i < h.length; i++) {
                    expand[i] = h[i];
                }
                h = expand;
            }
            h[sequenceSize] = hTemp;
            hTemp = hTemp * 3 + 1;
        }
        for (int t = sequenceSize - 1; t >= 0; t--) {
            for (int i = h[t]; i < n; i++) {
                for (int j = i; j >= h[t] && a[j] < a[j - h[t]]; j -= h[t]) {
                    int temp = a[j - h[t]];
                    a[j - h[t]] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
