package SwordingToOffer;

import java.util.Arrays;

public class isContinus {
    public static boolean isContinuous (int[] numbers) {
        if (numbers == null || numbers.length < 1) return false;
        int zero = 0, inter = 0;
        int len = numbers.length;
        Arrays.sort (numbers);
        for (int i = 0; i < len - 1; i++) {
            if (numbers[i] == 0) {
                zero++;
                continue;
            }
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            inter += numbers[i + 1] - numbers[i] - 1;
        }
        if (zero >= inter) {
            return true;
        }
        return false;
    }

    //max 记录 最大值
    //min 记录  最小值
    //min ,max 都不记0
    //满足条件 1 max - min <5
    //         2 除0外没有重复的数字(牌)
    //         3 数组长度为5
    public static boolean isContinuous2 (int[] numbers) {
        if (numbers == null || numbers.length < 1) return false;
        int[] d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for (int i = 0; i < len; i++) {
            d[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            //对子
            if (d[numbers[i]] > 1) {
                return false;
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }

        }
        if (max - min < 5) {
            return true;
        }
        return false;
    }

    public static void main (String[] args) {
        int[] x = {2, 3, 4, 5, 0};
        int[] y = {0, 2, 3, 4, 5};
        int[] z = {1, 2, 3, 6, 5};
        int[] q = {1, 2, 5, 6, 5};
        int[] x1 = {};
        System.out.println (isContinuous2 (x));
        System.out.println (isContinuous2 (x1));
        System.out.println (isContinuous2 (y));
        System.out.println (isContinuous2 (z));
        System.out.println (isContinuous2 (q));
    }
}
