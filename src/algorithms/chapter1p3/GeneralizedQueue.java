package algorithms.chapter1p3;
/**
 * p1.3.38 删除第k个元素。实现一个类并支持列表中的API
 * public class GeneralizedQueue<Item>
 * GeneralizedQueue()  创建一条空队列
 * boolean  isEmpty()   判断队列是否为空
 * void insert(Item) 添加一个元素
 * Item delete(int A) 删除并返回最早插入的第k个元素
 * 首先用数组实现该数据类型，然后用链表实现该数据类型。
 */
public class GeneralizedQueue<Item> {
    private class GeneralizedItem<Item>{
        Item item;
        boolean hasDeleted;
    }
    public int size(){
        return a.length;
    }
    private GeneralizedItem[] a;
    private int head = 0;
    private int tail = 0;
    public GeneralizedQueue(int cap){
        a = new GeneralizedItem[cap];
    }
    private void resize(int size){
       int realSize = 0;
       GeneralizedItem<Item>[] temp = new GeneralizedItem[size];
        for (int i = 0; i < a.length; i++) {
            GeneralizedItem<Item> realItem = a[i];
            if (realItem!=null&&realItem.hasDeleted==false){
                temp[realSize++] = realItem;
            }
        }
        a = temp;
        tail = realSize;
        head = 0;
    }
    //插入元素
    public void insert(Item item){
        if (tail ==a.length-1){
            resize(a.length*2);
        }
        GeneralizedItem  realItem = new GeneralizedItem();
        realItem.item = item;
        a[tail++] = realItem;
    }
    //删除第k个元素
    public void delete(int k){
        int realSize = 0;
        int realIndex = 0;
        for (int i = 0; i < a.length; i++) {
            GeneralizedItem<Item> tempItem = a[i];
            if (tempItem!=null) {
              if (tempItem.hasDeleted==false){
                  if (k==realSize){
                      realIndex = i;
                  }
                  realSize++;
              }
            }
        }
        if (realSize == a.length/4){
            resize(a.length/2);
            GeneralizedItem<Item> realItem = a[k];
            realItem.hasDeleted = true;
        }else{
            GeneralizedItem<Item>  realItem = a[realIndex];
            realItem.hasDeleted = true;
        }

    }

    public static void main(String[] args) {
        GeneralizedQueue<String> queue = new GeneralizedQueue<>(2);
        queue.insert("To");
        queue.insert("Be");
        queue.insert("Or");
        queue.insert("Not");

        queue.delete(0);
        queue.delete(0);
        queue.delete(0);
    }
}
