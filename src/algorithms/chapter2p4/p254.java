package algorithms.chapter2p4;

import java.util.*;

/**
 * p2.5.4 实现一个方法String[] dedup(String[] a),返回一个
 * 有序的a[],并删去其中的重复元素。
 */
public class p254 {
    public static String[] dedup(String[] a) {
        int t = 1;
        Arrays.sort(a);
        String[] temp = new String[a.length];
        temp[0] = a[0];
        //遍历原数组
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                temp[t++] = a[i];
            }
        }
        //声明需要返回的数组，这才是去重复后的数组
        String[] c = new String[t];
        //用System.arraycopy方法将刚才去重的数组拷贝到新数组并返回
        System.arraycopy(temp, 0, c, 0, t);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        return c;
    }

    /**
     * 使用集合，就简单地多了
     * 只要创建一个集合，然后遍历数组逐一放入集合，只要在放入之前用
     * contains()方法判断一下集合中是否存在这个元素就可以了
     * 最后用toArray()转换成数组搞定。
     */
    public static Object[] dedup2(Object[] a) {
        List list = new ArrayList<>();
        //遍历数组往list里面添加元素
        for (int i = 0; i < a.length; i++) {
            if (!list.contains(a[i])) {
                list.add(a[i]);
            }
        }
        Object[] b = list.toArray();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        return b;
    }

    /**
     * 最简单的方法就是用Set集合
     * 无序不可重复的特性进行元素过滤
     */
    public static Object[] dedup3(Object[] a) {
        Set set = new HashSet<>();
        //遍历数组并存入集合，如果元素已存在则不会重复存入
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        Object[] objects = set.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.print(objects[i] + " ");
        }
        //返回Set集合
        return objects;
    }

    public static void main(String[] args) {
        String[] a = {"a", "a", "a", "a", "a", "b", "b", "b", "b", "c", "c", "c", "c"};
        dedup(a);
        System.out.println();
        dedup2(a);
        System.out.println();
        dedup3(a);
    }
}
