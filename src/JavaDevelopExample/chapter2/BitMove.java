package JavaDevelopExample.chapter2;

import java.util.Scanner;

/**
 * 作者: 石刚
 * 时间: 2019/1/21 22:18
 * 版本 1.0
 * 实例026 不用乘法运算符实现2*16
 */
public class BitMove {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个数字");
        long number = scan.nextLong();
        System.out.println("你输入的数字是：" + number);
        System.out.println("该数字乘以2的运算结果为：" + (number << 1));
        System.out.println("该数字乘以4的运算结果为：" + (number << 2));
        System.out.println("该数字乘以8的运算结果为：" + (number << 3));
        System.out.println("该数字乘以16的运算结果为：" + (number << 4));
    }
}
