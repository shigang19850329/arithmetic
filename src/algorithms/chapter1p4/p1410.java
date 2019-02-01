package algorithms.chapter1p4;
/**
修改二分查找算法，使之总是返回和被查找的键匹配的索引最小的元素（且仍然能够保证对数级别的运行时间）。
 */
public class p1410 {
    public static int Rank(int key,int[] a,int lo,int hi){
        if (hi<lo)
            return -1;
        int mid = (hi-lo)/2+lo;
        if (a[mid]==key){
            int mini = Rank(key,a,lo,mid-1);
            if (mini!=-1)
                return mini;
            return mid;
        }
        else if (a[mid]<key){
            return Rank(key,a,mid+1,hi);
        }
        else {
            return Rank(key,a,lo,mid-1);
        }
    }
}
