package leecode100.title44;

import leecode100.DataStruct.TreeNode;

/**
 * 题目：
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）
 */
public class SearchKNum {

    /**
     * 思路：由于是二叉搜索树，所以对于中序排序就是递增的，用一个计数器记录节点序号，找到第k个节点时返回其值。
     */
    public static void main(String[] args) {

    }

    public static int count = 0;
    public static int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = 0; // 初始化计数器
        result = 0; // 初始化结果
        postOrder(root, k);
        return result;
    }

    private void postOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        postOrder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        postOrder(root.right, k);
    }
}
