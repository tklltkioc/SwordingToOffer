package SwordingToOffer;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListRever {
    public static class ListNode {
        int val;
        ListNode nxt;
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> s = new Stack<> ();
        while (listNode != null) {
            s.push (listNode.val);
            listNode = listNode.nxt;
        }
        ArrayList<Integer> list = new ArrayList<> ();
        while (!s.isEmpty ()) {
            list.add (s.pop ());
        }
        return list;
    }

    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<> ();
        while (root != null) {
            stack.push (root);
            root = root.nxt;
        }
        ListNode tmp;
        while (!stack.isEmpty ()) {
            tmp = stack.pop ();
            System.out.print (tmp.val + " ");
        }
    }

    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion (root.nxt);
            System.out.print (root.val + " ");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode root = new ListNode ();
        root.val = 1;
        root.nxt = new ListNode ();
        root.nxt.val = 2;
        root.nxt.nxt = new ListNode ();
        root.nxt.nxt.val = 3;
        root.nxt.nxt.nxt = new ListNode ();
        root.nxt.nxt.nxt.val = 4;
        printListInverselyUsingIteration (root);
        printListInverselyUsingRecursion (root);
//		printListFromTailToHead(root);

    }

}
