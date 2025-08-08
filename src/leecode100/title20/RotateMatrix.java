package leecode100.title20;

import java.util.Arrays;

/**
 * 题目：
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */
public class RotateMatrix {

    /**
     * 思路：
     * 原来的矩阵：
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * 旋转后，变成：
     * 7 4 1
     * 8 5 2
     * 9 6 3
     * 你会发现：
     * 第一行（1 2 3）变成了最后一列（1 2 3 倒过来，变成 3 2 1）。
     * 第二行（4 5 6）变成了倒数第二列（6 5 4）。
     * 最后一行的 7 8 9 变成了第一列（7 8 9）。
     * 但是我们不能利用另一个矩阵来旋转，怎么做呢？
     * 先将矩阵斜着对角互换，然后再左右翻。
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateMatrix().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        //对角翻
        for (int i = 0; i < rowNum; i++) {
            for (int j = i; j < colNum; j++) {  //遍历对角矩阵即可
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //左右翻 matrix[i][j] 和 matrix[i][n-1-j]
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][colNum - 1 - j];
                matrix[i][colNum - 1 - j] = temp;
            }
        }


    }

}
