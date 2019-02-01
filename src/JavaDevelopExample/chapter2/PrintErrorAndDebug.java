package JavaDevelopExample.chapter2;

/**
 * 作者: 石刚
 * 时间: 2019/1/21 21:21
 * 版本 1.0
 * 实例019 输出错误信息与调试信息
 */
public class PrintErrorAndDebug {
    public static void main(String[] args) {
        System.out.println("main()方法开始运行了");
        //输出错误信息
        System.err.println("在运行期间手动输出一个错误信息");
        System.err.println("\t该软件没有买保险，请注意安全");
        System.out.println("PrintErrorAndDebug.main()");
        System.out.println("main()方法运行结束");
    }
}
