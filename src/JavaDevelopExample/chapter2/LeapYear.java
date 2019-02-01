package JavaDevelopExample.chapter2;

import java.util.Scanner;

/**
 * 作者: 石刚
 * 时间: 2019/1/22 8:01
 * 版本 1.0
 * 实例28 判断某一年是否为闰年
 * 满足这两个条件的整数可以成为闰年，
 * 第一，能被4整除但不能被100整除；
 * 第二能被400整除。
 */
public class LeapYear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个年份：");
        long year = scan.nextLong();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + "是闰年！");
        } else {
            System.out.println(year + "不是闰年！");
        }
    }
}
