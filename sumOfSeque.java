package SwordingToOffer;

import java.util.ArrayList;

public class sumOfSeque {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence (int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<> ();
        int pl = 1, ph = 2;
        while (ph > pl) {
            int cur = (ph + pl) * (ph - pl + 1) / 2;
            if (cur > sum) {
                pl++;
            } else if (cur < sum) {
                ph++;
            } else {
                ArrayList<Integer> list = new ArrayList<> ();
                for (int i = pl; i <= ph; i++) {
                    list.add (i);
                }
                res.add (list);
                pl++;
            }

        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence2 (int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<> ();
        for (int n = (int) (Math.sqrt (sum * 2)); n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<> ();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    list.add (k);
                }
                res.add (list);
            }
        }
        return res;
    }

    public static void main (String[] args) {
        System.out.println (FindContinuousSequence (100));
        System.out.println (FindContinuousSequence2 (100));
    }
}
