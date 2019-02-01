package algorithms.chapter2p4;

import java.util.ArrayList;
import java.util.List;

/**练习2.5.2 编写一段程序，从标准输入读入一列单词并打印出其中所有由两个单词组成的组合词。例如，如果输入的单词为after,thought和afterthought,那么afterthought就是一个组合词。
 * 本题目思路比较简单，直接选择剩余元素进行随机组合然后和数组中的元素进行比较即可。
 */
public class CombinationWordsCount {
    public static List<String> printCombinationWords(String[] strings){
      List<String> listString = new ArrayList<String>();
      int N = strings.length;
        for (int i = 0; i < N; i++) {
            String stringFirst = strings[i];
            for (int j = i+1; j < N; j++) {
                String stringSecond = strings[j];
                for (int k = 0; k < N; k++) {
                    if (((stringFirst+stringSecond).equals(strings[k]))||((stringSecond+stringFirst).equals(strings[k])))
                        listString.add(strings[k]);
                }
            }
        }
        return listString;
    }

    public static void main(String[] args) {
        String[] strings = {"after","thought","afterthought","mooncake","hard","work","hardwork","moon","cake"};
  List<String> listString = printCombinationWords(strings);
        for (String s:listString) {
            System.out.print(s+" ");
        }
    }
}
