package algorithms.chapter1p3;

import java.util.Stack;

/**
 * 文本编辑的缓冲区。为文本编辑器的缓冲区设计一种数据类型并实现表1.3.13中的API。

 表1.3.13 文本缓冲区的API
 public class Buffer	 
 Buffer()	创建一个空缓冲区
 void insert(char c)	在光标位置插入一个字符c
 char delete()	删除并返回光标位置的字符
 void left(int k)	将光标向左移动k个位置
 void right(int k)	将光标向右移动k个位置
 int size()	缓冲区中的字符数量
  	 
 提示：使用两个栈。

 建立两个栈，一个左栈，一个右栈，输入时将数据压入左栈，其实光标位置就是左栈的栈头，向左向右移动就是其中一个栈pop（）一些元素给另一个栈来模拟光标移动。
 */
public class Buffer {
    Stack<Character> left = new Stack<Character>();
    Stack<Character> right = new Stack<Character>();
    public int size(){
        return left.size()+right.size();
    }
    public void insert(char c){
        left.push(c);
    }
    public char delete(){
        return left.pop();
    }
    public void left(int k){
        if (k>left.size()){
            return;
        }
        for (int i = 0; i < k; i++) {
            right.push(left.pop());
        }
    }
    public void right(int k){
        if (k>right.size())
            return;
        for (int i = 0; i < k; i++) {
            left.push(right.pop());
        }
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        String str = "photograph";
        for (int i = 0; i < str.length(); i++) {
            buffer.insert(str.charAt(i));
        }
        buffer.left(4);
        buffer.delete();
        buffer.right(2);
        buffer.insert('a');
        buffer.right(2);
        for(Character c:buffer.left)
            System.out.print(c+" ");
        for(Character c:buffer.right)
            System.out.print(c+" ");
    }
}
