package swordingTooffer;

public class NoYunsAdd {
    public static int Add(int num1,int num2){
        int sum;
        while (num2!=0){
            sum=num1^num2;
            num2=(num1&num2)<<1;
            num1=sum;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println (Add (12,13));
        System.out.println (Add (0,0));
    }
}
