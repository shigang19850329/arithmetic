package algorithms.chapter1p4;
/**
 * 1.4.24 扔鸡蛋。假设你面前有一栋 N 层的大楼和许多鸡蛋，假设将鸡蛋从 F 层或者更高的地方扔下鸡蛋才会摔碎，否则则不会。首先，设计一种策略来确定 F 的值，其中扔 ~ lgN 次鸡蛋后摔碎的鸡蛋数量为 ~ lgN。然后想办法将成本降低到~ 2lgF。
 */
public class TestResult {
    public int F;//找到的最大值。
    public int BrokenEggs;//打碎的鸡蛋数
  //没碎返回true，碎了返回false；
    public  boolean throwEggs(int floor){
           return floor<=F;
    }
    public TestResult planA(int[] a){
        int lo = 0;
        int hi = a.length-1;
        int mid = 0;
        int eggs = 0;
        TestResult result= new TestResult();
        while (lo<=hi){
            mid = lo+(hi-lo)/2;
            if (throwEggs(mid)){
                lo = mid+1;
            }else{
               eggs++;
               hi = mid-1;
            }
        }
        result.BrokenEggs = eggs;
        result.F = hi;
        return result;
    }
}
