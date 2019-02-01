package algorithms.chapter2p4;

import edu.princeton.cs.algs4.StdOut;

/**
 * p2.4.3 无序链表实现优先队列大堆
 */
public class UnorderedList<Key extends Comparable<Key>> {
    private class Node {
        Key item;
        Node next;
    }

    private Node first;
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        Node item = new Node();
        item.item = v;
        item.next = first;
        first = item;
        N++;
    }

    public Key delMax() {
        Node item = new Node();
        item.next = first;
        Node maxItem = first;
        Node maxItemPrev = item;
        while (item.next.next != null) {
            if (less(maxItem.item, item.next.next.item)) {
                maxItem = item.next.next;
                maxItemPrev = item.next;
            }
            item = item.next;
        }
        Key max = maxItem.item;
        maxItemPrev.next = maxItem.next;
        if (first == maxItem) first = maxItem.next;
        maxItem = null;
        return max;
    }

    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        UnorderedList pq = new UnorderedList();
        pq.insert(1);
        pq.insert(3);
        StdOut.println(pq.delMax());
        pq.insert(2);
        StdOut.println(pq.delMax());
        StdOut.println(pq.delMax());
    }
}
