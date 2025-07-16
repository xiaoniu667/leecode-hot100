package leecode100.title5;

/**
 * 题目：
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class MaxWaterArea {
    /**
     * 思路：双重for循环，固定一段left指针不动，移动right指针，计算面积值，利用max函数记录下最大值。但是时间复杂度比较高 o(n2)
     * 换个思路 利用双指针 left指针在数组开头 right指针在数据结尾 只需要移动高度较小的指针面积才有可能变大 最后指导两个指针相遇即可结束
     */
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = new MaxWaterArea().maxArea(height);
        System.out.println(maxArea);
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) {
                maxArea = area;
            }
            if(height[left]>=height[right]){
                right--;
            }else {
                left++;
            }
        }
        return maxArea;
    }


//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = (j - i) * Math.min(height[i], height[j]);
//                if (area > maxArea) {
//                    maxArea = area;
//                }
//            }
//        }
//        return maxArea;
//    }

}
