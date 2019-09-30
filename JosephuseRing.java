package SwordingToOffer;
// 约瑟夫环
public class JosephuseRing {
    private static class ListNode {
        int val;
        ListNode next = null;

//    ListNode(int val) {
//        this.val = val;
//    }
    }
    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) return -1;
        return (LastRemaining_Solution (n - 1, m) + m) % n;
    }

    public static int LastRemaining_Solution2(int n, int m) {
        if (m <= 0 || n <= 0) {
            return -1;
        }
        //先构造循环链表
        ListNode head = new ListNode (); //头结点, 值为0
        head.val = 0;
        ListNode pre = head;
        ListNode temp = null;
        for (int i = 1; i < n; i++) {
            temp = new ListNode ();
            temp.val = i;
            pre.next = temp;
            pre = temp;
        }
        temp.next = head;//将第n-1个结点(也就是尾结点)指向头结点

        ListNode temp2 = null;
        while (n != 1) {
            temp2 = head;
            //先找到第m个结点的前驱
            for (int i = 1; i < m - 1; i++) {
                temp2 = temp2.next;
            }
            //删除第m个结点：将第m个结点的前驱指向第m个结点后面那个结点,temp2表示第m个结点的前驱
            temp2.next = temp2.next.next;
            head = temp2.next; //更新头结点
            n--;
        }
        return head.val;
    }

    public static void main(String[] args) {
        System.out.println (LastRemaining_Solution (5, 6));
        System.out.println (LastRemaining_Solution2 (5, 3));
    }
}
