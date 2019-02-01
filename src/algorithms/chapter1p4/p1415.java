package algorithms.chapter1p4;
import java.util.Arrays;

public class p1415 {
    //O(n)
    public static int TwoSumFaster(int[] a){
        Arrays.sort(a);
        int cnt = 0;
        int left = 0;int right = a.length-1;
        while (left<right){
            if (a[left]+a[right]==0){
                cnt++;
                left++;
            }
            if (a[left]+a[right]>0)
                right--;
            if (a[left]+a[right]<0)
                left++;
        }
        return cnt;
    }
    //三个数相加
    public static int ThreeSumFaster(int[] a){
        Arrays.sort(a);
        int cnt = 0;
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int left = i+1;int right = a.length-1;
            while (left<right){
                if (a[left]+a[right]+a[i]==0){
                    left++;
                    cnt++;
                }
                if (a[left]+a[right]+a[i]>0)
                    right--;
                if (a[left]+a[right]+a[i]<0)
                    left++;
            }
        }
        return cnt;
    }
}
