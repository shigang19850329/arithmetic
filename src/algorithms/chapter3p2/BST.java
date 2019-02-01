package algorithms.chapter3p2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * 基于二叉查找树的符号表
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;//二叉查找树的根结点

    private class Node {
        private Key key;//键
        private Value val;//值
        private Node left, right;//指向子树的链接
        private int N;//以该结点为根的子树中的结点总数

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        /**
         * 在以x为根结点的子树中查找并返回key对应的值
         * 如果找不到则返回null
         */
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        //查找key,找到更新它，否则为它创建一个新的结点
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        /**
         * 如果key存在于以x为根结点的子树中则更新它的值；
         * 否则将以key和val为键值对的新结点插入到该树中。
         */
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 算法3.3（续2） 二叉查找树中max(),min(),floor(),ceiling()方法的实现
     */
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    /**
     * 算法3.3（续2）二叉查找树中select()和rank()方法的实现
     */
    public Key select(int k) {
        return select(root, k).key;
    }

    /**
     * 加入我们想找到排名为k的键（即树中正好有k个小于它的键）。
     * 如果左子树中的结点数t大于k，那么我们就继续（递归地）在
     * 左子树中查找排名为k的键；如果t等于k，我们就返回根结点中
     * 的键;如果小于k，我们就递归地在右子树中查找排名为k-t-1的键
     */
    private Node select(Node x, int k) {
        //返回排名为k的结点
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    /**
     * rank()是select()的逆方法，它会返回给定键的排名。实现和select()类似：
     * 如果给定的键和根结点的键相等，我们返回左子树中的结点总数t，如果给定的
     * 键小于根结点，我们会返回该键在左子树中的排名（递归计算），如果给定的键
     * 大于根结点，我们会返回t+1(根结点)加上它在右子树中的排名（递归计算）。
     */
    private int rank(Key key, Node x) {
        //返回以x为根结点的子树中小于x.key的键的数量
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }
    /**
     * 算法3.3 （续4）二叉查找树的delete()方法的实现
     */
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if (x.left==null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
    //删除键为key的结点
    public void delete(Key key){
        root=delete(root,key);
    }
    private Node delete(Node x,Key key){
        if (x==null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp<0) x.left = delete(x.left,key);
        else if (cmp>0) x.right=delete(x.right,key);
        else {
            if (x.right==null) return x.left;
            if (x.left==null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right =deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }

    /**
     *按顺序打印二叉查找树中的所有键
     */
    private void print(Node x){
        if (x==null) return;
        print(x.left);
        StdOut.println(x.key);
        print(x.right);
    }
    /**
     * 算法3.3（续5） 二叉查找树的范围查找操作
     */
    public Iterable<Key> keys(){
        return keys(min(),max());
    }
    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new Queue<Key>();
        keys(root,queue,lo,hi);
        return queue;
    }
    private void keys(Node x,Queue<Key> queue,Key lo,Key hi){
        if (x==null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo<0) keys(x.left,queue,lo,hi);
        if (cmplo<=0&&cmphi>=0) queue.enqueue(x.key);
        if (cmphi>0) keys(x.right,queue,lo,hi);
    }
    public Key max(){
        return max(root).key;
    }
    public Node max(Node x){
        if (x.right==null) return x;
        else return max(x.right);
    }

    /**
     * 返回树的高度
     * @return
     */
    public int height(){
        return height(root);
    }
    private int height(Node x){
        if (x==null) return -1;
        return 1+Math.max(height(x.left),height(x.right));
    }

    public static void main(String[] args) {

    }

}

