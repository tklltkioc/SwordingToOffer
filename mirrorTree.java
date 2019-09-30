package SwordingToOffer;

public class mirrorTree {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
//    public TreeNode(int val) {
//        this.val = val;
//    }
    }

    public static void Mirror ( TreeNode root ) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.left != null) {
                Mirror (root.left);
            }
            if (root.right != null) {
                Mirror (root.right);
            }
        }
    }

    public static void printTree ( TreeNode node ) {
        if (node != null) {
            printTree (node.left);
            System.out.print (node.val + " ");
            printTree (node.right);
        }
    }

    public static void main ( String[] args ) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        TreeNode root = new TreeNode ();
        root.val = 8;
        root.left = new TreeNode ();
        root.left.val = 6;
        root.left.left = new TreeNode ();
        root.left.left.val = 5;
        root.left.right = new TreeNode ();
        root.left.right.val = 7;
        root.right = new TreeNode ();
        root.right.val = 10;
        root.right.left = new TreeNode ();
        root.right.left.val = 9;
        root.right.right = new TreeNode ();
        root.right.right.val = 11;
        printTree (root);
        System.out.println ();
        Mirror (root);
        printTree (root);
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
        System.out.println ("\n");
        printTree (root2);
        System.out.println ();
        Mirror (root2);
        printTree (root2);

        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        TreeNode root3 = new TreeNode ();
        root3.val = 0;
        root3.right = new TreeNode ();
        root3.right.val = 2;
        root3.right.right = new TreeNode ();
        root3.right.right.val = 4;
        root3.right.right.right = new TreeNode ();
        root3.right.right.right.val = 6;
        root3.right.right.right.right = new TreeNode ();
        root3.right.right.right.right.val = 8;
        System.out.println ("\n");
        printTree (root3);
        System.out.println ();
        Mirror (root3);
        printTree (root3);
        TreeNode root4 = null;
        System.out.println ("\n");
        printTree (root4);
        System.out.println ();
        Mirror (root4);
        printTree (root4);
    }
}
