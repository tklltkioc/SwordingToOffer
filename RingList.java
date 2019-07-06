package swordingTooffer;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class RingList {
    public static ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode fast=pHead;
        ListNode slow=pHead;
        if (fast==null||fast.next==null)
            return null;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)
                break;
        }

        fast=pHead;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }

    public static ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        HashSet<ListNode> set=new LinkedHashSet<>();
        ListNode current=pHead;
        while(current!=null){
            if(set.contains(current)){
                return current;
            }
            set.add(current);
            current=current.next;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode();
        head.val=0;
        head.next=new ListNode();
        head.next.val=1;
        head.next.next=new ListNode();
        head.next.next.val=2;
        head.next.next.next=new ListNode();
        head.next.next.next.val=3;
        head.next.next.next.next=head.next.next;
        head.next.next.next.next.next=head.next.next.next;
        ListNode testNode=EntryNodeOfLoop(head);
        ListNode testNode2=EntryNodeOfLoop2(head);
        System.out.println(testNode.val);
        System.out.println(testNode2.val);

    }
}
