package JavaDevelopExample.chapter2;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 作者: 石刚
 * 时间: 2019/1/21 21:44
 * 版本 1.0
 * 实例21 重定向输出流实现程序日志
 */
public class RedirectOutputStream {
    public static void main(String[] args) {
        try {
            //保存原输出流
            PrintStream out = System.out;
            //创建文件输出流
            PrintStream ps = new PrintStream("./log.txt");
            //设置使用新的输出流
            System.setOut(ps);
            //定义整形变量
            int age = 18;
            System.out.println("年龄变量成功定义，初始值为18");
            //定义字符串变量
            String sex = "女";
            System.out.println("性别变量成功定义，初始值为女");
            //整合两个变量
            String info = "这是个" + sex + "孩子，应该有" + age + "岁了。";
            System.out.println("整合两个变量为info字符串变量，其结果是： " + info);
            //恢复原有输出流
            System.setOut(out);
            System.out.println("程序执行完毕，请查看日志文件");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
