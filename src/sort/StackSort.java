package sort;

import java.util.Stack;

public class StackSort {

    // 用一个栈对另一个无序的栈进行排序
    public static Stack<Integer> stackSort(Stack<Integer> stack) {

        Stack<Integer> s = new Stack<>();
        int temp;

        while(!stack.isEmpty()){

            temp = stack.pop();
            while(!s.isEmpty() && s.peek() > temp){
                stack.push(s.pop());
            }
            s.push(temp);
        }

        return s;
    }
}
