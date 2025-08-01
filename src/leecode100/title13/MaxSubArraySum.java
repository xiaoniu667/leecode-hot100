package leecode100.title13;

/**
 * 最大子数组和
 * 题目：给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaxSubArraySum {

    /**
     * 思路： kadane算法，动态规划的应用 最优子结构 重叠子问题   可以用一个临时的变量记录下来
     * 核心解题思路：计算当前位置的最大和取决于当前位置大还是以这个数结尾的子数组之和大。
     * 有一个很好玩的应用就是股票收益，当前你是否需要加仓还是清仓，取决于当天的收益大还是之前连续的某一天收益大。
     */

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = new MaxSubArraySum().maxSubArray(nums);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            currentSum = Math.max(currentSum,nums[i]);;
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;

    }


}
