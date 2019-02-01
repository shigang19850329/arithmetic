package JavaDevelopExample.chapter2;

import java.util.Scanner;

/**
 * 作者: 石刚
 * 时间: 2019/1/22 7:52
 * 版本 1.0
 * 实现两个变量的互换（不借助第三个变量）
 */
public class VariableExchange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入变量A的值：");
        long A = scan.nextLong();
        System.out.println("请输入变量B的值");
        long B = scan.nextLong();
        System.out.println("A=" + A + " B=" + B);
        System.out.println("执行变量转换...");
        //异或运算符
        A = A ^ B;
        B = B ^ A;
        A = A ^ B;
        System.out.println("A=" + A + "\tB=" + B);
    }
}
