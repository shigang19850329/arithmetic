package algorithms.chapter3p1;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 3.1.1编写一段程序，创建一张符号表并建立字母成绩和数值分数
 * 的对应关系，如下表所示。从标准输入读取一系列字母成绩，计算
 * 并打印GPA（字母成绩对应的分数的平均值）。
 */
public class p311 {
    public static void main(String[] args) {
        ST<String,Double> st = new ST<String,Double>();
        st.put("A+",4.33);
        st.put("A",4.00);
        st.put("A-",3.67);
        st.put("B+",3.33);
        st.put("B",3.00);
        st.put("C+",2.33);
        st.put("C",2.00);
        st.put("C-",1.67);
        st.put("D",1.00);
        st.put("F",0.00);
//        for (String s : st.keys())
//            StdOut.println(s + " " + st.get(s));
        double sum =0;
        int i = 1;
        System.out.println("请输入字母成绩：");
        for ( i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            sum+=st.get(key);
        }
        double average = sum/i;
        System.out.println(average);
    }
}
