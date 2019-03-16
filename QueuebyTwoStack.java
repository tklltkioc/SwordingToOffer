package 剑指;

import java.util.Stack;

public class QueuebyTwoStack<T> {
	Stack<T>stack1=new Stack<>();
	Stack<T>stack2=new Stack<>();
	public void push(T node) {
		stack1.add(node);
	}
	public T pop() {
		if(stack1.isEmpty()&&stack2.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
	public static void main(String[] args) {
		QueuebyTwoStack<Integer> q=new QueuebyTwoStack<Integer>();
		q.push(0);
		q.push(2);
		q.push(3);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		q.push(4);
		System.out.println(q.pop());
	}

}
