package algorithms.chapter4p1;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Stack;

/**
 * 寻找有向环
 * 该类为标准的递归dfs()方法添加了一个布尔类型的数组onStack[]来保存
 * 递归调用栈上的所有顶点。当它找到一条边v->w且w在栈中时，它就找到了
 * 一个有向环。环上的所有顶点可以通过edgeTo[]中的链接得到。
 * 在执行dfs(G,v)时，查找的是一条由起点到v的有向路径。要保存这条路径，
 * DirectedCycle维护了一个由顶点索引的数组onStack[],以标记递归调用的栈上
 * 的所有顶点（在调用dfs(G,v)时将onStack[v]设为true，在调用结束时将其
 * 设为false）。DirectedCycle同时也使用了一个edgeTo[]数组，在找到有向环时
 * 返回环中的所有顶点。
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;//有向环中的所有顶点（如果存在）
    private boolean[] onStack;//递归调用的栈上的所有顶点

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v])
                dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (this.hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = 0; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
