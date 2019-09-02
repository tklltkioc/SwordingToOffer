package SwordingToOffer;

import java.util.Scanner;

public class dss {
    public static void fightpass() {
        int n = 0;
        long fightSum = 0, allCost = 0;
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt ();
        if (n > 0) {
            long[] monPower = new long[n];
            int[] monNeedMon = new int[n];
            for (int i = 0; i < n; i++)
                monPower[i] = sc.nextLong ();
            for (int i = 0; i < n; i++)
                monNeedMon[i] = sc.nextInt ();

            if (n == 1)
                allCost = monNeedMon[0];
            else {
                int i = 0;
                for (i = 0; i < n - 1; i++) {
                    if (monPower[i] > fightSum) {
                        fightSum += monPower[i];
                        allCost += monNeedMon[i];
                    } else if (fightSum < monPower[i + 1] &&
                            monNeedMon[i] < monNeedMon[i + 1]) {
                        fightSum += monPower[i];
                        allCost += monNeedMon[i];
                    }
                }
                if (monPower[i] > fightSum) {
                    fightSum += monPower[i];
                    allCost += monNeedMon[i];
                }
            }

        }
        System.out.println (allCost);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        fightpass ();
    }

}

