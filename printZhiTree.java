package SwordingToOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class printZhiTree {
    /**
     * 奇数层从左扫描，偶数层从右扫描
     *
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> PrintZhi (TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<> ();
        Stack<TreeNode> s1 = new Stack<> ();
        Stack<TreeNode> s2 = new Stack<> ();
        int lay = 1;
        if (pRoot == null) {
            return list;
        }
        s1.push (pRoot);
        while (!s1.isEmpty () || !s2.isEmpty ()) {
            if (lay % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<> ();
                while (!s1.isEmpty ()) {
                    TreeNode node = s1.pop ();
                    if (node != null) {
                        temp.add (node.val);
                        s2.push (node.left);
                        s2.push (node.right);
                    }
                }
                if (!temp.isEmpty ()) {
                    list.add (temp);
                    lay++;
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<> ();
                while (!s2.empty ()) {
                    TreeNode node = s2.pop ();
                    if (node != null) {
                        temp.add (node.val);
                        s1.push (node.right);
                        s1.push (node.left);
                    }
                }
                if (!temp.isEmpty ()) {
                    list.add (temp);
                    lay++;
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> levelOrderBottom (TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>> ();
        addLevel (l, 0, root);
//        Collections.reverse(l);
        return l;
    }

    public static void addLevel (List<List<Integer>> list, int level, TreeNode node) {
        if (node == null) return;
        if (list.size () - 1 < level) list.add (new ArrayList<Integer> ());
        list.get (level).add (node.val);

        addLevel (list, level + 1, node.left);
        addLevel (list, level + 1, node.right);
    }

    public static void main (String[] args) {
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
        System.out.println (PrintZhi (root));
        System.out.println (levelOrderBottom (root));
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
        System.out.println (PrintZhi (root2));

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
        System.out.println (PrintZhi (root3));

        // 1
        TreeNode root4 = new TreeNode ();
        root4.val = 1;
        System.out.println ("\n");
        System.out.println (PrintZhi (root4));

        // null
        System.out.println ("\n");
        System.out.println (PrintZhi (null));
    }
}
