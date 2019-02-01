package algorithms.chapter1p5;
/**
 * 使用quick-union算法处理序列9-0,3-4,5-8,7-2,2-1,5-7,0-3,4-2。对于输入的每一对整数，
 * 给出id[]数组的内容和访问数组的次数。
 *
 * 解答
 quick-find 的官方实现：QuickFindUF.java。
 只要实现相应并查集，然后输入内容即可。
 增加一个记录访问数组次数的类成员变量，在每次访问数组的语句执行后自增即可。
 */
public class QuickFind {
    private int[] id;//access to component id;
    private int count;//number of components
   //数组访问次数
    int eachDoUnionArrayAccessTimes = 0;

    public QuickFind(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int find(int p){
        eachDoUnionArrayAccessTimes++;
        return id[p];
    }

    public void union(int p,int q){//put p and q into the same component
        boolean printDetail = true;
        if (printDetail){
            eachDoUnionArrayAccessTimes = 0;
            System.out.println("开始联通分量：" + p + "和" + q);
        }
        int pID = find(p);
        int qID = find(q);
        //Nothing to do if p and q are already in the same component
        if (pID == qID) return;
        //Rename p's component to q's name
        for (int i = 0; i < id.length; i++) {
            eachDoUnionArrayAccessTimes++;
            if (id[i] == pID) {
                eachDoUnionArrayAccessTimes++;
                id[i] = qID;
            }
        }
        count--;
        if (printDetail){
            /**
             * 一下代码输出数组元素
             */
            System.out.print("id:{");
            for (int i = 0; i < id.length; i++) {
                if (i == id.length-1){
                    System.out.print(id[i]);
                }else{
                    System.out.print(id[i] + ",");
                }
            }
            System.out.print("}");
            System.out.println("");
            System.out.println("数组访问的次数:"+eachDoUnionArrayAccessTimes);
        }
    }

    public static void main(String[] args) {
        QuickFind find = new QuickFind(10);
        find.union(9,0);
        find.union(9,0);
        find.union(3,4);
        find.union(5,8);
        find.union(7,2);
        find.union(2,1);
        find.union(5,7);
        find.union(0,3);
        find.union(4,2);
    }
}
