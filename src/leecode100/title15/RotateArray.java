package leecode100.title15;

/**
 * 旋转数组：
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */
public class RotateArray {

    /***
     * 思路：利用循环队列的思想，当前数组中的值替换为 i + k % length 即可
     */

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4, 5, 6, 7}; //7
        int k = 3;
        new RotateArray().rotate(num, k);
        for (int i = 0; i < num.length; i++) {
            System.out.println("排序后的数组为:" + num[i] + " ");
        }
    }

    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] =result[i];
        }
    }
}
