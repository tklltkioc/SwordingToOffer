package SwordingToOffer;

/**
 * 递归判断一个数组序列是否为一个二叉排序树的后序遍历
 */
public class VerifySqueOfBST {
    public static boolean VerifySquenceOfBST (int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return IsTreeBST (sequence, 0, sequence.length - 1);
    }

    public static boolean IsTreeBST (int[] sequence, int start, int end) {
        if (end <= start) return true;
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) return false;
        }
        return IsTreeBST (sequence, start, i - 1) && IsTreeBST (sequence, i, end - 1);
    }

    /**
     * 非递归判断一个数组序列是否为一个二叉排序树的后序遍历
     * 左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
     * 最后一个数字是右子树的根也比左子树所有值大，因此我们可以每次只看右子树是否符合条件
     * 即可，即使到达了左子树也可以看出由左右子树组成的树还是像右子树那样处理
     */
    public static boolean VerifySquenceOfBST2 (int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int size = sequence.length;
        int i = 0;
        while (--size != 0) {
            while (sequence[i] < sequence[size]) {
                i++;
            }
            while (sequence[i] > sequence[size]) {
                i++;
            }
            if (i < size) return false;
            i = 0;
        }
        return true;
    }

    public static void main (String[] args) {
        int[] i = {5, 7, 6, 9, 11, 10, 8};
        int[] a = {9, 7, 8};
        boolean x = VerifySquenceOfBST2 (i);
        boolean y = VerifySquenceOfBST2 (a);
        boolean z = VerifySquenceOfBST (a);
        System.out.println (x);
        System.out.println (y);
        System.out.println (z);
    }

}
