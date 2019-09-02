package SwordingToOffer;

public class findBit1 {
    public static void FindNumsAppearOnce (int[] array, int num1[], int num2[]) {
        if (array.length < 2) return;
        int myxor = 0;
        int flag = 1;
        for (int i = 0; i < array.length; ++i)
            myxor ^= array[i];
        while ((myxor & flag) == 0) flag <<= 1;
        num1[0] = myxor;
        num2[0] = myxor;
        for (int i = 0; i < array.length; ++i) {
            if ((flag & array[i]) == 0) num2[0] ^= array[i];
            else num1[0] ^= array[i];
        }
    }

    /**
     * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
     *
     * @param a
     * @return
     */
    public static int find1From2 (int[] a) {
        int len = a.length, res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ a[i];
        }
        return res;
    }

    /**
     * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     *
     * @param a
     * @return
     */
    public static int find1From3 (int[] a) {
        int[] bits = new int[32];
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] = bits[j] + ((a[i] >>> j) & 1);
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                res = res | (1 << i);
            }
        }
        return res;
    }

    public static void main (String[] args) {
        int a[] = {2, 4, 3, 6, 3, 2, 5, 5};
        int a1[] = {-2, -3, -3, 5, -3, 5, 5};
        int b[] = new int[1];
        int c[] = new int[1];
        FindNumsAppearOnce (a, b, c);
        System.out.println (find1From3 (a1));
        System.out.println (b[0] + " " + c[0]);
        System.out.println (1 << 3);
    }

}
