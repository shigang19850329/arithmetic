package algorithms.chapter4p1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

//算法4.2 使用广度优先搜索查找图中的路径
public class BreadthFirstPaths {
    private boolean[] marked;//到达该顶点的最短路径已知吗？
    private int[] edgeTo;//到达该顶点的已知路径上的最后一个顶点
    private final int s;//起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    //广度优先搜索的实现
    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;//标记起点
        queue.enqueue(s);//起点加入队列
        while (!queue.isEmpty()) {
            int v = queue.dequeue();//从队列中删去下一个顶点
            for (int w : G.adj(v)
            )
                if (!marked[w]) {//对于每个未被标记的相邻顶点
                    edgeTo[w] = v;//保存最短路径的最后一个顶点
                    marked[w] = true;//标记它，因为最短路径已出
                    queue.enqueue(w);//将它添加到队列中
                }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        //和深度优先搜索中的实现相同
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);

        path.push(s);
        return path;
    }
}
