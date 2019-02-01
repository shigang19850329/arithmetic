package algorithms.chapter4p4;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * 作者: 石刚
 * 时间: 2019/1/17 10:52
 * 版本 1.0
 * 算法4.9 最短路径Dijkstra算法
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
            distTo[s] = 0.0;

            pq.insert(s, 0.0);
            while (!pq.isEmpty()) {
                relax(G, pq.delMin());
            }
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    /**
     * 从顶点s到v的路径，如果不存在则为null
     */
    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    /**
     * 是否存在从顶点s到v的路径
     */
    private boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * throw an IllegalArgumentException unless {@code 0 <= v < V}
     */
    private void validateVertex(int s) {
        int v = distTo.length;
        if (s < 0 || s >= v) {
            throw new IllegalArgumentException("vertex " + s + " is not between 0 and " + (v - 1));
        }
    }
}
