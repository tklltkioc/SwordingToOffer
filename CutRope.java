package SwordingToOffer;

import java.util.Hashtable;
import java.util.Scanner;

public class CutRope {
    private static Hashtable<Integer, Long> sa = new Hashtable<> ();

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        while (sc.hasNext ()) {
            int n = sc.nextInt ();
            if (n == 2 || n == 3) {
                System.out.println (n - 1);
                continue;
            } else {
                System.out.println (dfs (n));
            }
        }
        sc.close ();
    }

    private static long dfs (int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (sa.containsKey (n))
            return sa.get (n);
        long max = n;
        for (int i = 1; i <= n / 2; i++) {
            max = Math.max (max, i * dfs (n - i));
        }
        sa.put (n, max);
        return max;
    }

}
