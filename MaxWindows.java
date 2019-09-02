package SwordingToOffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxWindows {
    public static ArrayList<Integer> maxInWindows (int[] num, int size) {
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<Integer> ();
        }
        ArrayList<Integer> result = new ArrayList<> ();
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<> ();
        for (int i = 0; i < num.length; i++) {
            //队尾小于当前元素
            while (!qmax.isEmpty () && num[qmax.peekLast ()] < num[i]) {
                qmax.pollLast ();
            }
            qmax.addLast (i);
            //通过下标判断队首元素是否过期
            if (qmax.peekFirst () == i - size) {
                qmax.pollFirst ();
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                result.add (num[qmax.peekFirst ()]);
            }
        }
        return result;
    }

    public static void main (String[] args) {
        int[] x = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println (maxInWindows (x, 3));
        System.out.println (maxInWindows (x, 0));
        System.out.println (maxInWindows (x, 9));
        System.out.println (maxInWindows (null, 3));
    }
}
