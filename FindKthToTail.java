package SwordingToOffer;

public class FindKthToTail {
    private static class ListNode {
        int val;
        ListNode next = null;

//    ListNode(int val) {
//        this.val = val;
//    }
    }
    public static ListNode FindKthToTail (ListNode head, int k) {
        if (k < 1 || head == null) {
            return null;
        }
        ListNode p1, p2 = null;
        p1 = head;
        p2 = head;
        int a = k;
        int count = 0;
        while (p1 != null) {
            p1 = p1.next;
            count++;
            if (k < 1) {
                p2 = p2.next;
            }
            k--;
        }
        if (count < a) return null;
        return p2;
    }

    public static void main (String[] args) {
//         ListNode head=new ListNode(0);
//         head.next=new ListNode(1);
//         head.next.next=new ListNode(2);
//         head.next.next.next=new ListNode(3);
//        System.out.println(FindKthToTail(head,5));
//        System.out.println(FindKthToTail(head,1).val);


    }


}
