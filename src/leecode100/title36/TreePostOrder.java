package leecode100.title36;

import leecode100.DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/***
 * 题目：二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的中序遍历 。
 */
public class TreePostOrder {
    /**
     * 思路：中序遍历就是左根右遍历  先处理左子树 然后处理根节点  最后处理右子树
     */
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}
