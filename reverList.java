package SwordingToOffer;

public class reverList {
    public static ListNode reverList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode nex = null;
        ListNode reHead = null;
        while (cur != null) {
            nex = head.next;
            cur.next = reHead;
            reHead = cur;
            cur = nex;
        }
        return reHead;
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode rever = ReverseList (head.next);
        head.next.next = head;
        head.next = null;
        return rever;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode ();
        head.val = 0;
        head.next = new ListNode ();
        head.next.val = 1;
        head.next.next = new ListNode ();
        head.next.next.val = 2;
        head.next.next.next = new ListNode ();
        head.next.next.next.val = 3;
//        head.next.next.next.next=head.next.next;
//        head.next.next.next.next.next=head.next.next.next;
//        ListNode testNode= reverList(head);
        ListNode testNode = ReverseList (head);
        System.out.println (testNode.val + " " + testNode.next.val);

    }

}
