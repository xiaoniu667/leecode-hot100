package leecode100.title50;

import leecode100.DataStruct.TreeNode;

/**
 * 题目：二叉树最大路径和
 * 二叉树中的路径被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中至多出现一次 。该路径至少包含一个节点，且不一定经过根节点。
 * 路径和是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其最大路径和。
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 */
public class TheLargestSumofRoad {

    /**
     * 思路：后序遍历，先求左右子树，再求根节点。
     * 计算左子树最大单边路径和，再求右子树最大单边路径和，最后基于当前的节点，以及左右子树的单边路径和，计算当前节点的最大路径和，并且更新全局的路径。
     * 对于每个节点：
     * 递归计算左子树和右子树的最大单边路径和（如果子树为空，返回0）。
     * 单边路径和只考虑正贡献（如果子树路径和为负，则忽略，视作0）。
     * 当前节点的最大单边路径和 = 当前节点值 + max(左子树单边路径和, 右子树单边路径和, 0)。
     * 当前节点的最大路径和 = 当前节点值 + 左子树单边路径和 + 右子树单边路径和。
     * 更新全局最大路径和，比较当前节点的最大路径和与全局记录。
     * 递归返回单边路径和，供上层节点使用。
     */
    public static void main(String[] args) {

    }

    public static int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        findMaxPathSumHelper(root);
        return maxPath;
    }

    private int findMaxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //保存左右子树的最大单边路径和和
        int leftPathSum = Math.max(findMaxPathSumHelper(root.left), 0);
        int rightPathSum = Math.max(findMaxPathSumHelper(root.right), 0);

        //计算当前节点的最大路径和
        int currentSum = root.val + leftPathSum + rightPathSum;
        //更新全局变量
        maxPath = Math.max(maxPath, currentSum);
        //返回当前节点的最大单边路径 供上层节点使用。
        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}
