package swordingTooffer;

public class giftMaxValue {
    public static int getMaxValue(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int rows=arr.length;
        int cols = arr[0].length;

        int[][] maxValue = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if(i>0){
                    up = maxValue[i-1][j];
                }
                if(j>0){
                    left = maxValue[i][j-1];
                }
                maxValue[i][j] = Math.max(up, left) + arr[i][j];
            }
        }
        return maxValue[rows-1][cols-1];
    }

    /**
     * 坐标(i,j)的最大礼物价值仅仅取决于坐标为(i-1,j)和(i,j-1)两个格子；
     * 因此第i-2行以上的最大价值没有必要保存下来。
     * 使用一维数组保存：(0,0)…(0,j-1)保存的是(i,0)…(i,j-1)的最大价值；
     * (0,j)…(0,cols-1)保存的是(i-1,j)…(i-1,cols-1)的最大价值。
     *
     */

    public static int getMaxValue2(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int rows = arr.length;
        int cols = arr[0].length;

        int[] maxValue = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if(i > 0){
                    up = maxValue[j];
                }
                if(j > 0){
                    left = maxValue[j-1];
                }

                maxValue[j] = Math.max(up, left) + arr[i][j];
            }
        }
        return maxValue[cols-1];
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 10, 3, 8 }, { 12, 2, 9, 6 }, { 5, 7, 4, 11 },
                { 3, 7, 16, 5 } };
        System.out.println (getMaxValue (arr));
        System.out.println (getMaxValue2 (arr));
    }
}
