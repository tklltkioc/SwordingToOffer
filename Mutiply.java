package swordingTooffer;

public class Mutiply {
    public static int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘，从左到右
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算上三角,从右往左
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[]x={1,2,3,4,5};
        int[]x1=multiply (x);
        for (int a:x1)
        System.out.println (a);
    }
}
