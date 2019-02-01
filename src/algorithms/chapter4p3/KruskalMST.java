package algorithms.chapter4p3;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;

/**
 * 算法4.8 最小生成树的Kruskal算法
 * Kruskal算法的实现：我们将会使用一条优先队列来将边按照权重排序，
 * 用一个union-find数据结构来识别会形成环的边，以及一条队列来保存
 * 最小生成树的所有边。注意，使用队列来保存最小生成树的所有边意味着
 * 用例在遍历时将会按照权重的升序得到这些边。weight()方法需要遍历
 * 所有边来取得权重之和（或是使用一个变量动态统计权重之和）。
 */
public class KruskalMST {
    /**
     *  最小生成树所有的边
     */
    private Queue<Edge> mst;
    /**
     * 最小生成树总权重
     */
    private double weight;

    public KruskalMST(EdgeWeightedGraph G){
        mst=new Queue<Edge>();
        MinPQ<Edge> pq =new MinPQ<Edge>();
        for (Edge e:G.edges()
             ) {
            pq.insert(e);
        }
        UF uf=new UF(G.V());

        while (!pq.isEmpty()&&mst.size()<G.V()-1){
            //从pq得到权重最小的边和它的顶点
            Edge e = pq.delMin();
            int v =e.either(),w=e.other(v);

            if (uf.connected(v,w)){
                //忽略失效的边
                continue;
            }
            //合并分量
            uf.union(v,w);
            //将边添加到最小生成树中
            mst.enqueue(e);
            weight+=e.weight();
        }
    }

    /**
     * 返回最小生成树所有的边
     * @return Iterable<Edge></>
     */
    public Iterable<Edge> edges(){
        return mst;
    }
    public double weight(){
      return weight;
    }
    public static void main(String[] args) {
       In in=new In(args[0]);
       EdgeWeightedGraph G;
       G=new EdgeWeightedGraph(in);

       KruskalMST mst = new KruskalMST(G);
        for (Edge e:mst.edges()) {
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }
}
