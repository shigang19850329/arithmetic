package algorithms.chapter4p4;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 加权有向图的数据类型
 */
public class EdgeWeightedDigraph {
    /**
     * 顶点总数
     */
    private final int V;
    /**
     * 边的总数
     */
    private int E;
    /**
     * 邻接表
     */
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<DirectedEdge>();
        }
    }

    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) {
            throw new IllegalArgumentException("Number of edges must be nonnegative");
        }
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            validateVertex(v);
            validateVertex(w);
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    /**
     * 将e添加到该有向图中
     *
     * @param e
     */
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        E++;
    }

    /**
     * 从v指出的边
     *
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    /**
     * 该有向图中的所有边
     *
     * @return edges
     */
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                bag.add(e);
            }
        }
        return bag;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }
}
