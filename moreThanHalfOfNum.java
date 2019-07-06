package swordingTooffer;

public class moreThanHalfOfNum {
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array.length<=0||array==null){
            return -1;
        }
        int res=array[0];
        int times=1;
        for (int i = 1; i <array.length ; i++) {
            if (times==0){
                res=array[i];
                times=1;
            }else if (array[i]==res)
                times++;
            else
                times--;
        }
        times=0;
        for (int i=0;i<array.length;++i){
            if (array[i]==res)times++;
        }
        return  (times>array.length/2)?res:0;
    }

    public static void main(String[] args) {
        int[]a={1,1,1,1,1,2,2,3,3};
        int[]a1={4,2,4,1,4,2};
        System.out.println(MoreThanHalfNum_Solution(a));
        System.out.println(MoreThanHalfNum_Solution(a1));
    }

}
