package other;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKCrossTwoArrays {

    /**
     * 有两个数组，求K个两数组任选一个数字的最大和
     */

    public static class Node{
        public int index1;
        public int index2;
        public int sum;

        public Node(int index1, int index2, int sum){
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }
    }

    public static class MaxHeapComp implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.sum - o1.sum;
        }
    }

    public static int[] topKSum(int a1[], int a2[], int topK){
        if (a1 == null || a2 == null || topK < 1){
            return null;
        }
        topK = Math.min(topK, a1.length * a2.length);
        int res[] = new int[topK];
        int resIndex = 0;
        PriorityQueue<Node> maxHeap = new PriorityQueue<>();
        boolean[][] set = new boolean[a1.length][a2.length];
        int i1 = a1.length - 1;
        int i2 = a2.length - 1;
        maxHeap.add(new Node(i1, i2, a1[i1] + a2[i2]));
        set[i1][i2] = true;
        while (resIndex != topK){
            Node curNode = maxHeap.poll();
            res[resIndex++] = curNode.sum;
            i1 = curNode.index1;
            i2 = curNode.index2;
            if (!set[i1 - 1][i2]){
                set[i1 - 1][i2] = true;
                maxHeap.add(new Node(i1 - 1, i2, a1[i1 - 1] + a2[i2]));
            }
            if (!set[i1][i2 - 1]){
                set[i1][i2 - 1] = true;
                maxHeap.add(new Node(i1, i2 - 1, a1[i1] + a2[i2 - 1]));
            }
        }
        return res;
    }
}
