package leecode100.title47;

import leecode100.DataStruct.TreeNode;

/**
 * 题目：从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 */
public class CreateTreeFromPreAndPostOrder {
    /**
     * 思路：先确定根节点，刚开始根节点是preorder中的第一个节点
     * 划分左右子树，去中序遍历中寻找到这个节点，左边是左子树，右边是右子树。
     * 递归的构造子树，根据左子树节点数量，从前序遍历中划分出左子树的前序序列和右子树的前序序列
     * 递归地对左子树和右子树重复上述过程：
     * 左子树：用左子树的前序和中序序列构造左子树。
     * 右子树：用右子树的前序和中序序列构造右子树。
     */
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        new CreateTreeFromPreAndPostOrder().buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend) {
        if (prestart > preend || instart > inend) return null;
        int rootval = preorder[prestart];
        TreeNode root = new TreeNode(rootval);
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (rootval == inorder[i]) {
                break;
            }
        }
        //左子树的长度
        int llen = i - instart;

        //递归构造左右子树
        root.left = buildTreeHelper(preorder, inorder, prestart + 1, prestart + llen, instart, i - 1);
        root.right = buildTreeHelper(preorder, inorder, prestart + llen + 1, preend, i + 1, inend);

        return root;
    }
}
