package algorithms.chapter3p4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;

/**
 * 白名单
 */
public class WhiteFilter {
    public static void main(String[] args) {
        HashSet<String> set;
        set = new HashSet<String>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            set.add(in.readString());
        }
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (set.contains(word))
                StdOut.print(word + " ");
        }
    }
}
