package swordingTooffer;

public class sumOfOneToN {
    /**
     * &&就是逻辑与，逻辑与有个短路特点，前面为假，后面不计算
     * @param n
     * @return
     */
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        int x=9;
        int y=0;
        System.out.println (Sum_Solution (x));
        System.out.println (Sum_Solution (y));

    }
}
