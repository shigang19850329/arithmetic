package JavaDevelopExample.chapter2;

import java.util.Scanner;

/**
 * 作者: 石刚
 * 时间: 2019/1/21 22:03
 * 版本 1.0
 * 示例024 用三元运算符判断奇数和偶数
 */
public class ParityCheck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        long number = scan.nextLong();
        String check = (number % 2 == 0) ? "这个数字是：偶数" : "这个数字是：奇数";
        System.out.println(check);
    }
}
