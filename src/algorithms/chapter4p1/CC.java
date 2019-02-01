package algorithms.chapter4p1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 算法4.3 使用深度优先搜索找出图中所有连通分量
 * CC的实现使用了marked[]数组来寻找一个顶点作为每个连通
 * 分量中深度优先搜索的起点。递归的深度优先搜索第一次调用
 * 的参数是顶点0——它会标记所有与0连通的顶点。然后构造函数
 * 中的for循环会查找每个没有被标记的顶点并递归调用dfs()来标记
 * 和它相邻的所有顶点。它还使用了一个以顶点作为索引的数组id[]
 * ，将同一个连通分量中的顶点和连通分量的标识符关联起来
 * （int值）。这个数组使得connected()方法的实现变得十分简单。
 * 标识0会被赋予第一个连通分量中的所有顶点。。。
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    //查找连通分量API的测试用例
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);
        int M = cc.count();
        StdOut.println(M + " components");

        Bag<Integer>[] components;
        components = (Bag<Integer>[]) new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }
        for (int i = 0; i < M; i++) {
            for (int v :
                    components[i])
                StdOut.print(v + " ");
            StdOut.println();

        }
    }
}
