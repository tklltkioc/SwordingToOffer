package swordingTooffer;

import java.util.ArrayList;

public class printMartix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>() ;
        if(matrix==null || matrix.length==0) { return result ; }

        printMatrixClockWisely(matrix, 0, 0,
                matrix.length - 1, matrix[0].length - 1, result);

        return result ;
    }

    public static void printMatrixClockWisely(int[][] matrix, int startRow, int startCol, int endRow, int endCol,
                                        ArrayList<Integer> result) {
        if(startRow<endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }   //Right
            for(int i=startRow+1; i<=endRow-1; i++) { result.add(matrix[i][endCol]) ; }     //Down
            for(int j=endCol; j>=startCol; j--) { result.add(matrix[endRow][j]) ; }     //Left
            for(int i=endRow-1; i>=startRow+1; i--) { result.add(matrix[i][startCol]) ; }   //Up
            printMatrixClockWisely(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, result) ;
        }else if(startRow==endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }
        }else if(startRow<endRow && startCol==endCol) {
            for(int i=startRow; i<=endRow; i++) { result.add(matrix[i][endCol]) ; }
        }else if(startRow==endRow && startCol==endCol) {
            result.add(matrix[startRow][startCol]) ;
        }else {
            return ;
        }
    }
    public static ArrayList<Integer> printMatrix2(int [][] array) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(array.length==0) return result;
        int row = array.length,col = array[0].length;
        if(col==0) return result;
        int layers = (Math.min(row,col)-1)/2+1;//这个是层数,需要几笔一笔画
        for(int i=0;i<layers;i++){
            for(int k = i;k<col-i;k++) result.add(array[i][k]);//左上至右上
            for(int j=i+1;j<row-i;j++) result.add(array[j][col-i-1]);//右上至右下
            /**
             *   从右下到左下，矩阵列的最大索引为column-1（从0开始），因为这一轮的从右上到右下多用了一
             *   个当前行后面的元素，再结合前几轮从右上到右下用掉的后面i个元素，所以一开始j=column-1-i-1。
             *   从右下到左下过程中最后当前列的索引要大于等于循环层数，因为前几轮从左下到左上用掉了前i-1列元素，所以j>=i。
             *   同时考虑矩阵行数小于列数（如3行6列）的情况，使行的最大索引row-1（行号从0开始）减去当前循环层数不会等于当前循环层数，
             *   否则最后一轮从左上到右上之后，接下来会再重复这一轮同样元素的从右下到左下。
             *   填充列表result的元素行号为行最大索引减去循环层数，因为前几轮从右下到左下会用掉当前行下面几行的元素
             *   左下到左上同理
             */

            for(int k=col-i-2;(k>=i)&&(row-i-1!=i);k--) result.add(array[row-i-1][k]);//右下至左下
            for(int j=row-i-2;(j>i)&&(col-i-1)!=i;j--) result.add(array[j][i]);//左下至左上
        }
        return result;
    }

    public static void main(String[] args) {
        int[][]ss={
                { 1,  2},
                {3, 4}
        };
        System.out.println (printMatrix (ss));
        System.out.println (printMatrix2 (ss));
    }
}
