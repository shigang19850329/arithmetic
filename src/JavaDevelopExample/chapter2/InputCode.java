package JavaDevelopExample.chapter2;

import java.util.Scanner;

/**
 * 作者: 石刚
 * 时间: 2019/1/21 21:26
 * 版本 1.0
 * 实例20 从控制台接收输入字符
 * 本关键技术就是用到了System类的输入流也就是类变量in，它可以接受用户的输入
 * 信息，并且是标准的输入流实例对象。另外，Scanner类是Java的扫描器类，它可以
 * 从输入流中读取指定类型的数据或字符串，本实例使用Scanner类封装了输入流对象，并使用nextLine()方法从输入流中获取用户输入的整行文本字符串。
 */
public class InputCode {
    public static void main(String[] args) {
        //创建输入流扫描器
        Scanner scanner = new Scanner(System.in);
        //提示用户输入
        System.out.println("请输入你的身份证号");
        //获取用户输入的一行文本
        String line = scanner.nextLine();
        //打印对输入文本的描述
        System.out.println("原来你身份证号是" + line.length() + "位数字的啊");
    }
}
