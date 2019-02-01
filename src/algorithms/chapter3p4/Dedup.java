package algorithms.chapter3p4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;

//过滤器
public class Dedup {
    public static void main(String[] args) {
        HashSet<String> set;
        set = new HashSet<String>();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!set.contains(key)) {
                set.add(key);
                StdOut.print(key + " ");
            }
        }
    }
}
