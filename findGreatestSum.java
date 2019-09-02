package SwordingToOffer;

public class findGreatestSum {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length < 0) {
            return 0;
        }
        int cu = 0;
        int gre = 0;
        for (int i = 0; i < array.length; i++) {
            if (cu <= 0) {
                cu = array[i];
            } else {
                cu += array[i];
            }
            if (cu > gre) {
                gre = cu;
            }
        }
        return gre;
    }

    public static int FindGreatestSumOfSubArray2(int[] array) {
        int res = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max (max + array[i], array[i]);
            res = Math.max (max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int p[] = {1, -2, 3, 4, -3};
        System.out.println (FindGreatestSumOfSubArray (p));
        System.out.println (FindGreatestSumOfSubArray2 (p));
    }
}
