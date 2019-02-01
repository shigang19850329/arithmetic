package algorithms.chapter5p1;

/**
 * 作者: 石刚
 * 时间: 2019/1/21 7:50
 * 版本 1.0
 * 算法5.1 低位优先字符串排序
 */
public class LSD {
    public static void sort(String[] a, int w) {
        //通过前W个字符将a[]排序
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = w - 1; d >= 0; d--) {
            //根据第d个字符用键索引计数法排序
            //计算出现频率
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            //将频率转换为索引
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            //将元素分类
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            //回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
