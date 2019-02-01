package algorithms.chapter2p4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * 有序链表实现队列大堆，first存储最大元素
 */
public class OrderedList<Key extends Comparable<Key>>{
    private class Node{
        Key item;
        Node next;
    }
    private Node first;
    private int N =0;

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        Node newItem=new Node();
        newItem.item=v;

        Node item = new Node();
        item.next = first;

        while (item.next!=null&&less(newItem.item,item.next.item))
            item = item.next;

        newItem.next = item.next;
        item.next=newItem;
        //0节点为新加节点，或新节点为最大时修改first；
        if (first==null||first==newItem.next)
            first=newItem;
        N++;
    }
    public Key delMax(){
        Node maxItem = first;
        first = first.next;
        Key max=maxItem.item;
        N--;
        return max;

    }
    private boolean less(Key v,Key w)
    { return v.compareTo(w)<0;}

    public static void main(String[] args) {
        OrderedList pq = new OrderedList();
        pq.insert(1);
        pq.insert(3);
        StdOut.println(pq.delMax());
        pq.insert(2);
        StdOut.println(pq.delMax());
        StdOut.println(pq.delMax());
    }
}
