package swordingTooffer;

public class oneTimes {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        while(n>0){
            String str=String.valueOf(n);
            char [] chars=str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='1')
                    count++;
            }
            n--;
        }
        return count;
    }

    public static void main(String[] args) {
        int x=0;
        System.out.println (NumberOf1Between1AndN_Solution (x));
    }

}
