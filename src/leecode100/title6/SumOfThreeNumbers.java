package leecode100.title6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */
public class SumOfThreeNumbers {
    /**
     * 思路:先将数组排序，然后利用双指针，固定一个num[i],left指针指向i+1,right指针指向num.length-1,利用-nums[i]=nums[j]+nums[k]这个关系去找，
     * 如果nums[j]+nums[k]<-num[i], 说明和不够，left移动，left++,反之,right--,因为之前是顺序存储。
     * 注意：有几个地方需要去重，第一个固定住的num[i]和num[i-1],另一个是当移动left指针的时候如果num[left]和number[left-1]，最后一个是移动right,num[right]和num[right+1]
     */
    public static void main(String[] args) {
        int[] numbers = new int[]{1, -1, -1, 0};
        List<List<Integer>> list = new SumOfThreeNumbers().threeSum(numbers);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left] - 1) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                if (-nums[i] == nums[left] + nums[right]) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    continue;
                }
                if (-nums[i] > nums[left] + nums[right]) {
                    left++;
                } else if (-nums[i] < nums[left] + nums[right]) {
                    right--;
                }
            }
        }
        return resultList;
    }
}
