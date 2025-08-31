package leecode100.title46;

import leecode100.DataStruct.TreeNode;

/**
 * 题目：二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class TreeNodeToLinkedNode {
    /**
     * 思路：后续遍历先处理左右子树，将左子树或者右子树展开之后，再处理根节点，根节点连接左子树或者右子树
     * 后序遍历先处理子树，确保左右子树已经是链表形式，再处理根节点时只需简单拼接。
     * 先序遍历处理根时，子树还没展开，连接会出错。
     */
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        //保存最右边的节点
        TreeNode rightTemp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = rightTemp;
    }


}
