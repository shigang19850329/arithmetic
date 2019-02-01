package algorithms.chapter5p4;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 作者: 石刚
 * 时间: 2019/1/31 18:32
 * 版本 1.0
 * 将比特流打印在标准输出上
 */
public class BinaryDump {
    public static void main(String[] args) {
        int width = Integer.parseInt(args[0]);
        int cnt;
        for (cnt = 0; !BinaryStdIn.isEmpty(); cnt++) {
            if (width == 0) {
                continue;
            }
            if (cnt != 0 && cnt % width == 0) {
                StdOut.println();
            }
            if (BinaryStdIn.readBoolean()) {
                StdOut.print("1");
            } else {
                StdOut.print("0");
            }
        }
        StdOut.println();
        StdOut.println(cnt + "bits");
    }
}
