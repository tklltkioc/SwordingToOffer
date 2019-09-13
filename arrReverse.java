package SwordingToOffer;

// 数组中的逆序对
public class arrReverse {
    public static int cnt;

    public static int InversePairs(int[] array) {
        cnt = 0;
        if (array != null)
            mergeSortUp2Down (array, 0, array.length - 1);
        return cnt;
    }

    /**
     * 归并排序(从上往下)
     *
     * @param a
     * @param start
     * @param end
     */

    public static void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) >> 1;

        mergeSortUp2Down (a, start, mid);
        mergeSortUp2Down (a, mid + 1, end);

        merge (a, start, mid, end);
    }

    /**
     * 将一个数组中的两个相邻有序区间合并成一个
     * 归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
     * 合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
     * 数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
     * 还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余
     *
     * @param a
     * @param start
     * @param mid
     * @param end
     */
    public static void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else {
                tmp[k++] = a[j++];
                cnt += mid - i + 1;  // 核心，计算逆序对数目
                cnt %= 1000000007;
            }
        }
        while (i <= mid)
            tmp[k++] = a[i++];
        while (j <= end)
            tmp[k++] = a[j++];
        for (k = 0; k < tmp.length; k++)
            a[start + k] = tmp[k];
    }

    public static void main(String[] args) {
        int[] x = {7, 5, 6, 4};
        System.out.println (InversePairs (x));
        int[] x1 = {1, 0, 0};
        System.out.println (InversePairs (x1));
        int[] y = {2, 4, 9, 0, 3, 4, 0, 8};
        System.out.println (InversePairs (y));
        int[] z = {};
        System.out.println (InversePairs (z));

    }
}
