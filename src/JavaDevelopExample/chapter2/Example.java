package JavaDevelopExample.chapter2;


import java.util.Scanner;

/**
 * 作者: 石刚
 * 时间: 2019/1/21 21:54
 * 版本 1.0
 * 示例023 加密可以这样简单（位运算）
 */
public class Example {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个英文字符串或解密字符串");
        //获取用户输入
        String password = scan.nextLine();
        //获取字符数组
        char[] array = password.toCharArray();
        //遍历字符数组
        for (int i = 0; i < array.length; i++) {
            //对每个数组元素进行异或运算
            array[i] = (char) (array[i] ^ 2000);
        }
        System.out.println("加密或解密结果如下：");
        System.err.println(new String(array));
    }
}
