package SwordingToOffer;

// 树的深度
public class deepTree {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
//    public TreeNode(int val) {
//        this.val = val;
//    }
    }
    public static int TreeDepth (TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth (root.left);
        int right = TreeDepth (root.right);
        return left > right ? (left + 1) : (right + 1);
    }

    public static boolean IsBalanced_Solution (TreeNode root) {
        if (root == null) return true;
        int left = TreeDepth (root.left);
        int right = TreeDepth (root.right);
        int diff = left - right;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return IsBalanced_Solution (root.left) && IsBalanced_Solution (root.right);
    }

    /**
     * 从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
     * 如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
     */
    public static boolean IsBalanced_Solution2 (TreeNode root) {
        return getDepth (root) != -1;
    }

    private static int getDepth (TreeNode root) {
        if (root == null) return 0;
        int left = getDepth (root.left);
        if (left == -1) return -1;
        int right = getDepth (root.right);
        if (right == -1) return -1;
        return Math.abs (left - right) > 1 ? -1 : 1 + Math.max (left, right);
    }

    public static void main (String[] args) {
        TreeNode n1 = new TreeNode ();
        n1.val = 1;
        TreeNode n2 = new TreeNode ();
        n2.val = 2;
        TreeNode n3 = new TreeNode ();
        n3.val = 3;
        TreeNode n4 = new TreeNode ();
        n4.val = 4;
        TreeNode n5 = new TreeNode ();
        n5.val = 5;
        TreeNode n6 = new TreeNode ();
        n6.val = 6;
        TreeNode n7 = new TreeNode ();
        n7.val = 7;

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println (TreeDepth (n1));
        System.out.println (IsBalanced_Solution (n1));
        System.out.println (IsBalanced_Solution2 (n1));
        System.out.println (IsBalanced_Solution2 (n2));


    }
}
