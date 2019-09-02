package SwordingToOffer;

/**
 * 因为输入的是根节点，序列化时要遍历该树，第一个进递归肯定是根节点。
 * 那么反序化时一开始String的index++，就变成了0，即指向该String的第一位。
 * 这就说明，第一个进递归的根节点， 在String上也是第一个，是第一个被访问的，这不就是先序遍历吗？
 * 总结：只有先序遍历才能符合递归的特点，方便地利用Index进行序列化和反序列化
 */

public class serializeAndDerisalize {
    static int index = -1;

    static String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer ();
        if (root == null) {
            sb.append ("#,");
            return sb.toString ();
        }
        sb.append (root.val + ",");
        sb.append (Serialize (root.left));
        sb.append (Serialize (root.right));
        return sb.toString ();
    }

    static TreeNode Deserialize(String str) {
        index++;
        int len = str.length ();
        if (index >= len) {
            return null;
        }
        String[] strr = str.split (",");
        TreeNode node = null;
        if (!strr[index].equals ("#")) {
            node = new TreeNode ();
            node.val = Integer.valueOf (strr[index]).intValue ();//转换为int类型
            node.left = Deserialize (str);
            node.right = Deserialize (str);
        }
        return node;
    }

    private static void print(TreeNode root) {
        if (root != null) {
            System.out.printf ("%-3d", root.val);
            print (root.left);
            print (root.right);
        }
    }

    public static void main(String[] args) {
        //        1
        //      /    \
        //     2      3
        //    / \    / \
        //   4   5  6   7
        //  / \
        // 8   9

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
        TreeNode n8 = new TreeNode ();
        n8.val = 8;
        TreeNode n9 = new TreeNode ();
        n9.val = 9;

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
//        String s=Serialize(n1);
//        System.out.println(s);
//        print(Deserialize(s));

        TreeNode nn1 = new TreeNode ();
        nn1.val = 1;
        TreeNode nn3 = new TreeNode ();
        nn3.val = 3;
        TreeNode nn4 = new TreeNode ();
        nn4.val = 4;
        TreeNode nn5 = new TreeNode ();
        nn5.val = 5;

        nn5.left = nn4;
        nn4.right = nn3;
        nn3.right = nn1;
        String sx = Serialize (nn5);
        System.out.println (sx);
        print (Deserialize (sx));


    }
}
