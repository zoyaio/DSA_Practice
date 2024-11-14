package stacks;

import java.util.Stack;

public class Play {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.toString());
        stack.push(3);
        stack.pop();

    }
}
