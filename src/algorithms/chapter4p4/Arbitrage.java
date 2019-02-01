package algorithms.chapter4p4;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.BellmanFordSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

/**
 * 作者: 石刚
 * 时间: 2019/1/19 10:28
 * 版本 1.0
 * 货币兑换中的套汇 arbitirage
 */
public class Arbitrage {
    public static void main(String[] args) {
        int V= StdIn.readInt();
        String[] name=new String[V];
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++) {
            name[v]=StdIn.readString();
            for (int w = 0; w < V; w++) {
                double rate=StdIn.readDouble();
                DirectedEdge e=new DirectedEdge(v,w,-Math.log(rate));
                G.addEdge(e);
            }
        }
        BellmanFordSP spt=new BellmanFordSP(G,0);
        if (spt.hasNegativeCycle()){
            double stake=1000.0;
            for (DirectedEdge e:spt.negativeCycle()
                 ) {
                StdOut.printf("%10.5f %s",stake,name[e.from()]);

                stake*=Math.exp(-e.weight());
                StdOut.printf("=%10.5f %s\n",stake,name[e.to()]);
            }
        }
        else {
            StdOut.println("No arbitrage opportunity");
        }
    }
}
