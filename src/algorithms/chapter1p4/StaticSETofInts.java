package algorithms.chapter1p4;

import java.util.Arrays;

/**
 * 1.4.11 为StaticSETofInts添加一个实例方法howMany(),找出给定键的出现次数且在最坏的情况下所需的运行时间和logN成正比。
 */
public class StaticSETofInts {
    private int[] a;
    //用一个数组初始化有序数组
    public StaticSETofInts(int[] keys){
        this.a = new int[keys.length];
        for (int i = 0; i < keys.length; ++i) {
            a[i] = keys[i];
        }
        Arrays.sort(this.a);
    }
    public int HowMany(int key){
        int hi = this.a.length-1;
        int lo = 0;

        return HowMany(key,lo,hi);
    }
    /**
     * 返回某个元素在数组中出现的数量
     */
    private int HowMany(int key,int lo,int hi){
        int mid = Rank(key,lo,hi);
        if (mid==-1)
            return 0;
        else
            return 1+HowMany(key,lo,mid-1)+HowMany(key,mid+1,hi);
    }
    /**
     * 检查数组中是否含有key
     * @param key
     * @return
     */
    public boolean ontains(int key){
          return Rank(key,0,this.a.length-1)!=-1;
    }

    /**
     *二分查找，检查数组中是否含有key，返回下标。
     * 没有返回-1
     */
   public int Rank(int key,int lo,int hi){
        while (lo<=hi){
            int mid = (hi-lo)/2+lo;
            if (key<this.a[mid]){
                hi = mid-1;
            }else if (key>this.a[mid]){
                lo = mid+1;
            }else
                return mid;
        }
        return -1;
   }

    public static void main(String[] args) {
        int[] keys = {1,1,1,1,1,2,2,2,2,2,3,3,3,33,4,4,4,4,44,5,5,5,5,5,5};
        StaticSETofInts staticSETofInts = new StaticSETofInts(keys);
        int count = staticSETofInts.HowMany(3);
        System.out.println(count);
    }
}
