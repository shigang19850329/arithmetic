package algorithms.chapter1p3;

import edu.princeton.cs.algs4.StdOut;

/**
 *  1.3.40 前移编码。从标准输入读取一串字符，使用链表保存这些字符并删除重复字符。当你读取了一个从未见过的字符时，将它插入表头。当你读取了一个重复的字符时，将它从链表中删去并再次插入表头。将你的程序命名为 MoveToFront：它实现了著名的前移编码策略，这种策略假设最近访问过的元素很可能会再次访
 * 问，因此可以用于缓存、数据压缩等许多场景。
 */
public class p1340 {
    private static class Node{
        Node next = null;
        String data;
    }
    private static class MoveToFront{
        private Node first;
        private int N = 0;
        private boolean isRepeat(String s){
            if (first == null){
                return false;
            }
            Node current = first;
            while (current.next!=null){
                if (current.next.data.equals(s)){
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
            return false;
        }
        public  MoveToFront(){
            String[] a  = {"1","2","3","4","5","3"};
            for (int i = 0; i < a.length; i++) {
                String s = a[i];
                isRepeat(s);
                if (first==null){
                    first = new Node();
                    first.data = s;
                }else {
                    Node current = new Node();
                    current.data = s;
                    current.next = first;
                    first = current;
                }
            }
        }
        public String toString(){
            String ret = "";
            if (first==null)
                return ret;
            Node current = first;
            ret = first.data;
            while (current.next!=null){
                ret = ret + " " + current.next.data;
                current = current.next;
            }
            return ret;
        }
        public void push(String s){
            Node oldfirst = first;
            first = new Node();
            first.data = s;
            first.next = oldfirst;
            N++;
        }

    public static void main(String[] args) {
        MoveToFront m = new MoveToFront();
        StdOut.print(m);
    }
}
}
