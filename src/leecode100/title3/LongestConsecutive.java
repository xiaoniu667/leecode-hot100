package leecode100.title3;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 题目：最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutive {

    /**
     * 思路：先将所有的数字存放到hashmap之中，
     * 然后遍历number去看hashmap是否存在，如果存在number+1,再去hashmap看是否存在，一直统计
     * 如果不存在就检查下一个number
     */

    public static void main(String[] args) {
       int[] nums =  new int[]{100,4,200,1,3,2};
        int count = new LongestConsecutive().longestConsecutive(nums);
        System.out.println(count);

    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        Set<Integer> keySet = hashMap.keySet();
        int maxCount = 0;
        for (Integer key : keySet) {
            if(!hashMap.containsKey(key-1)){
                int count = 0; //定义一个计数器
                while (hashMap.containsKey(key)) {
                    count++;
                    key = key + 1;
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }
}
