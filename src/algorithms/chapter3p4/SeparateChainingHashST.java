package algorithms.chapter3p4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SequentialSearchST;

import java.util.Collection;
import java.util.Iterator;


//基于拉链法的散列表
public class SeparateChainingHashST<Key,Value>{
    private int N;//键值对总数
    private int M;//散列表的大小
    private SequentialSearchST<Key,Value>[] st;//存放链表对象的数组
    public SeparateChainingHashST(){
        this(997);
    }
    public SeparateChainingHashST(int M) {
        //创建M条链条
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }
    private int hash(Key key){
        return(key.hashCode()&0x7fffffff)%M;
    }
    public Value get(Key key){
        return (Value)st[hash(key)].get(key);
    }
    public void put(Key key,Value val){
        st[hash(key)].put(key,val);
    }
    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key:st[i].keys()) {
                queue.enqueue(key);
            }
        }
        return queue;
    }
    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(int chains){
        SeparateChainingHashST<Key,Value> temp = new SeparateChainingHashST<>(chains);
        for (int i = 0; i < M; i++) {
            for (Key key:st[i].keys()) {
                temp.put(key,st[i].get(key));
            }
        }
        this.M = M;
        this.N = N;
        this.st = st;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    //删除键为Key的元素
    public void delete(Key key){
        if (key==null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) N--;
        st[i].delete(key);
    }
    //判断是否包含键为key的元素
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
}
