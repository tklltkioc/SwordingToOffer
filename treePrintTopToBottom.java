package swordingTooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class treePrintTopToBottom {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer>list=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tmp=queue.remove(0);
            if (tmp.left!=null){
                queue.add(tmp.left);
            }
            if (tmp.right!=null){
                queue.add(tmp.right);
            }
            list.add(tmp.val);
        }
        return list;
    }
    public static ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer>list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tmp=queue.remove();
            if (tmp.left!=null){
                queue.add(tmp.left);
            }
            if (tmp.right!=null){
                queue.add(tmp.right);
            }
            list.add(tmp.val);
        }
        return list;
    }
    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        TreeNode root = new TreeNode();
        root.val = 8;
        root.left = new TreeNode();
        root.left.val = 6;
        root.left.left = new TreeNode();
        root.left.left.val = 5;
        root.left.right = new TreeNode();
        root.left.right.val = 7;
        root.right = new TreeNode();
        root.right.val = 10;
        root.right.left = new TreeNode();
        root.right.left.val = 9;
        root.right.right = new TreeNode();
        root.right.right.val = 11;
        System.out.println(PrintFromTopToBottom(root));
        System.out.println(PrintFromTopToBottom2(root));

        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        TreeNode root2 = new TreeNode();
        root2.val = 1;
        root2.left = new TreeNode();
        root2.left.val = 3;
        root2.left.left = new TreeNode();
        root2.left.left.val = 5;
        root2.left.left.left = new TreeNode();
        root2.left.left.left.val = 7;
        root2.left.left.left.left = new TreeNode();
        root2.left.left.left.left.val = 9;
        System.out.println("\n");
        System.out.println(PrintFromTopToBottom(root2));
        System.out.println(PrintFromTopToBottom2(root2));

        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        TreeNode root3 = new TreeNode();
        root3.val = 0;
        root3.right = new TreeNode();
        root3.right.val = 2;
        root3.right.right = new TreeNode();
        root3.right.right.val = 4;
        root3.right.right.right = new TreeNode();
        root3.right.right.right.val = 6;
        root3.right.right.right.right = new TreeNode();
        root3.right.right.right.right.val = 8;
        System.out.println("\n");
        System.out.println(PrintFromTopToBottom(root3));
        System.out.println(PrintFromTopToBottom2(root3));

        // 1
        TreeNode root4 = new TreeNode();
        root4.val = 1;
        System.out.println("\n");
        System.out.println(PrintFromTopToBottom(root4));
        System.out.println(PrintFromTopToBottom2(root4));

        // null
        System.out.println("\n");
        System.out.println(PrintFromTopToBottom(null));
        System.out.println(PrintFromTopToBottom2(null));
    }
}
