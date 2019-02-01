package JavaDevelopExample.chapter2;

import java.math.BigDecimal;

/**
 * 作者: 石刚
 * 时间: 2019/1/21 22:07
 * 版本 1.0
 * 实例025 更精确地使用浮点数
 */
public class AccuratelyFloat {
    public static void main(String[] args) {
        //现有金额
        double money = 2;
        //商品价格
        double price = 1.1;
        double result = money - price;
        System.out.println("非精确计算");
        System.out.println("剩余金额：" + result);
        //精确浮点数的解决方法
        BigDecimal money1 = new BigDecimal("2");
        BigDecimal price1 = new BigDecimal("1.1");
        BigDecimal result1 = money1.subtract(price1);
        System.out.println("精确计算");
        System.out.println("剩余金额：" + result1);
    }
}
