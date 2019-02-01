package algorithms.chapter1p4;

import java.util.Stack;

/**
 * 1.4.29两个栈实现的steque。用两个站实现一个steque，使得每个steque操作所需的栈
 * 操均摊后为一个常数。
 * 和用两个栈实现队列的方法类似。
 * push 的时候把右侧栈内容倒到左侧栈，之后再入栈。
 * pop 的时候也做相同操作，右侧栈内容进左侧栈，之后再出栈。
 * enqueue 的时候则将左侧栈内容倒到右侧栈，之后再入队。
 */
public class Steque <Item>{
   Stack<Item> H;
   Stack<Item> T;

   //初始化一个Steque
    public Steque(){
        this.H = new Stack<Item>();
        this.T = new Stack<Item>();
    }
    //入栈
    public void push(Item item){
        reverseT();
        this.H.push(item);
    }
    //把H中的元素压入T中
    private void reverseT(){
      while (!this.H.isEmpty()){
          this.T.push(this.H.pop());
      }
    }
    //将T中的元素压入H中
    private void reverseH(){
        while (!this.H.isEmpty())
        {
            this.T.push(this.H.pop());
        }
    }
    //从Steque中弹出一个元素
    public Item pop(){
      reverseT();
      return this.H.pop();
    }
    //Steque在队尾添加一个元素
    public void enqueue(Item item){
        reverseH();
        this.T.push(item);
    }
    //检查是否为空
    public boolean isEmpty(){
        return this.H.isEmpty()&&this.T.isEmpty();
    }
}
