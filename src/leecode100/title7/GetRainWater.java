package leecode100.title7;

/**
 * 题目：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class GetRainWater {
    /**
     * 思路：某大厂算法题  见过一次就秒  没见过想不出来   记住过程即可
     * 要计算某个位置的积水量，需要知道该位置左右两侧的最大高度。
     * 积水量 = min(左边最大高度, 右边最大高度) - 当前柱子高度（如果结果为负，则积水量为0）。
     * 遍历每个位置，计算其积水量并累加，得到总积水量。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = new GetRainWater().trap(nums);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        //可以先用两数组存储每个位置左右两侧高度的最大值 用空间换时间
        int[] left = new int[height.length];
        int[] right = new int[height.length];
//        left[0] = 0;
//        right[height.length - 1] = 0;
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int total = 0;
        for (int i = 0; i < height.length; i++) {
//            //当前柱子可以接的雨水
//            int getWaterNumber = Math.min(left[i], right[i]) - height[i];
//            if(getWaterNumber<0){
//                getWaterNumber = 0;
//            }
//            total = total + getWaterNumber;
            total += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return total;
    }
}
