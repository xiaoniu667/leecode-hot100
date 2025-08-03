package leecode100.title14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
 * 题目：
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergeArray {

    /**
     * 思路：将里面的数组进行排序，然后检查当前区间和结果区间进行对比，如果当前区间的start下表的值在结果区间之中，合并区间，否则不合并。
     */

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 4},{0,4}};
        int[][] merge = new MergeArray().merge(intervals);
        for (int[] interval : merge) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));//进行排序
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int temp = intervals[i][0];  //取出第一个元素
            int[] resultArray = result.get(result.size() - 1);
            if (temp <= resultArray[1]) {
                //如果temp的值大于结果集中最后一个数组的第二个数的大小,进行合并
                resultArray[0] = Math.min(resultArray[0],intervals[i][0]);
                resultArray[1] = Math.max(resultArray[1],intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }
        //集合转为数组
        return result.toArray(new int[result.size()][]);
    }
}
