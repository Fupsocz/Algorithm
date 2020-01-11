package other;

import java.util.LinkedList;
import java.util.Queue;

public class LeftBinaryTreeView{

    public class TreeNode{

        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
        }
    }

    /*
    二叉树左视图 右视图仅需将 == 0 改成 i == size - 1
     */
    public void leftBinaryTreeView(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<>();
        if(head == null){
            return;
        }
        queue.offer(head);
        int size = 1;
        int child;
        while(!queue.isEmpty()){
            child = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == 0){
                    System.out.println(node.value);
                }
                if(node.left != null){
                    queue.offer(node.left);
                    child++;
                }
                if(node.right != null){
                    queue.offer(node.right);
                    child++;
                }
            }
            size = child;
        }
    }
}