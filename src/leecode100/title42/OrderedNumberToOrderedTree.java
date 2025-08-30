package leecode100.title42;

import leecode100.DataStruct.TreeNode;

/**
 * 题目：将有序数组转为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 */
public class OrderedNumberToOrderedTree {
    /**
     * 思路：递归的构造二叉搜索树即可。
     */
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return ArrayToBST(0, nums.length - 1, nums);
    }

    private TreeNode ArrayToBST(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = ArrayToBST(left, mid - 1, nums);
        root.right = ArrayToBST(mid + 1, right, nums);
        return root;
    }
}
