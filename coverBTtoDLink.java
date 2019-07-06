package swordingTooffer;

import java.util.Stack;

public class coverBTtoDLink {
    public static TreeNode Convert(TreeNode root){
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }
    public static TreeNode Convert2(TreeNode pRootOfTree){
        if (pRootOfTree==null)return null;
        Stack<TreeNode>stack=new Stack<>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                pRootOfTree = p;// 将中序遍历序列中的第一个节点记为root
                pre = pRootOfTree;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;//右子树
        }
        return pRootOfTree;
    }
    public static TreeNode Convert3(TreeNode pRootOfTree){
//        Stack<TreeNode>st=new Stack<>();
        if (pRootOfTree==null)return null;
        if (pRootOfTree.right==null&&pRootOfTree.left==null)return pRootOfTree;
        TreeNode leFt=Convert3(pRootOfTree.left);
        TreeNode pp=leFt;
        while (pp!=null&&pp.right!=null){
            pp=pp.right;
        }if (leFt!=null){
            pp.right=pRootOfTree;
            pRootOfTree.left=pp;
        }
        TreeNode rihght=Convert3(pRootOfTree.right);
            if (rihght!=null){
            rihght.left=pRootOfTree;
            pRootOfTree.right=rihght;
        }
        return leFt==null?pRootOfTree:leFt;
    }

    public static void main(String[] args) {
        test01();
//        test02();
//        test03();
//        test04();
//        test05();
    }

    private static void printList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.right;
        }

        System.out.println("null");
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + "->");
            printTree(root.right);
        }
    }


    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        TreeNode node10 = new TreeNode();
        node10.val = 10;

        TreeNode node6 = new TreeNode();
        node6.val = 6;

        TreeNode node14 = new TreeNode();
        node14.val = 14;

        TreeNode node4 = new TreeNode();
        node4.val = 4;

        TreeNode node8 = new TreeNode();
        node8.val = 8;

        TreeNode node12 = new TreeNode();
        node12.val = 12;

        TreeNode node16 = new TreeNode();
        node16.val = 16;

        node10.left = node6;
        node10.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;

        System.out.print("Before convert: ");
        printTree(node10);
        System.out.println("null");
        TreeNode head = Convert3(node10);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();

    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    private static void test02() {
        TreeNode node1 = new TreeNode();
        node1.val = 1;

        TreeNode node2 = new TreeNode();
        node2.val = 2;

        TreeNode node3 = new TreeNode();
        node3.val = 3;

        TreeNode node4 = new TreeNode();
        node4.val = 4;

        TreeNode node5 = new TreeNode();
        node5.val = 5;

        node5.left = node4;
        node4.left = node3;
        node3.left = node2;
        node2.left = node1;

        System.out.print("Before convert: ");
        printTree(node5);
        System.out.println("null");
        TreeNode head = Convert(node5);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test03() {
        TreeNode node1 = new TreeNode();
        node1.val = 1;

        TreeNode node2 = new TreeNode();
        node2.val = 2;

        TreeNode node3 = new TreeNode();
        node3.val = 3;

        TreeNode node4 = new TreeNode();
        node4.val = 4;

        TreeNode node5 = new TreeNode();
        node5.val = 5;

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        TreeNode head = Convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 只有一个结点
    private static void test04() {
        TreeNode node1 = new TreeNode();
        node1.val = 1;

        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        TreeNode head = Convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 没有结点
    private static void test05() {
        System.out.print("Before convert: ");
        printTree(null);
        System.out.println("null");
        TreeNode head = Convert(null);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }
}
