package SwordingToOffer;


public class subTree {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
//    public TreeNode(int val) {
//        this.val = val;
//    }
    }

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。
     * 该方法是在A树中找到一个与B树的根节点相等的元素的结点，
     * 从这个相等的结点开始判断树B是不是树A的子结构，如果找到其的一个就返回，
     * 否则直到所有的结点都找完为止。
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasSubtree (TreeNode root1, TreeNode root2) {
//        if (root1==root2){
//            return true;
//        }
//        if (root1==null){
//            return false;
//        }
//        if (root2==null){
//            return true;
//        }
//        boolean result=false;
//        if (root1.val==root2.val){
//            result= match(root1,root2);
//        }
//        if (result){
//            return true;
//        }
        if (root1 == null || root2 == null) return false;
        return match (root1, root2) || hasSubtree (root1.left, root2) || hasSubtree (root1.right, root2);
    }

    /**
     * 从树A根结点root1和树B根结点root2开始，一个一个元素进行判断，判断B是不是A的子结构
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean match (TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        // 如果两个结点的值相等，则分别判断其左子结点和右子结点
        if (equal (root1.val, root2.val)) {
            return match (root1.left, root2.left) && match (root1.right, root2.right);
        }
        return false;
    }

    public static boolean equal (double n1, double n2) {
        if ((n1 - n2 > -0.0000001) && (n1 - n2 < 0.0000001))
            return true;
        else
            return false;
    }

    public static void main (String[] args) {
        TreeNode root1 = new TreeNode ();
        root1.val = 8;
        root1.right = new TreeNode ();
        root1.right.val = 7;
        root1.left = new TreeNode ();
        root1.left.val = 8;
        root1.left.left = new TreeNode ();
        root1.left.left.val = 9;
        root1.left.right = new TreeNode ();
        root1.left.right.val = 2;
        root1.left.right.left = new TreeNode ();
        root1.left.right.left.left = new TreeNode ();
        root1.left.right.left.left.val = 4;
        root1.left.right.left.right = new TreeNode ();
        root1.left.right.left.right.val = 7;

        TreeNode root2 = new TreeNode ();
        root2.val = 8;
        root2.left = new TreeNode ();
        root2.left.val = 9;
        root2.right = new TreeNode ();
        root2.right.val = 2;

        System.out.println (hasSubtree (root1, root2));
        System.out.println (hasSubtree (root2, root1));
        System.out.println (hasSubtree (root1, root1.left));
        System.out.println (hasSubtree (root1, null));
        System.out.println (hasSubtree (null, root2));
        System.out.println (hasSubtree (null, null));
    }
}
