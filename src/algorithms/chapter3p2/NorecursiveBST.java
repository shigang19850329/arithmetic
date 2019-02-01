package algorithms.chapter3p2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class NorecursiveBST<Key extends Comparable<Key>, Value> {
    //root of BST
    private Node root;

    private class Node {
        private Key key;//sorted by key;
        private Value val;//associated value;
        private Node left, right;//left and right subtrees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    /***************************************************************************
     *  Insert key-value pair into symbol table (nonrecursive version).
     ***************************************************************************/
    public void put(Key key, Value val) {
        Node z = new Node(key, val);
        if (root == null) {
            root = z;
            return;
        }

        Node parent = null;
        Node x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = val;
                return;
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left = z;
        else  parent.right = z;
    }

    /***************************************************************************
     *  Search BST for given key, nonrecursive version.
     ***************************************************************************/
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    /**
     * inorder traversal 中序遍历
     */
    public Iterable<Key> keys() {
        Stack<Node> stack = new Stack<Node>();
        Queue<Key> queue = new Queue<Key>();
        Node x = root;
        while (x != null || stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            } else {
                x = stack.pop();
                queue.enqueue(x.key);
                x = x.right;
            }
        }
        return queue;
    }

    /**
     *测试
     */
    public static void main(String[] args) {
       String[] a ={"S","E","A","R","C","H","E","X","A","M","P","L","E"};
       int n = a.length;
       NorecursiveBST<String,Integer> st = new NorecursiveBST<String,Integer>();
        for (int i = 0; i < n; i++) {
            st.put(a[i],i);
        }
        for (String s : st.keys()) {
            StdOut.println(s+" "+st.get(s));
        }
    }
}
