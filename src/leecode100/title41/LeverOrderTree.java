package leecode100.title41;

import leecode100.DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LeverOrderTree {
    /**
     * 用队列解决即可，队列存储每一层的节点然后依次遍历放到结果即可里面即可
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        for (List<Integer> integers : new LeverOrderTree().levelOrder(root)) {
            integers.forEach(System.out::println);
            System.out.println();
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results; // 空树返回空列表
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode != null) { // 检查节点非空
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                    }
                }
            }
            results.add(list);
        }
        return results;
    }
}
