package leecode100.title18;

import java.util.Arrays;

/*
题目：给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-100-liked
输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
输出：[[1,0,1],[0,0,0],[1,0,1]]

输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

 */
public class MaxtriSetZero {


    /**
     * 思路：因为使用的是原地算法，所以利用矩阵的第一行和第一列作为标记。
     * 1.遍历第一行和第一列查看是否含有0，如果有0，标记一下，后续需要对第一行和第一列进行特殊的处理，置为0。
     * 2.从第二行第二列开始遍历，查看是否含有0，如果有0的话，在对应第一行或者第一列的位置上去标记0.
     * 3.遍历矩阵，在第一行和第一列有0标记的地方，将除了第一行和第一列的地方设置为0.
     * 4.统一处理之前的第一行和第一列的标记情况.
     */


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new MaxtriSetZero().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        int colNum = matrix[0].length;
        int rowNum = matrix.length;
//        遍历第一行和第一列
        boolean isHasZeroRow = false;
        boolean isHasZeroCol = false;
        for (int i = 0; i < colNum; i++) {
            if (matrix[0][i] == 0) {
                isHasZeroRow = true;
                break;
            }
        }
        for (int j = 0; j < rowNum; j++) {
            if (matrix[j][0] == 0) {
                isHasZeroCol = true;
                break;
            }
        }
        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < colNum; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0; //第一行
                    matrix[i][0] = 0; //第一列
                }
            }
        }
        //遍历第一行和第一列，如果为0的话，将这一行和这一列都设置为0
        for (int i = 1; i < colNum; i++) {
            if (matrix[0][i] == 0) {
                //将这一列都置为0
                for (int j = 0; j < rowNum; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i < rowNum; i++) {
            if (matrix[i][0] == 0) {
                //将这一行都置为0
                for (int j = 0; j < colNum; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (isHasZeroRow) {
            for (int i = 0; i < colNum; i++) {
                matrix[0][i] = 0;
            }
        }
        if (isHasZeroCol) {
            for (int i = 0; i < rowNum; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
