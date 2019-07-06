package swordingTooffer;

public class PathSearch {
    /**
     * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中任意一格开始，每一步可以在矩阵中间向左、右、上、下移动一格。
     * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
     *
     * @param matrix 输入矩阵
     * @param rows   矩阵行数
     * @param cols   矩阵列数
     * @param str    要搜索的字符串
     * @return 是否找到 true是，false否
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 参数校验
        if (matrix == null || matrix.length != rows * cols || str == null ||
                str.length < 1||matrix.length<str.length){
            return false;
        }
        //设置状态数组
        int flag[] = new int[matrix.length];
        //以每个点为起始点进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }
    /**
     *
     * @param matrix 输入矩阵
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param row 当前处理行数
     * @param col 当前处理列数
     * @param str 待查找字符串
     * @param k 已查找完成字符的数目
     * @param flag 状态数组保存已访问字符
     * @return
     */
    private static boolean helper(char[] matrix, int rows, int cols, int row, int col, char[] str, int k, int[] flag) {
        //矩阵下标
        int index = row * cols + col;
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        //k值等于str长度时，寻找完毕
        if(k == str.length - 1)
            return true;
        //找到字符，标志置1
        flag[index] = 1;
        if (helper(matrix, rows, cols, row - 1, col, str, k + 1, flag)
                || helper(matrix, rows, cols, row + 1, col, str, k + 1, flag)
                || helper(matrix, rows, cols, row, col - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, row, col + 1, str, k + 1, flag)) {
            return true;
        }
        //该字符下无法继续寻找，标志置0
        flag[index] = 0;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(hasPath("abtgcfcsjdeh".toCharArray(), 3, 4,
                "bfce".toCharArray()) );
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray()));
//        System.out.println(hasPath("abtgcfcsjdeh".toCharArray(), 2, 4,
//                "bfce".toCharArray()) );
//        System.out.println(hasPath(null, 0, 0,
//                "bfce".toCharArray()) );
//        System.out.println(hasPath("AAAAAAAAAAAA".toCharArray(), 3, 4,
//                "AAAAAAAAAAAAA".toCharArray()) );// false

    }



}
