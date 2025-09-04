package leecode100.title49;

import leecode100.DataStruct.TreeNode;

import java.util.Stack;

/**
 * 最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class TheLeatestCommonAncestor {

    /**
     * 思路：利用深度优先搜索递归，利用栈保存遍历到目标节点的路径。
     * 最后通过出栈对比两个栈，找到最近公共祖先
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode treeNode = new TheLeatestCommonAncestor().lowestCommonAncestor(root, root.left.left, root.left.right.right);
        System.out.println(treeNode.val);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> currentpathp = new Stack<>();
        Stack<TreeNode> currentpathq = new Stack<>();
        Stack<TreeNode> pathp = new Stack<>();
        Stack<TreeNode> pathq = new Stack<>();
        dfs(pathp, currentpathp, root, p);
        dfs(pathq, currentpathq, root, q);
        while (!pathp.isEmpty() && !pathq.isEmpty()) {
            TreeNode nodep = pathp.peek();
            TreeNode nodeq = pathq.peek();
            if (nodep == nodeq) {
                return nodep;
            }
            if (pathp.size() > pathq.size()) {
                pathp.pop();
            } else if (pathp.size() < pathq.size()) {
                pathq.pop();
            } else {
                pathp.pop();
                pathq.pop();
            }
        }


        return root;
    }

    /**
     * 通过dfs找到目标节点的路径
     *
     * @param pathp
     * @param root
     * @param p
     */
    private void dfs(Stack<TreeNode> pathp, Stack<TreeNode> currentpathp, TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        if (root == p) {
            currentpathp.push(root);
            //结束加入路径的方式是交给pathp栈
            pathp.addAll(currentpathp);
            return;
        }
        currentpathp.push(root);
        dfs(pathp, currentpathp, root.left, p);
        dfs(pathp, currentpathp, root.right, p);
        currentpathp.pop(); //回溯
    }


}
