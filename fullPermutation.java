package SwordingToOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fullPermutation {
    public static void main (String[] args) {
        fullPermutation p = new fullPermutation ();
        long startTime = System.currentTimeMillis ();   //获取开始时间
        System.out.println (p.Permutation ("122").toString ());
        long endTime = System.currentTimeMillis (); //获取结束时间
        System.out.println ("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ArrayList<String> Permutation (String str) {
        List<String> res = new ArrayList<> ();
        if (str != null && str.length () > 0) {
            PermutationHelper (str.toCharArray (), 0, res);
            Collections.sort (res);//顺序排列
        }
        return (ArrayList) res;
    }

    public static void PermutationHelper (char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf (cs);
            list.add (val);
        } else {
            for (int j = i; j < cs.length; j++) {
                //             a|b|c(状态A)
                //               |
                //               |swap(0,0)
                //               |
                //             a|b|c(状态B)
                //             /  \
                //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
                //           /      \
                //         a|b|c   a|c|b
                swap (cs, i, j);
                PermutationHelper (cs, i + 1, list);
                // 第二个swap用以使得字符数组的顺序回到进入递归前的状态，这样才不会影响外部的遍历顺序。
                // 因为在第一次交换后进入递归运算的时候，字符数组的顺序改变了，
                // 例如“abc”， i = 1时对应‘b’，j = 2时对应 'c'，进行一次交换，此时的字符数组的顺序为 "acb"，从递归返回时，顺序依然是“acb”，
                // 则进行第二次交换使得 “acb” -> “abc”，这样在后续才可以进行递归交换，不会落下某一种情况。
                swap (cs, i, j);
            }
        }
    }

    public static void swap (char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
