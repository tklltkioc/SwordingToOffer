package swordingTooffer;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackbyTwoQueue<T> {
	Queue<T>queue1=new ArrayDeque<>();
	Queue<T>queue2=new ArrayDeque<>();
	public void push(T node) {
		if(queue1.isEmpty()&&queue2.isEmpty()) {
			queue1.add(node);
			return;
		}
		if(queue1.isEmpty()) {
			queue2.add(node);
			return;
		}
		if(queue2.isEmpty()) {
			queue1.add(node);
			return;
		}
	}
	public T pop() {
		if(queue1.isEmpty()&&queue2.isEmpty()) {
//			try {
				throw new RuntimeException("stack is empty");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
		if(queue1.isEmpty()) {
			while(queue2.size()>1) {
				queue1.add(queue2.poll());
			}
			return queue2.poll();
		}
		if(queue2.isEmpty()) {
			while(queue1.size()>1) {
				queue2.add(queue1.poll());
			}
			return queue1.poll();
		}
		return null;
	}
	public static void main(String[]args) {
		StackbyTwoQueue<Integer>qs=new StackbyTwoQueue<Integer>();
		qs.push(0);
		qs.push(1);
		qs.push(2);
		System.out.println(qs.pop());
		System.out.println(qs.pop());
		qs.push(3);
		System.out.println(qs.pop());
	}
}
