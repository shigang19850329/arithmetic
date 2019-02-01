package algorithms.chapter3p1;

import edu.princeton.cs.algs4.Queue;

/**
 *   239页
 *  算法3.2 二分查找（基于有序数组）
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;
    public BinarySearchST(int capacity){
        //调整数组大小的标准代码请见算法1.1
        keys=(Key[])new Comparable[capacity];
        vals = (Value[])new Comparable[capacity];
    }

    public int size(){return N;}

    public Value get(Key key){
        if (isEmpty()) return null;
        int i =rank(key);
        if (i<N&&keys[i].compareTo(key)==0) return vals[i];
        else return null;
    }

    public boolean isEmpty(){return size()==0;}

    /**
     * 计算小于给定键的键的数量
     * @param key
     * @return
     */
    public int rank(Key key){
        int lo = 0,hi = N-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp<0) hi=mid-1;
            else if (cmp>0) lo=mid+1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key,Value val){
        //查找键，找到则更新值，否则创建新的元素
        int i =rank(key);
        if (i<N&&keys[i].compareTo(key)==0){
            vals[i]=val;return;
        }
        for (int j = N; j >i ; j--) {
            keys[j]=keys[j-1];
            vals[j]=vals[j-1];
        }
        keys[i]=key;
        vals[i]=val;
        N++;
    }
    //递归的二分查找
    public int rank(Key key,int lo,int hi){
        if (hi<lo) return lo;
        int mid  =lo+(hi-lo)/2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp <0) return rank(key,lo,mid-1);
        else if (cmp>0)
            return rank(key,mid+1,hi);
        else return mid;
    }
    //返回最小键
    public Key min(){
        return keys[0];
    }
    //返回最大键
    public Key max(){
        return keys[N-1];
    }
    //排名为K的键
    public Key select(int k){
        return keys[k];
    }
    //返回大于等于key的最小键
    public Key ceiling(Key key){
        int i = rank(key);
        return keys[i];
    }
    //返回小于等于key的最大键
    public Key floor(Key key){
      if (key==null) throw new IllegalArgumentException("argument to floor() is null");
      int i=rank(key);
      if (i<N&&key.compareTo(keys[i])==0) return keys[i];
      if (i==0) return null;
      else return keys[i-1];
    }
    public Key delete(Key key){
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (isEmpty()) return null;

        //compute rank
        int i =rank(key);
        if (i==N||key.compareTo(keys[i])!=0)
            return null;
        Key result = keys[i];
        for (int j = i; j < N-1; j++) {
            keys[j]=keys[j+1];
            vals[j]=vals[j+1];
        }
        N--;
        keys[N] = null;  // to avoid loitering
        vals[N] = null;
        // resize if 1/4 full
        if (N > 0 && N == keys.length/4) resize(keys.length/2);
        return result;
    }
    // resize the underlying arrays
    private void resize(int capacity) {
        assert capacity >= N;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }
    public Iterable<Key> keys(Key lo,Key hi) {
       Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i <rank(hi) ; i++)
            q.enqueue(keys[i]);
      if (contains(hi))
            q.enqueue(keys[rank(hi)]);
      return q;
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
}
