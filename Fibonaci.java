package swordingTooffer;

import java.util.Scanner;

/**
 * 输入n，计算斐波那契数列第n项数值。适合小矩形覆盖大矩形、跳台阶等。
 */
public class Fibonaci {
    public static long Fib(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return 1<<(n-1);
//        int cur=0;
//        long prepre=1;//n=1
//        long pre=2;//n=2
//        long cur=3;//n=3
//        for (int i = 3; i <=n ; i++) {
//            cur=2<<(n-2);
//          cur=pre+prepre;
//          prepre=pre;
//          pre=cur;
//        }
//        return cur;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Fib(n));

    }

}
