package SwordingToOffer;

import java.util.Hashtable;
import java.util.Scanner;

// 剪绳子
public class CutRope {
    private static Hashtable<Integer, Long> map = new Hashtable<> ();
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        while (sc.hasNext ()){
            int n = sc.nextInt ();
            if (n == 2 || n == 3){
                System.out.println (n - 1);
                continue;
            }else {
                System.out.println (dfs (n));
            }

        }
        sc.close ();
    }
    private static long dfs(int n){
        if (n == 1 || n == 2){
            return n;
        }
        if (map.containsKey (n)){
            return map.get (n);
        }
        long max = n;
        for (int i = 1; i <= n/2 ; i++) {
            // max与i和dfs(n-i)相乘进行数值比较，递归
            max = Math.max (max, i * dfs (n - i));
        }
        map.put (n, max);
        return max;
    }
}
