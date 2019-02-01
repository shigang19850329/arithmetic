package algorithms.chapter1p4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 计时器
 */
public class Stopwatch {
    private final long start;
    public Stopwatch(){
        start = System.currentTimeMillis();
    }

    /**
     * 返回创建这个对象到现在过去的时间，秒数。
     * @return
     */
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now-start)/1000.0;
    }

    public static void main(String[] args) {
        int N = 2000;
        int[] a = new int[N];
        for (int i =0; i <N; i++){
            a[i] = StdRandom.uniform(-100000,1000000);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt+ "triples" + time + "seconds");
    }
}
