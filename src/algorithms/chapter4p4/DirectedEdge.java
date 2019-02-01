package algorithms.chapter4p4;

/**
 * 加权有向边的数据类型
 */
public class DirectedEdge {
    /**
     * 边的起点
     */
    private final int v;
    /**
     * 边的终点
     */
    private final int w;
    /**
     * 边的权重
     */
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 边的权重
     * @return weight
     */
    public double weight() {
        return weight;
    }

    /**
     * 指出这条边的顶点
     * @return v
     */
    public int from() {
        return v;
    }

    /**
     * 这条边指向的顶点
     * @return w
     */
    public int to() {
        return w;
    }
    @Override
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
