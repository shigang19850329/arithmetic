package algorithms.chapter3p2;

/**
 * 3.2.25 完美平衡。编写一段程序，用一组键构造一棵和二分查找
 * 等价的二叉查找树。也就是说，在这棵树中查找任意键所产生的
 * 比较序列和在这组键中使用二分查找所产生的比较序列完全相同。
 */

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/******************************************************************************
 *  Compilation:  javac PerfectBalance.java
 *  Execution:    java PerfectBalance < input.txt
 *  Dependencies: StdOut.java
 *
 *  Read sequence of strings from standard input (no duplicates),
 *  and insert into a BST so that BST is perfectly balanced.
 *  从标准输入中读取一列字符串，没有重复。
 *  % java PerfectBalance
 *  P E R F C T B I N A R Y S R H
 *  N E B A C H F I R R P R T S Y
 *
 ******************************************************************************/
public class PerfectBalance {
    //前提 a[] 没有重复
    private static void perfect(BST bst, String[] a) {
        Arrays.sort(a);
        perfect(bst, a, 0, a.length - 1);
        StdOut.println();
    }

    //前提 a[] 是已经排好序的
    private static void perfect(BST bst, String[] a, int lo, int hi) {
        if (hi < lo) return;
        int mid = lo + (hi - lo) / 2;
        bst.put(a[mid], mid);
        StdOut.print(a[mid] + " ");
        perfect(bst, a, lo, mid - 1);
        perfect(bst, a, mid + 1, hi);
    }

    public static void main(String[] args) {
        String[] words = {"P","E","R","F","C","T","B","I","N","A","R","Y",
                "S ","R","H"};
        BST<String, Integer> bst = new BST<String, Integer>();
        perfect(bst, words);
    }
}
