package algorithms.chapter1p3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * 1.3.45 栈的可生成性
 */
public class StackProblem {
    //判断栈会不会出现下溢出
    public static boolean problem1(String[] seq){
        int cnt = 0;//表示栈的大小
        for (int i = 0; i < seq.length; i++) {
            if (seq[i].compareTo("-")==0){//返回0表示两个字符串相等
               cnt--;
            }else cnt++;
            if (cnt<0) return false;
        }
        return true;
    }
    public static String[] problem2(String[] seq){//返回一系列操作，seq是出栈顺序
        Stack<String> s = new Stack<String>();
        String[] ans = new String[2*seq.length];
        int N =0;int p = 0;
        s.push(String.valueOf(N));
        ans[p++] = String.valueOf(N);
        N++;
        for (int i = 0; i < seq.length; i++) {
            while (N< seq.length&&s.peek().compareTo(seq[i])!=0){
                s.push(String.valueOf(N));
                ans[p++] = String.valueOf(N);
                N++;
            }
            if (s.peek().compareTo(seq[i])!=0){
                return null;
            }else{
                s.pop();
                ans[p++]="-";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] seq = new String[]{"0","1","-","-","3","-","-"};
        StdOut.println(problem1(seq));
        String[] seq1 = new String[]{"2", "5", "6", "7", "4", "8", "9", "3", "1", "0"};
        for(String i:problem2(seq1))
            StdOut.print(i+" ");
        StdOut.println();
        String[] seq2 = new String[]{"4", "6", "8", "7", "5", "3", "2", "9", "0", "1"};
        StdOut.println(problem2(seq2));

    }
}
