package SwordingToOffer;

public class MaxGupiao {
    public static int maxDiff (int[] num) {
        if (num == null || num.length < 2) return 0;
        int min = num[0];
        int maxdiff = num[1] - min;
        for (int i = 2; i < num.length; i++) {
            if (num[i - 1] < min) {
                min = num[i - 1];
            }
            int curdiff = num[i] - min;
            if (curdiff > maxdiff) {
                maxdiff = curdiff;
            }
        }
        return maxdiff;
    }

    public static void main (String[] args) {
        int[] x = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println (maxDiff (x));
    }
}
