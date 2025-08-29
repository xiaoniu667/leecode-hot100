package leecode100.title40;

import leecode100.DataStruct.TreeNode;
import leecode100.DataStruct.utils.TreeUtils;
import leecode100.title38.ReverseTree;

/**
 * 题目：二叉树的直径
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class DiameterTree {

    /**
     * 思路：最大直径是左边的最大深度加上右边的最大深度，并且维护一个全局变量最大直径
     * 从根节点开始，递归遍历每个节点。
     * 对于每个节点：
     * 1.计算左子树和右子树的深度。
     * 2.更新全局最大直径（左深度 + 右深度）。
     * 3.返回当前子树的深度（max(左深度, 右深度) + 1）供上层节点使用。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int result = new DiameterTree().diameterOfBinaryTree(root);
        System.out.println(result);
    }

    public static int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return diameter;

    }

    private int getDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftdeep = getDiameter(root.left);
            int rightdeep = getDiameter(root.right);
            diameter = Math.max(diameter, leftdeep + rightdeep);  //leftdeep + rightdeep 表示以当前节点为路径顶点的路径长度。
            return Math.max(leftdeep, rightdeep) + 1; //表示当前子树的深度。
        }
    }
}
