package leecode100.title37;

import leecode100.DataStruct.TreeNode;
import leecode100.DataStruct.utils.TreeUtils;

/**
 * 题目：树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class TreeMaxDeep {

    /**
     * 思路：递归解决即可 当前节点的最大深度就是Max(左子树的深度或者右子树的深度)+1就是树的最大深度
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeUtils.printTree(root);
        int result = new TreeMaxDeep().maxDepth(root);
        System.out.println(result);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftdeep = maxDepth(root.left);
            int rightdeep = maxDepth(root.right);
            return Math.max(leftdeep, rightdeep) + 1;
        }
    }
}
