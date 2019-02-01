package algorithms.chapter5p4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;
import edu.princeton.cs.algs4.Stack;

/**
 * 作者: 石刚
 * 时间: 2019/1/29 18:23
 * 版本 1.0
 * 算法5.9 正则表达式的模式匹配（grep）
 */
public class NFA {
    /**
     * 匹配转换
     */
    private char[] re;
    /**
     * epsilon转换 ε希腊语的第5个字母
     */
    private Digraph G;
    /**
     * 状态数量
     */
    private int M;

    public NFA(String regexp) {
        //根据给定的正则表达式构造NFA
        Stack<Integer> ops = new Stack<Integer>();
        re = regexp.toCharArray();
        M = re.length;
        G = new Digraph(M + 1);

        for (int i = 0; i < M; i++) {
            int lp = i;
            if (re[i] == '(' || re[i] == '|') {
                ops.push(i);
            } else if (re[i] == ')') {
                int or = ops.pop();
                if (re[or] == '|') {
                    lp = ops.pop();
                    G.addEdge(lp, or + 1);
                    G.addEdge(or, i);
                } else {
                    lp = or;
                }
            }
            if (i < M - 1 && re[i + 1] == '*') {
                //查看下一个字符
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }
            if (re[i] == '(' || re[i] == '*' || re[i] == ')') {
                G.addEdge(i, i + 1);
            }
        }
    }

    public boolean recognizes(String txt) {
        //NFA是否能够识别文本txt
        Bag<Integer> pc = new Bag<Integer>();
        DirectedDFS dfs = new DirectedDFS(G, 0);
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) {
                pc.add(v);
            }
        }
        for (int i = 0; i < txt.length(); i++) {
            //计算txt[i+1]可能到达的所有NFA状态
            Bag<Integer> match = new Bag<Integer>();
            for (int v : pc) {
                if (v < M) {
                    if (re[v] == txt.charAt(i) || re[v] == '.') {
                        match.add(v + 1);
                    }
                }
            }
            pc = new Bag<Integer>();
            dfs = new DirectedDFS(G, match);
            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) {
                    pc.add(v);
                }
            }
        }
        for (int v : pc) {
            if (v == M) {
                return true;
            }
        }
        return false;
    }
}
