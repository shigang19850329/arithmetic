package algorithms.chapter1p3;

import edu.princeton.cs.algs4.Queue;

/**
 * 复制队列。编写一个新的构造函数，使以下代码
 Queue<Item> r=new Queue<Item>(q);
 得到的r指向队列q的一个新的独立的副本。可以对q或r进行任意入列或出列的操作但它们不会相互影响。提示：从q中取出所有的元素再将它们插入q和r。
 */
public class p1341 {
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        int thisSize = q.size();
        for (int i = 0; i < thisSize; i++) {
            String item = q.dequeue();
            //this.enqueue(item);
            q.enqueue(item);
        }
    }

}
