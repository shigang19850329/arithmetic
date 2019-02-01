package algorithms.chapter2p4;

import edu.princeton.cs.algs4.*;

/**
 * 一个优先队列的用例
 */
public class TopM {
    public static void main(String[] args) {
        //打印输入流中最大的M行
        int M = 5;
        MinPQ<Transaction> pq = new MinPQ<Transaction>(M + 1);
        while (StdIn.hasNextLine()) {
            //为下一行输入创建一个元素并放入优先队列中
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M)
                pq.delMin();//如果优先队列中存在M+1个元素则删除其中最小的元素
            //最大的M个元素都在优先队列中
        }
        Stack<Transaction> stack = new Stack<Transaction>();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Transaction t : stack) StdOut.println(t);
    }
}
