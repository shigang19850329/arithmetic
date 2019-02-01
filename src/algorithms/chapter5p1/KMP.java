package algorithms.chapter5p1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 作者: 石刚
 * 时间: 2019/1/26 19:57
 * 版本 1.0
 * 算法5.6 Knuth-Morris-Pratt字符串查找算法
 */
public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        //由模式字符串构造DFA
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        for (int X = 0, j = 1; j < M; j++) {
            //计算dfa[][]
            for (int c = 0; c < R; c++) {
                //复制匹配失败情况下的值
                dfa[c][j] = dfa[c][X];
            }
            //设置匹配成功情况下的值。
            dfa[pat.charAt(j)][j] = j + 1;
            //更新重启状态
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        //在txt上模拟DFA的运行
        int i, j = 0, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        //找到匹配（到达模式字符串的结尾）
        if (j == M) {
            return i - M;
        }
        //未找到匹配（到达文本字符串的结尾）
        else {
            return N;
        }
    }

    /**
     * KMP字符串查找算法那的测试用例
     *
     * @param args
     */
    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];
        KMP kmp = new KMP(pat);
        StdOut.println("text:    " + txt);
        int offset = kmp.search(txt);
        StdOut.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            StdOut.print(" ");
        }
        StdOut.println(pat);
    }
}
