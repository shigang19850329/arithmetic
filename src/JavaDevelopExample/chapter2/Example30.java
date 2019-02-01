package JavaDevelopExample.chapter2;

import java.util.Scanner;

/**
 * 作者: 石刚
 * 时间: 2019/1/25 22:40
 * 版本 1.0
 * 实例30 为新员工分配部门
 */
public class Example30 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入新员工的姓名：");
        String name = scan.nextLine();
        System.out.println("请输入新员工应聘的编程语言：");
        String language = scan.nextLine();
        //根据编程语言确定员工分配的部门
        switch (language.hashCode()) {
            //Java的哈希码
            case 3254818:
            case 2301506:
            case 2269730:
                System.out.println("员工" + name + "被分配到Java程序开发部门。");
                break;
            //C#的哈希码
            case 3104:
            case 2112:
                System.out.println("员工" + name + "被分配到C#项目维护组。");
                break;
            //ASP.NET的哈希码
            case -709190099:
            case 955463181:
            case 9745901:
                System.out.println("员工" + name + "被分配到ASP.NET衬托关系测试部门。");
                break;
            default:
                System.out.println("本公司不需要" + language + "语言的程序开发人员");
        }
    }
}
