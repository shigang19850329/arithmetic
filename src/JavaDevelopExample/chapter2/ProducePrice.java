package JavaDevelopExample.chapter2;

/**
 * 作者: 石刚
 * 时间: 2019/1/27 20:51
 * 版本 1.0
 * 实例31 使用Switch语句根据消费金额计算折扣
 */
public class ProducePrice {
    public static void main(String[] args) {
        //金额
        float money = 1206;
        //折扣
        float rebate = 0f;
        if (money < 200) {
            int grade = (int) money / 200;
            switch (grade) {
                case 1:
                    rebate = 0.95f;
                    break;
                case 2:
                    rebate = 0.90f;
                    break;
                case 3:
                    rebate = 0.85f;
                    break;
                case 4:
                    rebate = 0.83f;
                    break;
                case 5:
                    rebate = 0.80f;
                    break;
                case 6:
                    rebate = 0.78f;
                    break;
                case 7:
                    rebate = 0.75f;
                    break;
                case 8:
                    rebate = 0.73f;
                    break;
                case 9:
                    rebate = 0.70f;
                    break;
                case 10:
                    rebate = 0.65f;
                    break;
                default:
                    rebate = 0.60f;
            }
        }
        //输出消费金额
        System.out.println("您的累计消费金额为： " + money);
        //输出折扣比例
        System.out.println("您将享受" + rebate + "折优惠！");
    }
}
