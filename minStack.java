package SwordingToOffer;

import java.util.Iterator;
import java.util.Stack;

public class minStack<I extends Number> {
    static Stack<Integer> sk = new Stack<> ();

    public static void push (int node) {
        sk.push (node);

    }

    public static void pop () {
        sk.pop ();
    }

    public static int top () {
        return sk.peek ();
    }

    public static int min () {
        int min = sk.peek ();
        int tmp = 0;
        Iterator<Integer> it = sk.iterator ();
        while (it.hasNext ()) {
            tmp = it.next ();
            if (min > tmp)
                min = tmp;
        }
        return min;
    }

    public static void main (String[] args) {
        minStack<Integer> stack = new minStack<Integer> ();
        stack.push (3);
        System.out.println (stack.min () == 3);
        stack.push (4);
        System.out.println (stack.min () == 3);
        stack.push (2);
        System.out.println (stack.min () == 2);
        stack.push (3);
        System.out.println (stack.min () == 2);
        stack.pop ();
        System.out.println (stack.min () == 2);
        stack.pop ();
        System.out.println (stack.min () == 2);
        stack.push (0);
        System.out.println (stack.min () == 0);
    }

}
