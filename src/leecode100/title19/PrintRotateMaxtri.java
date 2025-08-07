package leecode100.title19;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/spiral-matrix/?envType=study-plan-v2&envId=top-100-liked
题目：给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

 */
public class PrintRotateMaxtri {


    /**
     * 思路：维护四个边界开始遍历即可。考虑边界情况：如果矩阵为空，直接返回结果。如果矩阵只有一行或者一列的话，特殊处理。
     */

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}};
        List<Integer> resultList = new PrintRotateMaxtri().spiralOrder(matrix);
        resultList.forEach(System.out::println);
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return new ArrayList<>();
        }
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1; //列数
        int bottom = matrix.length - 1;  //行数
        while (top <= bottom && left <= right) {
            if (top <= bottom) {
                for (int i = left; i <= right; i++) {
                    resultList.add(matrix[top][i]); //从左边向右边开始遍历 遍历top行
                }
                top++;
            }
            if (left <= right) {
                for (int i = top; i <= bottom; i++) { //从上到下开始遍历  遍历right列
                    resultList.add(matrix[i][right]);
                }
                right--;
            }
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {  //从右边到左边开始遍历
                    resultList.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {  //从下到上开始开始遍历
                    resultList.add(matrix[i][left]);
                }
                left++;
            }
        }
        return resultList;
    }
}
