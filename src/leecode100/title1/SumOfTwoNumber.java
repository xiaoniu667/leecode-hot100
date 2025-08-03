package leecode100.title1;

import java.util.HashMap;

/**
 * 题目：给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class SumOfTwoNumber {

    /*
         思路：利用hashmap时间复杂度可以降到o1
              hashmap以key value存储，其中key存储value，value存储index
              diff = target-num[i]
              遍历nums如果这个diff在hashmap的key中存在，直接返回i和hashmap.get(diff)
     */


    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int[] indexs = new SumOfTwoNumber().twoSum(numbers, 9);
        for (int i = indexs.length - 1; i >= 0; i--) {
            System.out.print(indexs[i] + " ");
        }
    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashmap.keySet().contains(new Integer(target - nums[i]))) {
                return new int[]{i, hashmap.get(target - nums[i])};
            }
            hashmap.put(nums[i], i);
        }
        return new int[]{};
    }
}
