package JavaDevelopExample.chapter2;

import java.util.Scanner;

/**
 * 作者: 石刚
 * 时间: 2019/1/25 22:33
 * 版本 1.0
 * 实例029 验证登录信息的合法性
 */
public class CheckLogin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入登录用户名：");
        String username = scan.nextLine();
        System.out.println("请输入登录密码：");
        String password = scan.nextLine();
        if (!username.equals("mr")) {
            System.out.println("用户名非法。");
        } else if (!password.equals("mrsoft")) {
            System.out.println("登录密码错误。");
        } else {
            System.out.println("恭喜您，登录信息通过验证。");
        }
    }
}
