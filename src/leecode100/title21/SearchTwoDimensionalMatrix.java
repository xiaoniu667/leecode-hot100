package leecode100.title21;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked
 * 题目：编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 */
public class SearchTwoDimensionalMatrix {
    /**
     * 思路：我先试试暴力算法 ....直接ac了
     */

    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return  false;

    }
}
