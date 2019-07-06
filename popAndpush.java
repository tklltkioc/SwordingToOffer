package swordingTooffer;

import java.util.Stack;

public class popAndpush {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) return false;
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        int j = 0;
        st.push(pushA[i++]);
        while(j <= popA.length-1){
            while(popA[j] != st.peek()){
                if(i == pushA.length) return false;
                st.push(pushA[i++]);
            }
            j++;
            st.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + IsPopOrder (push, pop1));
        System.out.println("true: " + IsPopOrder(push, pop2));
        System.out.println("false: " + IsPopOrder(push, pop3));
        System.out.println("false: " + IsPopOrder(push, pop4));
    }
}
