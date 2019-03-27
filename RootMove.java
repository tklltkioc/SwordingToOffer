package swordingTooffer;

public class RootMove {
    /**
     * 题目：地上有个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，
     * 它每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数
     * 位之和大于k的格子。例如，当k为18时，机器人能够进入方格(35,37)，
     * 因为3+5+3+7=18.但它不能进入方格(35,38)，因为3+5+3+8=19.
     * 请问该机器人能够达到多少格子？
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public static int movingCount(int threshold, int rows, int cols)
    {
        if (threshold<0||rows<1||cols<1)
            return 0;
        int[][]flag=new int[rows][cols];
        return help(threshold,rows,cols,0,0,flag);
    }

    /**
     * 回溯递归方法
     * @param threshold
     * @param rows
     * @param cols
     * @param i
     * @param j
     * @param flag
     * @return
     */
    public static int help(int threshold, int rows, int cols, int i, int j, int[][] flag){
        if(i<0||i>=rows||j<0||j>=cols||num(i)+num(j)>threshold||flag[i][j]==1)
            return 0;
        flag[i][j]=1;
        return help(threshold,rows,cols,i-1,j,flag)+
                help(threshold,rows,cols,i+1,j,flag)+
                help(threshold,rows,cols,i,j-1,flag)+
                help(threshold,rows,cols,i,j+1,flag)+1;
    }

    /**
     * 一个数字的数位之和
     * @param x
     * @return
     */
    public static int num(int x){
        int re=0;
        while(x>0){
            re+=x%10;
            x/=10;
        }
        return re;
    }


    private static int rever(int x){
        int rev=0;
        while (x!=0){
            int pop=x%10;
            x/=10;
            if (rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7))return 0;
            if (rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8))return 0;
            rev=rev*10+pop;

        }return rev;
    }


    public static void main(String[] args) {
        System.out.println(rever(123));
        System.out.println(movingCount(5, 10, 10) + "[21]");
        System.out.println(movingCount(15, 20, 20) + "[359]");
        System.out.println(movingCount(10, 1, 100) + "[29]");
        System.out.println(movingCount(10, 1, 10) + "[10]");
        System.out.println(movingCount(15, 100, 1) + "[79]");
        System.out.println(movingCount(15, 10, 1) + "[10]");
        System.out.println(movingCount(5, 10, 10) + "[21]");
        System.out.println(movingCount(12, 1, 1) + "[1]");
        System.out.println(movingCount(-10, 10, 10) + "[0]");
        System.out.println(movingCount(-10, 1, 0) + "[0]");
    }
}
