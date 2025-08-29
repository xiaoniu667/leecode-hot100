package leecode100.title38;

import leecode100.DataStruct.TreeNode;
import leecode100.DataStruct.utils.TreeUtils;

/**
 * https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 * 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class ReverseTree {

    /**
     * 思路：最大的根节点不动，让左子树变为右子树 右子树变为左子树
     */
    public static void main(String[] args) {
//      2
//    1   3
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode treeNode = new ReverseTree().invertTree(root);
        TreeUtils.printTree(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
