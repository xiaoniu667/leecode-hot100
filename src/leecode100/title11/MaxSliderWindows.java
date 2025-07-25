package leecode100.title11;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目：滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class MaxSliderWindows {
    /**
     * 思路：维护一个单调队列，队头存储元素最大的值，之后，进行滑动窗口，队头永远是最大的值。
     * i-k+1是最左侧窗口的值，除去最左侧的值，添加新的值，之后继续维护单调队列，取出单调队列中的值。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] results = new MaxSliderWindows().maxSlidingWindow(nums, 3);
        for (int result : results) {
            System.out.print(result + " ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> resultList = new ArrayList<>();
        LinkedList<Integer> sliderQueue = new LinkedList<>();
        //维护一个单调队列  队头最大
        for (int i = 0; i < k; i++) {
            while (!sliderQueue.isEmpty() && nums[sliderQueue.getLast()] < nums[i]) {
                //移除队尾索引
                sliderQueue.removeLast();
            }
            sliderQueue.addLast(i);
        }
        // 5 3
        //  2  3
        //记录队列中的最大值 记录第一轮
        resultList.add(nums[sliderQueue.getFirst()]);
        //进行滑动窗口
        for (int i = k; i < nums.length; i++) {
            //移除窗口最左侧的索引
            if (!sliderQueue.isEmpty() && sliderQueue.getFirst() < i - k + 1) {
                sliderQueue.removeFirst();
            }
            //维护单调队列的性质
            while (!sliderQueue.isEmpty() && nums[sliderQueue.getLast()] < nums[i]) {
                //移除队尾索引
                sliderQueue.removeLast();
            }
            sliderQueue.addLast(i);
            resultList.add(nums[sliderQueue.getFirst()]);
        }
        //将集合转为数组
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;

    }


/**
 * 下面是ai给出的建议：
 * 你的代码实现了一个滑动窗口最大值问题，但时间复杂度较高，主要是因为每次滑动窗口时，
 * 你都通过遍历整个窗口（sliderQueue）来重新计算最大值，导致整体时间复杂度为 O(n * k)，
 * 其中 n 是数组长度，k 是窗口大小。为了优化时间复杂度，可以使用 单调队列（Monotonic Queue） 或 双端队列（Deque） 来维护窗口内的最大值，
 * 使得每次滑动窗口时都能以 O(1) 或均摊 O(1) 的复杂度获取最大值。
 * 优化后的时间复杂度可以降到 O(n)。
 **/
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        ArrayList<Integer> resultList = new ArrayList<>();
//        LinkedList<Integer> sliderQueue = new LinkedList<>();
//        int max = Integer.MIN_VALUE;
//        //将第一轮的数据放入sidernum;
//        for (int i = 0; i <= k - 1; i++) {
//            sliderQueue.addLast(nums[i]);
//        }
//        //记录队列中的最大值
//        for (int value : sliderQueue) {
//            max = Math.max(max, value); // 直接比较队列中的值
//        }
//        resultList.add(max);
//        //进行滑动窗口的移动
//        for (int i = k; i <= nums.length - 1; i++) {
//            //移除队头第一个元素，从队尾添加
//            Integer removeFirst = sliderQueue.removeFirst();
//            sliderQueue.addLast(nums[i]);//从队尾添加一个元素
//            // 如果移除的元素不是最大值，且新元素小于等于当前最大值
//            if (removeFirst != max && nums[i] <= max) {
//                // 最大值不变，直接使用
//                resultList.add(max);
//            } else {
//                // 如果移除的是最大值，或者新元素可能更大，需要重新找最大值
//                max = Integer.MIN_VALUE;
//                for (int value : sliderQueue) {  //没有解决本质的问题
//                    max = Math.max(max, value);
//                }
//                resultList.add(max);
//            }
//        }
//        //将集合转为数组
//        int[] result = new int[resultList.size()];
//        for (int i = 0; i < resultList.size(); i++) {
//            result[i] = resultList.get(i);
//        }
//        return result;
//    }
}
