package algorithms.chapter3p1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

 /**
  * 3.1.2 开发一个符号表的实现ArrayST，使用无序数组来实现我们的基本
  * API
  */
public class ArrayST<Key,Value> {
    private static final int INIT_SIZE =8;
    private Value[] vals;//符号表的值
    private Key[] keys;//符号表的索引键
    private int n = 0;//符号表的元素的数量

    //初始化该符号表
    public ArrayST (){
        keys = (Key[])new Object[INIT_SIZE];
        vals = (Value[])new Object[INIT_SIZE];
    }

    //根据n的大小返回符号表的大小
    public int size(){
        return n;
    }
    //判断符号表是否为空,根据size()是否返回0
    public boolean isEmpty(){
        return size()==0;
    }
    /**
     *  根据参数调整符号表的大小，先定义好新数组的长度，然后将原数组的值赋值给
     *  新数组的对应位置，最后将新数组的数组名赋值给原数组
     */
    private void resize(int capacity){
        Key[] tempk = (Key[])new Object[capacity];
        Value[] tempv = (Value[])new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i]=keys[i];
        }
        for (int i = 0; i < n; i++) {
            tempv[i]=vals[i];
        }
        keys=tempk;
        vals=tempv;
    }
    //往符号表里插入数据
    public void put(Key key,Value value){
        //删除重复的键
        delete(key);
        //如果空间有限，则扩大两倍数组的长度
        if (n>=vals.length) resize(2*n);
        //将数据加入数组
        vals[n]=value;
        keys[n]=key;
        n++;
    }
    //删除重复的key
    public void delete(Key key){
        for (int i = 0; i < n; i++) {
            if (key.equals(keys[i])){
                keys[i]=keys[n-1];
                vals[i]=vals[n-1];
                keys[n-1]=null;
                vals[n-1]=null;
                n--;
                if (n>0&&n==keys.length/4) resize(keys.length/2);
                return;
            }
        }
    }
    //循环遍历数组的长度，若找到对应的value则返回，没有则返回null
    public Value get(Key key){
        for (int i = 0; i < n; i++) {
            if (key.equals(keys[i])) return vals[i];
        }
        return null;
    }
    //遍历keys数组
    public Iterable<Key> keys(){
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < n; i++) {
            queue.add(keys[i]);
        }
        return queue;
    }

    public static void main(String[] args) {
        ArrayST<String,Integer> st = new ArrayST<String,Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key,i);
        }
        for (String s:st.keys()) {
            StdOut.println(s+" "+st.get(s));
        }
    }
}
