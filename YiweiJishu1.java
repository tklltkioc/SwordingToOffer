package swordingTooffer;

public class YiweiJishu1 {
    /**
     * 整数减1代表将最右边的1化为0，其后位上的数变为1，再与原数作与运算，
     * 得到整数去掉1位之后的情况
     * @param y
     * @param x
     * @return
     */
    static int numof1(int y,int x){
        int n=x^y;
        int count=0;
        while (n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numof1(10,5));
    }
}
