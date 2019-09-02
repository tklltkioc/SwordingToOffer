package SwordingToOffer;

public class XuanZhuanArray {
    public static int min (int[] array) {
        if (array == null) {
            throw new RuntimeException ("非法输入");
        }
        if (array.length == 0) {
            return 0;
        }
        int ls = 0;
        int he = array.length - 1;
        int mi = ls;
        while (array[ls] >= array[he]) {
            if (he - ls == 1) {
                return array[he];
            }
            mi = ls + (he - ls) / 2;
            if (array[mi] == array[ls] && array[mi] == array[he]) {
                return minOrder (array, ls, he);
            }
            if (array[mi] >= array[ls]) {
                ls = mi;
            } else if (array[mi] <= array[he]) {
                he = mi;
            }
        }
        return array[mi];
    }

    public static int minOrder (int[] a, int s, int e) {
        int result = a[s];
        for (int i = s + 1; i <= e; i++) {
            if (result > a[i]) {
                result = a[i];
            }
        }
        return result;
    }

    public static void main (String[] args) {
        // 典型输入，单调升序的数组的一个旋转
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println (min (array1));

        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println (min (array2));

        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println (min (array3));

        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println (min (array4));

        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println (min (array5));

        // 数组中只有一个数字
        int[] array6 = {2};
        System.out.println (min (array6));

        // 数组中数字都相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println (min (array7));

        // 输入NULL
//        System.out.println(min(null));
        int[] array9 = {};
        System.out.println (min (array9));
    }
}