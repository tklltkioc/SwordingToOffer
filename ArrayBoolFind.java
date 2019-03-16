package 剑指;

public class ArrayBoolFind {
	/**
	 * 行、列均递增的数组，查找某个数是否存在
	 * @param martix
	 * @param number
	 * @return
	 */
	public static boolean find(int[][]martix,int number) {
		if(martix==null||martix.length<1||martix[0].length<1) {
			return false;
		}
		int rows=martix.length;//数组行数
		int cols=martix[1].length;//数组列数
		int row=0;//起始行号，最上方
		int col=cols-1;//起始列号，最右侧
		//查找的位置在数组之内
		while(row>=0&&row<rows&&col>=0&&col<cols) {
			if(martix[row][col]==number) {//如果找到了就返回
				return true;
			}else if(martix[row][col]>number) {//找到的数大，在当前数的左侧
				col--;//列数减1
			}else {//找到的数小，在当前数的下方
				row++;//行数加1
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] matrix = {
                {1, 2, 8, 9,10},
                {2, 4, 9, 12,13},
                {4, 7, 10, 13,14},
                {6, 8, 11, 15,16}
        };
        System.out.println(find(matrix, 2 )); 
	}

}
