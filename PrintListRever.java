package 剑指;

import java.util.Stack;

public class PrintListRever {
	public static class ListNode{
		int val;
		ListNode nxt;
	}
	public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while(root!=null) {
        	stack.push(root);
        	root=root.nxt;
        }
        ListNode tmp;
        while(!stack.isEmpty()) {
        	tmp=stack.pop();
        	System.out.print(tmp.val+" ");
        }
    }
    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.nxt);
            System.out.print(root.val + " ");
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root=new ListNode();
		root.val=1;
		root.nxt=new ListNode();
		root.nxt.val=2;
		root.nxt.nxt=new ListNode();
		root.nxt.nxt.val=3;
		root.nxt.nxt.nxt=new ListNode();
		root.nxt.nxt.nxt.val=4;
		printListInverselyUsingIteration(root);
		printListInverselyUsingRecursion(root);

	}

}
