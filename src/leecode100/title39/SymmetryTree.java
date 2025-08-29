package leecode100.title39;

import leecode100.DataStruct.TreeNode;

/**
 * 题目；对称二叉树
 * 给你一个二叉树的根节点，检查它是否对称
 */
public class SymmetryTree {
    /**
     * 思路：对称镜像的定义是  左子树的左节点等于右子树的右节点，左子树的右节点等于右子树的左节点
     * 对于两棵子树（假设为 left 和 right），它们镜像对称需要满足：
     * 两棵子树的根节点值相等。
     * left 的左子树与 right 的右子树镜像对称。
     * left 的右子树与 right 的左子树镜像对称。
     * 如果任一条件不满足（例如一个节点为空而另一个不为空，或者值不相等），则不对称。
     */
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Symmetric(root.left, root.right);
    }

    /**
     * 递归的判断左右子树是否是镜像的
     *
     * @return
     */
    private boolean Symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && Symmetric(left.right, right.left) && Symmetric(left.left, right.right);
    }
}
