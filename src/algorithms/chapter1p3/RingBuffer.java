package algorithms.chapter1p3;

/**
 * 1.3.39 环形缓冲区。环形缓冲区，又称为环形队列，是一种定长为 N
 * 的先进先出的数据结构。它在进程间的异步数据传输或记录日志文件时十分有用。当缓冲区为空时，消费者会在数据存入缓冲区前等待；当缓冲区满时，生产者会等待数据存入缓冲区。为
 * RingBuffer 设计一份 API 并用（回环）数组将其实现。
 */
public class RingBuffer<Item> {
    private Item[] a;

    private int writePos = 0;
    private int readPos = 0;
    private boolean flipped = false;//the flip marker

    public RingBuffer(int cap) {
        a = (Item[]) new Object[cap];
    }

    public void reset() {
      this.writePos = 0;
      this.readPos = 0;
      this.flipped = false;
    }
    public int size(){
        return a.length;
    }
    public int available(){
        if (!flipped){
            return writePos-readPos;
        }
        return size()-readPos+writePos;
    }
    public int remainingCapacity(){
        if (!flipped){
            return size()-writePos;
        }
        return readPos - writePos;
    }
    public boolean put(Item x){
        if (!flipped){
            if (writePos == size()){
                writePos = 0;
                flipped = true;

                if (writePos<readPos){
                    a[writePos++] = x;
                    return true;
                }else {
                    return false;
                }
            }else{
                a[writePos++]=x;
                return true;
            }
        }else{
            if (writePos<readPos){
                a[writePos++] = x;
                return true;
            }else {
                return false;
            }
          }
        }
        public Item take(){
        if (!flipped){
            if (readPos<writePos){
                return a[readPos++];
            }else {
                return null;
            }
        } else{
          if (readPos == size()){
          readPos = 0;
          flipped = false;
          if (readPos<writePos){
              return a[readPos++];
          }else {
              return null;
          }
          }else{
              return a[readPos++];
          }
        }
     }

    public static void main(String[] args) {
        int cap = 10;
        RingBuffer<String> buffer = new RingBuffer<String>(cap);
        //测试用例
        for (int i = 0; i < cap; i++) {
            String inputItem = i + "";
            boolean putSuccess = buffer.put(inputItem);
            System.out.println(putSuccess?"插入"+inputItem+"成功":"插入"+inputItem+"失败");
        }
        //测试用例2
        for (int i = 0; i < cap + 1; i++) {
            if (i==cap-1){
                String takeItem = buffer.take();
                System.out.println("取出"+takeItem+"成功");
            }
            if (i == cap){
                String takeItem = buffer.take();
                System.out.println("取出"+takeItem+"成功");
            }

            String inputItem = i + "";
            boolean putSuccess = buffer.put(inputItem);
            System.out.println(putSuccess?"插入"+inputItem+"成功":"插入"+inputItem+"失败");
        }
    }
}

