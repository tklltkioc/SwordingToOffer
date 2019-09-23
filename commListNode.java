package SwordingToOffer;

// 找出2个链表的公共节点
public class commListNode {
    //用两个指针扫描"两个链表"，最终两个指针到达 null 或者到达公共结点。
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }

    //找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走（因为2个链表用公共的尾部）
    public static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        int len1 = findListLenth (pHead1);
        int len2 = findListLenth (pHead2);
        if (len1 > len2) {
            pHead1 = walkStep (pHead1, len1 - len2);
        } else {
            pHead2 = walkStep (pHead2, len2 - len1);
        }
        while (pHead1 != null) {
            if (pHead1 == pHead2) return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    public static int findListLenth(ListNode head) {
        int result = 0;
        while (head != null) {
            result++;
            head = head.next;
        }
        return result;
    }

    public static ListNode walkStep(ListNode pHead1, int step) {
        while (step-- != 0) {
            pHead1 = pHead1.next;
        }
        return pHead1;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode ();
        n1.val = 1;
        ListNode n2 = new ListNode ();
        n2.val = 2;
        ListNode n3 = new ListNode ();
        n3.val = 3;
        ListNode n4 = new ListNode ();
        n4.val = 4;
        ListNode n5 = new ListNode ();
        n5.val = 5;
        ListNode n6 = new ListNode ();
        n6.val = 6;
        ListNode n7 = new ListNode ();
        n7.val = 7;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n5.next = n6;
        n6.next = n7;
        System.out.println (FindFirstCommonNode (n1, n5));
        System.out.println (FindFirstCommonNode2 (n1, n5));

    }

}
