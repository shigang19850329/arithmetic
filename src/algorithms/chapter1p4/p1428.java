package algorithms.chapter1p4;


import edu.princeton.cs.algs4.Queue;

/**
 * 1.4.28 一个队列实现的栈。使用一个队列实现一个栈，使得每个栈操作所需的队列操作数量为线性级别。
 * 每次入队的时候将队列倒转，这样入队的就是最后一个元素了。
 */
public class p1428 {
    class QueueStack<Item>{
     Queue<Item> queue;
       //初始化一个栈
        public  QueueStack(){
            this.queue = new Queue<Item>();
        }

        /**
         * 添加一个元素
         * @param item
         */
        public void push(Item item){
            this.queue.enqueue(item);
            int size = this.queue.size();
            //倒转队列
            for (int i = 0; i < size; i++) {
                this.queue.enqueue(this.queue.dequeue());
            }
        }
        /**
         * 从栈中弹出一个元素
         */
        public Item pop(){
            return this.queue.dequeue();
        }
        /**
         * 判断栈是否为空
         */
        public boolean isEmpty(){
            return this.queue.isEmpty();
        }
    }
}
