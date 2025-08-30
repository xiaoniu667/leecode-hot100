package leecode100.title43;

import leecode100.DataStruct.TreeNode;

import java.util.ArrayList;

/**
 * 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效二叉搜索树定义如下：
 * 节点的左子树只包含 严格小于 当前节点的数。
 * 节点的右子树只包含 严格大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class VerfiySearchTree {
    /**
     * 思路：借助空间数组保存中序遍历的二叉树的顺序，如果是递增的数组就是二叉搜索树，如果不是的话就不是二叉搜索树。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
    }

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrder(result, root);
        Integer[] nums = result.toArray(new Integer[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private void postOrder(ArrayList<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(result, root.left);
        result.add(root.val);
        postOrder(result, root.right);
    }
}
