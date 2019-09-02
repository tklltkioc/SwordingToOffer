package SwordingToOffer;

public class mergeLinkList {
    public static ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode pHead;//新链表的头结点
        ListNode pCur;//新链表的当前处理节点
        //得到新链表初始头节点
        if (head1.val < head2.val) {
            pHead = head1;
            pCur = head1;
            head1 = head1.next;
        } else {
            pHead = head2;
            pCur = head2;
            head2 = head2.next;
        }
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                pCur.next = head1;
                pCur = pCur.next;
                head1 = head1.next;
            } else {
                pCur.next = head2;
                pCur = pCur.next;
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            pCur.next = head1;
        }
        if (head2 != null) {
            pCur.next = head2;
        }
        return pHead;
    }

    public static ListNode mergeList2(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode tmp = head1;
        if (tmp.val < head2.val) {
            tmp.next = mergeList2 (head1.next, head2);
        } else {
            tmp = head2;
            tmp.next = mergeList2 (head1, head2.next);
        }
        return tmp;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print (head.val + "->");
            head = head.next;
        }
        System.out.println ("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode ();
        head.val = 1;

        head.next = new ListNode ();
        head.next.val = 2;

        head.next.next = new ListNode ();
        head.next.next.val = 3;

        head.next.next.next = new ListNode ();
        head.next.next.next.val = 4;

        head.next.next.next.next = new ListNode ();
        head.next.next.next.next.val = 5;


        ListNode head2 = new ListNode ();
        head2.val = 1;

        head2.next = new ListNode ();
        head2.next.val = 3;

        head2.next.next = new ListNode ();
        head2.next.next.val = 5;

        head2.next.next.next = new ListNode ();
        head2.next.next.next.val = 6;

        head2.next.next.next.next = new ListNode ();
        head2.next.next.next.next.val = 7;

//        head = mergeList(head, head2);
        head = mergeList2 (head, head2);
        printList (head);
    }
}
