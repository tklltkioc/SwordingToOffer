package swordingTooffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根结点开始往下一直到叶销点所经过的结点形成一条路径。
 */
public class FindPathInBST {
    private static ArrayList<ArrayList<Integer>>listAll=new ArrayList<>();
    private static ArrayList<Integer>list=new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null)return listAll;
        list.add(root.val);
//        int target2=0;
//        target2+=root.val;
        target-=root.val;
        //到达叶子节点
        if (target==0&&root.left==null&&root.right==null){
            listAll.add(new ArrayList<>(list));
        }if (root.left!=null){
            FindPath(root.left,target);
        }
        if (root.right!=null){
            FindPath(root.right,target);
        }
        list.remove(list.size()-1);
        return listAll;
    }
    public static ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        // 创建一个链表，用于存放根结点到当前处理结点的所经过的结点
        List<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>>listAll=new ArrayList<>();
        // 如果根结点不为空，就调用辅助处理方法
        if (root != null) {
            findPath(root, 0, target, list,listAll);
        }
        //降序
        Collections.sort(listAll, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()<o2.size())
                    return 1;
                else if(o1.size()==o2.size())
                    return 0;
                else
                    return -1;
            }
        });
        return listAll;
    }
    public static void findPath(TreeNode root, int curSum, int target, List<Integer> result,ArrayList<ArrayList<Integer>>listAll) {
        // 如果结点不为空就进行处理
        if (root != null) {
            // 加上当前结点的值
            curSum += root.val;
            // 将当前结点入队
            result.add(root.val);
            // 如果当前结点的值小于期望的和
            if (curSum < target) {
                // 递归处理左子树
                if (root.left!=null){
                    findPath(root.left, curSum, target, result,listAll);
                }
                // 递归处理右子树
                if (root.right!=null){
                    findPath(root.right, curSum, target, result,listAll);
                }
            }
            // 如果当前和与期望的和相等
            else if (curSum == target) {
                // 当前结点是叶结点，则输出结果
                if (root.left == null && root.right == null) {
                    listAll.add(new ArrayList<>(result));
//                    System.out.println(result);
                }
            }
            // 移除当前结点
            result.remove(result.size() - 1);
        }
    }
    public static ArrayList<ArrayList<Integer>> FindPath3(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
        if(root==null)return paths;
        find(paths,new ArrayList<Integer>(),root,target);
        Collections.sort(paths, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()>o2.size())
                    return -1;
                else if(o1.size()==o2.size())
                    return 0;
                else
                    return 1;
            }
        });
        return paths;
    }

    public static void find(ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path,TreeNode root,int target){
        path.add(root.val);
        if(root.left==null&&root.right==null){
            if(target==root.val){
                paths.add(path);
            }
            return;
        }
        ArrayList<Integer> path2=new ArrayList<>();
        path2.addAll(path);
        if(root.left!=null)find(paths,path,root.left,target-root.val);
        if(root.right!=null)find(paths,path2,root.right,target-root.val);
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 10;
        root.left = new TreeNode();
        root.left.val = 5;
        root.left.left = new TreeNode();
        root.left.left.val = 4;
        root.left.right = new TreeNode();
        root.left.right.val = 7;
        root.right = new TreeNode();
        root.right.val = 12;
//        10,5,12,4,7
//        System.out.println(FindPath(root,22));
//        FindPath2(root,22);
//        System.out.println(FindPath(null,0));
//        System.out.println(FindPath2(root,22));
//        System.out.println(FindPath3(root,22));
        TreeNode root2 = new TreeNode();
        root2.val = 10;
        root2.right = new TreeNode();
        root2.right.val = 5;
        root2.right.right = new TreeNode();
        root2.right.right.val = 4;
        root2.right.left = new TreeNode();
        root2.right.left.val = 7;
        root2.left = new TreeNode();
        root2.left.val = 12;
        System.out.println(FindPath2(root2,22));
//        System.out.println(FindPath3(root2,22));

    }
}
