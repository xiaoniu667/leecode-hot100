package leecode100.title17;

/**
 * 缺失第一个整数
 * 题目：给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 */

public class LackFirstPostiveNumber {
    /**
     * 思路：用一个数组去存储当前数组中的数有没有出现过，如果出现过了就置为1,这个方法pass掉了，因为空间复杂度为O(1)
     * 另外一个思路：
     * 1.先将所有非正数和大于等于n+1的数标记为1，因为对后续判断来说没有影响。如果没有出现过1，直接返回1。
     * 2.然后将原来的数组当做索引，遍历num数组，记录下当前数的绝对值，假设是 x。然后跑到x-1的索引下面，标记这个数为负数。用于后续遍历
     * 3.遍历这个数组，如果是负数的话代表出现过了，没有出现过的下标+1就是最小正数。如果都出现过了，就是返回n+1即可。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        int result = new LackFirstPostiveNumber().firstMissingPositive(nums);
        System.out.println(result);
    }

    public int firstMissingPositive(int[] nums) {
        int appearCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                appearCount++;
            }
            if (nums[i] <= 0 || nums[i] >= nums.length + 1) {
                nums[i] = 1;
            }
        }
        if (appearCount == nums.length) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            nums[abs - 1] = -Math.abs(nums[abs - 1]); //标记为负数
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                //代表没有出现过
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
