package swordingTooffer;

import java.util.Scanner;

public class CutRope2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            if (n==2||n==3){
                System.out.println(n-1);
            }else {
                System.out.println(cut(n));
            }
        }
        sc.close();
    }
    public static long cut(int n){
        if (n<2)
            return 0;
        if (n==2)
            return 1;
        if (n==3)
            return 2;
        int times3=n/3;
        if (n-times3*3==1)
            times3-=1;
        int times2=(n-times3*3)/2;
        return (long) ((Math.pow(3,times3))*(Math.pow(2,times2)));
    }
}
