package algorithms.chapter5p1;

/**
 * 作者: 石刚
 * 时间: 2019/1/23 22:40
 * 版本 1.0
 * 算法5.5 基于三向单词查找树的符号表
 */
public class TST<Value> {
    //树的根结点
    private Node root;

    private class Node {
        /**
         * 字符
         */
        char c;
        /**
         * 左中右子三向单词查找树
         */
        Node left, mid, right;
        /**
         * 和字符串相关联的值
         */
        Value val;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left, key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        } else {
            return x;
        }
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c) {
            x.left = put(x.left, key, val, d);
        } else if (c > x.c) {
            x.right = put(x.right, key, val, d);
        } else if (d < key.length() - 1) {
            x.mid = put(x.mid, key, val, d + 1);
        } else {
            x.val = val;
        }
        return x;
    }
}
