package SwordingToOffer;

public class treeSymmetry {
    public static boolean isSymmetry(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetry (root.left, root.right);
        }
    }

    public static boolean isSymmetry(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetry (root1.left, root2.right) && isSymmetry (root1.right, root2.left);
    }

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6      6
        //  / \    / \
        // 5   7  7   5
        TreeNode root = new TreeNode ();
        root.val = 8;
        root.left = new TreeNode ();
        root.left.val = 6;
        root.left.left = new TreeNode ();
        root.left.left.val = 5;
        root.left.right = new TreeNode ();
        root.left.right.val = 7;
        root.right = new TreeNode ();
        root.right.val = 6;
        root.right.left = new TreeNode ();
        root.right.left.val = 7;
        root.right.right = new TreeNode ();
        root.right.right.val = 5;
        System.out.println (isSymmetry (root));
        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        TreeNode root2 = new TreeNode ();
        root2.val = 1;
        root2.left = new TreeNode ();
        root2.left.val = 3;
        root2.left.left = new TreeNode ();
        root2.left.left.val = 5;
        root2.left.left.left = new TreeNode ();
        root2.left.left.left.val = 7;
        root2.left.left.left.left = new TreeNode ();
        root2.left.left.left.left.val = 9;
        System.out.println (isSymmetry (root2));
        //       8
        //    /    \
        //   8      8
        //  / \    /
        // 8   8  8
        TreeNode root3 = new TreeNode ();
        root3.val = 8;
        root3.left = new TreeNode ();
        root3.left.val = 8;
        root3.left.left = new TreeNode ();
        root3.left.left.val = 8;
        root3.left.right = new TreeNode ();
        root3.left.right.val = 8;
        root3.right = new TreeNode ();
        root3.right.val = 8;
        root3.right.left = new TreeNode ();
        root3.right.left.val = 8;
        System.out.println (isSymmetry (root3));
        //null
        TreeNode root4 = null;
        System.out.println (isSymmetry (root4));

    }

}
