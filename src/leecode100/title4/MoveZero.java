package leecode100.title4;

/**
 * 题目：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZero {

    /*
    思路：利用双指针 因为要保持相对顺序 所以利用一个left指针指向非零元素的的位置 利用另一个right指针进行遍历
    最后将left指针后面的所有的元素替换为0
     */

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZero().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right <= nums.length - 1) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        while (left <= nums.length - 1) {
            nums[left] = 0;
            left++;
        }
    }
}
