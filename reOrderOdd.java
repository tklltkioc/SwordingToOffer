package swordingTooffer;
/**
 * 1.要想保证原有次序，则只能顺次移动或相邻交换。
 * 2.i从左向右遍历，找到第一个偶数。
 * 3.j从i+1开始向后找，直到找到第一个奇数。
 * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
 * 5.终止条件：j向后遍历查找失败。
 */
public class reOrderOdd {
    public static void reOrderArray(int [] array) {
        if(array==null||array.length==0)
            return;
        int i = 0,j;
        while(i<array.length){
            //偶数
            while(i<array.length&&!isEven(array[i]))
                i++;
            j = i+1;
            //奇数
            while(j<array.length&&isEven(array[j]))
                j++;
            //遍历结束条件
            if(j<array.length){
                int tmp = array[j];
                for (int j2 = j-1; j2 >=i; j2--) {
                    array[j2+1] = array[j2];
                }
                array[i] = tmp;
            }else{// 查找失敗
                break;
            }
        }
    }
    static boolean isEven(int n){
        return (n&1)==0;
    }

    public static void main(String[] args) {
        int[]x={3,0,-3,-10,1,4,2};
        reOrderArray(x);
        for (int a:x){
            System.out.println(a);
        }
    }
}
