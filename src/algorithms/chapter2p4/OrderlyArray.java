package algorithms.chapter2p4;

import edu.princeton.cs.algs4.StdOut;

/**
 * p2.4.3 有序数组的实现优先队列大堆，pq[n]存储最小元素
 *
 */
public class OrderlyArray <Key extends Comparable<Key>> {
   private Key[] pq;
   private int N=0;

   public OrderlyArray(int max){
       pq=(Key[])new Comparable[max];
   }

   public boolean isEmpty(){
       return N ==0;
   }
   public int size(){
       return N;
   }
   public void insert(Key v){
       int i;
       for ( i = N-1; i>0&&less(v,pq[i]) ; i--)
           pq[i+1]=pq[i];
       pq[i+1] =v;
     N++;
   }
   public Key delMax(){
       Key max = pq[--N];
       pq[N]=null;
       return max;
   }

    private boolean less(Key v,Key w)
    { return v.compareTo(w)<0;}

    private void exch(int i,int j)
    {
        Key tmp=pq[i];
        pq[i]=pq[j];
        pq[j]=tmp;
    }

    public static void main(String[] args) {
        OrderlyArray pq = new OrderlyArray(3);
        pq.insert(1);
        pq.insert(3);
        StdOut.println(pq.delMax());
        pq.insert(2);
        StdOut.println(pq.delMax());
        StdOut.println(pq.delMax());
    }
}
