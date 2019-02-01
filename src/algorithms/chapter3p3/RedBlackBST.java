package algorithms.chapter3p3;

import edu.princeton.cs.algs4.Queue;

import java.util.NoSuchElementException;

/**
 * 红黑二叉查找树
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;//二叉查找树的根结点
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;//键
        Value val;//相关联的值
        Node left, right;//左右子树
        int N;//这棵子树中的结点总数
        boolean color;//由其父结点指向它的链接的颜色

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    //空的构造函数
    public RedBlackBST() {

    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    //判断是否为空
    public boolean isEmpty() {
        return root == null;
    }

    //左旋转
    Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    //右旋转
    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    //变换颜色
    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    //红黑树的插入算法
    public void put(Key key, Value val) {
        //查找key，找到则更新其值，否则为它新键一个结点
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) //标准的插入操作，和父结点用红链接相连
            return new Node(key, val, 1, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    /**
     * 获取键为key的值
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }

    /**
     * value associated with the given key in subtree rooted at x; null if no such key
     * 在根结点为x的子树中查找键为key相关联的值，如果没有则返回null
     */
    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    /**
     * 是否包含键值为key的元素。
     *
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    /**
     * Removes the smallest key and associated value from the symbol table.
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin(){
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        //如果根结点的两个子结点都是黑色，把根结点变成红色
        if (!isRed(root.left)&&!isRed(root.right))
            root.color=RED;
        root=deleteMin(root);
        if (!isEmpty()) root.color=BLACK;
    }
    private Node deleteMin(Node h){
        if (h.left==null) return null;
        if (!isRed(h.left)&&!isRed(h.left.left))
            h=moveRedLeft(h);

        h.left = deleteMin(h.left);
        return balance(h);
    }
  private Node moveRedLeft(Node h){
        //假设结点h为红色，h.left和h.left.left都是黑色，
      //将h.left或者h.left的子结点之一变红
      flipColor(h);
      if (isRed(h.right.left)){
          h.right = rotateRight(h.right);
          h=rotateLeft(h);
      }
      return h;
  }
  //不变的存储红黑树
private Node balance(Node h){
        //假设h!=null
       if (isRed(h.right)) rotateLeft(h);
       if (isRed(h.left)&&isRed(h.left.left)) rotateRight(h);
       if (isRed(h.left)&&isRed(h.right)) flipColor(h);

       h.N =  1+size(h.left)+size(h.right);
       return h;
   }
    private void flipColor(Node h) {
        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }
    private Node moveRedRight(Node h){
        /**
         * 假设结点h为红色，h.right和h.right.left都是黑色，
         * 将h.right或者h.right的子结点之一变红
         */
        flipColor(h);
        if (isRed(h.left.left)){
            h=rotateRight(h);
        }
        return h;
    }
    /**
     * 删除最大元素
     */
    public void deleteMax(){
        if (!isRed(root.left)&&!isRed(root.right))
            root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }
    private Node deleteMax(Node h){
        if (isRed(h.left))
            h = rotateRight(h);
        if (h.right==null)
            return null;
        if (!isRed(h.right)&&!isRed(h.right.left))
            h = moveRedRight(h);
        h.right = deleteMax(h.right);
        return balance(h);
    }
    public void delete(Key key){
        if (!isRed(root.left)&&!isRed(root.right))
            root.color = RED;
        root = delete(root,key);
        if (!isEmpty()) root.color = BLACK;
    }
    private Node delete(Node h ,Key key){
        if (key.compareTo(h.key)<0){
            if (!isRed(h.left)&&!isRed(h.left.left))
                h=moveRedLeft(h);
            h.left = delete(h.left,key);
        }
        else{
            if (isRed(h.left))
                h=rotateRight(h);
            if (key.compareTo(h.key) == 0 &&(h.right==null))
                return null;
            if (!isRed(h.right)&&!isRed(h.right.left))
                h=moveRedRight(h);
            if (key.compareTo(h.key)==0){
                h.val=get(h.right,min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right,key);
        }
        return balance(h);
    }
    public Key min(){
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }
    private Node min(Node x){
        if (x.left==null) return x;
        else return min(x.left);
    }
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }
    private Node max(Node x) {
        // assert x != null;
        if (x.right == null) return x;
        else            return max(x.right);
    }

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     * @param key
     * @return
     */
   public Key floor(Key key){
        if (key==null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty())
            throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root,key);
        if (x==null) return null;
        else return x.key;
   }
   private Node floor(Node x,Key key){
       if (x==null) return null;
       int cmp = key.compareTo(x.key);
       if (cmp==0) return x;
       if (cmp<0) floor(x.left,key);
       Node t = floor(x.right,key);
       if (t!=null) return t;
       else return x;
   }
    /**
     * Returns the smallest key in the symbol table greater than or equal to {@code key}
     */
    public Key ceiling(Key key){
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
        Node x = ceiling(root,key);
        if (x==null) return null;
        else return x.key;
    }
    private Node ceiling(Node x,Key key){
        if (x==null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp==0) return x;
        if (cmp>0) return ceiling(x.right,key);
        Node t = ceiling(x.left,key);
        if (t!=null) return t;
        else return x;
    }
    /**
     * 返回地k大的元素
     */
    public Key select(int k){
        if (k<0||k>size())
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        Node x = select(root,k);
        return x.key;
    }
    // the key of rank k in the subtree rooted at x
    private Node select(Node x,int k){
        // assert x != null;
        // assert k >= 0 && k < size(x);
        int t = size(x.left);
        if (t>k) return select(x.left,k);
        else if (t<k) return select(x.right,k-t-1);
        else return x;
    }
    /**
     * Return the number of keys in the symbol table strictly less than {@code key}.
     */
    public int rank(Key key){
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key,root);
    }
    private int rank(Key key,Node x){
        if (x==null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp<0) return rank(key,x.left);
        else if (cmp>0) return 1+size(x.left)+rank(key,x.right);
        else return size(x.left);
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * @return
     */
    public Iterable<Key> keys(){
        if (isEmpty()) return new Queue<Key>();
        return keys(min(),max());
    }

    /**
     * Returns all keys in the symbol table in the given range,
     *      * as an {@code Iterable}.
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<Key> keys(Key lo,Key hi){
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root,queue,lo,hi);
        return queue;
    }
    // add the keys between lo and hi in the subtree rooted at x
    // to the queue
    public void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if (x==null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);

        if (cmplo<0) keys(x.left,queue,lo,hi);
        if (cmplo<=0&&cmphi>=0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }
}
