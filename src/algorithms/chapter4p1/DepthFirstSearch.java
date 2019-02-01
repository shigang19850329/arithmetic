package algorithms.chapter4p1;

import edu.princeton.cs.algs4.Graph;

//深度优先搜索，寻找所有和顶点连通的顶点。
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];//G.V();返回顶点的总数
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) //G.adj(v)返回和v相连的点的集合
            if (!marked[w])
                dfs(G, w);
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
