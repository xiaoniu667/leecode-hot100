package leecode100.title48;

import leecode100.DataStruct.TreeNode;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 题目：路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 */
public class SumOfRoad {

    /**
     * 思路：利用前缀和解决，
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        int pathSum = new SumOfRoad().pathSum(root, -1);
        System.out.println(pathSum);
    }

    public int pathSum(TreeNode root, int targetSum) {
        // 使用 HashMap 记录路径上的前缀和及其出现次数
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        // 初始化空路径的前缀和为 0，出现 1 次
        prefixSumCount.put(0L, 1);
        // 调用递归函数，初始前缀和为 0
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    // 递归函数，计算以当前节点为终点的满足条件的路径数量
    // currSum: 从根到当前节点的前缀和
    // targetSum: 目标和
    // prefixSumCount: 存储前缀和及其出现次数的哈希表
    private int dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        // 如果节点为空，直接返回 0
        if (node == null) {
            return 0;
        }

        // 更新当前路径的前缀和
        currSum += node.val;

        // 计算以当前节点为终点的满足条件的路径数量
        // 查找是否存在前缀和 prevSum，使得 currSum - prevSum = targetSum
        int pathCount = prefixSumCount.getOrDefault(currSum - targetSum, 0);

        // 将当前前缀和加入哈希表，更新出现次数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // 递归处理左子树和右子树，累加路径数量
        pathCount += dfs(node.left, currSum, targetSum, prefixSumCount);
        pathCount += dfs(node.right, currSum, targetSum, prefixSumCount);

        // 回溯：移除当前前缀和，恢复哈希表状态
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return pathCount;
    }
}
