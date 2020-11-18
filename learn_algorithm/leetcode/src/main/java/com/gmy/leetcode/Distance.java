package com.gmy.leetcode;

/**
 *给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0)
 * 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，
 * |r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Distance {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        return null;
    }

    private void getResult(int R, int C, int r0, int c0, int[][] result, int index) {
        result[index] = new int[] {r0, c0};
        if (r0 > 0 && c0 > 0) {
            index++;
            getResult(R, C, r0 - 1, c0, result, index);
        }
        if (r0 < (R - 1) && c0 < (R - 1)) {
            index++;
            getResult(R, C, r0 + 1, c0 + 1, result, index);
        }
    }

}
