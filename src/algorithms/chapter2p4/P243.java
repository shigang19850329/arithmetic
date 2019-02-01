package algorithms.chapter2p4;

import edu.princeton.cs.algs4.StdOut;

/**
 * 用一下数据结构实现优先队列、支持插入元素和删除最大元素的操作：无序数组、
 * 有序数组、无序链表和链表。将你的4种实现中每种操作在最坏情况下的运行时间
 * 上下限制成一张表格。
 */
public class P243<Key extends Comparable<Key>> {
    //无序数组实现优先队列
    private Key[] pq;
    private int N = 0;

    public P243(int maxN) {
        pq = (Key[]) new Comparable[maxN];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[N++] = v;
    }

    public Key delMax() {
        int maxIndex = 0;
        for (int i = 0; i < N; i++)
            if (less(maxIndex, i))
                maxIndex = i;
        Key max = pq[maxIndex];
        N--;
        exch(maxIndex, N);
        pq[N] = null;

        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        P243 p = new P243(3);
        p.insert(1);
        p.insert(3);
        StdOut.println(p.delMax());
        p.insert(2);
        StdOut.println(p.delMax());
        StdOut.println(p.delMax());
    }
}
