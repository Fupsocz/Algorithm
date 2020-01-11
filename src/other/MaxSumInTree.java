package other;

import java.util.HashMap;
import java.util.Stack;

public class MaxSumInTree {

    /**
     * 给定一个二叉树，每个节点都有一个整数值，求任意一条路径上整数值和最大值
     */

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int val) {
            value = val;
        }
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public static int maxSumInTree01(Node head){
        return process(head, 0);
    }

    public static int process(Node x, int pre){
        if (x == null){
            return Integer.MIN_VALUE;
        }

        if (x.left == null && x.right == null){
           return x.value + pre;
        }

        int leftMax = process(x.left, x.value + pre);
        int rightMax = process(x.right, x.value + pre);
        return Math.max(leftMax,rightMax);
    }

    /**
     * 非递归解法
     */
    public static int maxSumInTree(Node head){
        int max = 0;
        HashMap<Node,Integer> map = new HashMap<>();
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            map.put(head, head.value);
            while (stack != null){
                head = stack.pop();
                if (head.left == null && head.right == null){
                    max = Math.max(max,map.get(head));
                }
                if (head.right != null){
                    map.put(head.right,map.get(head) + head.right.value);
                    stack.push(head.right);
                }
                if (head.left != null){
                    map.put(head.left, map.get(head) + head.left.value);
                    stack.push(head.left);
                }
            }
        }
        return max;
    }
}
