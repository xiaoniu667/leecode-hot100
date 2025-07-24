package leecode100.title10;

import java.util.HashMap;

/**
 * 题目：
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2:
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class KSumSubArray {

    /**
     * 思路：遍历数组，统计前缀和并且将前缀和以及出现的次数，放入hashmap之中。
     * 后续利用s[j]-k去hashmap之中去找对应的前缀次数即可。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int result = new KSumSubArray().subarraySum(nums, 2);
        System.out.println(result);
    }

    /**
     * 模拟运行过程：1,1,1 k=2
     * sum = 0,1,2
     * hashmap=
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);//存储前缀和以及次数
        int sum = 0;//前缀和
        int total = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            int prefixSum = sum + nums[i]; //当前前缀和
            sum += nums[i];
            Integer count = hashMap.getOrDefault(prefixSum - k, 0);
            total = total + count;
            hashMap.put(prefixSum, hashMap.getOrDefault(prefixSum, 0) + 1);
        }
        return total;
    }
}
