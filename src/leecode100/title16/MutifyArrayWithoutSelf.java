package leecode100.title16;

/**
 * 题目：
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 */
public class MutifyArrayWithoutSelf {

    /**
     * 思路：当前数值除它本身以外的乘积可以使用前缀乘积和后缀乘积实现即可
     */

    public static void main(String[] args) {
        int[] num = new int[]{-1,1,0,-3,3};
        int[] result = new MutifyArrayWithoutSelf().productExceptSelf(num);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    public int[] productExceptSelf(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] afterSum = new int[nums.length];
        int[] result = new int[nums.length];
        prefixSum[0] = afterSum[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            afterSum[i] = afterSum[i + 1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixSum[i] * afterSum[i];
        }
        return result;
    }

}
