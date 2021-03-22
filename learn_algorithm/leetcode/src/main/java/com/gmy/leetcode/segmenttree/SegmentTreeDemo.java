package com.gmy.leetcode.segmenttree;

/**
 * x << 1 ==> x * 2
 * x << 1 | 1 ==> x * 2 + 1
 *
 * https://www.cnblogs.com/xenny/p/9801703.html
 */
public class SegmentTreeDemo {

    private int[] arr;
    private int[] tmp;

    public SegmentTreeDemo(int[] arr) {
        this.arr = arr;
        this.tmp = new int[arr.length * 4];
    }

    public void build(int k, int left, int right) {
        if (left == right) {
            tmp[k] = arr[left];
        } else {
            int mid = (left + right) / 2;
            // 左子树 * 2
            build(k << 1, left, mid);
            // 右子树 * 2 + 1
            build(k << 1 | 1, mid + 1, right);
            // 计算父节点
            pushUp(k);
        }
    }

    public void update(int point, int value, int left, int right, int k) {
        if (left == right) {
            arr[point] = value;
            tmp[k] = value;
        } else {
            int mid = (left + right) / 2;
            if (point <= mid) {
                update(point, value, left, mid, k << 1);
            } else {
                update(point, value, mid + 1, right, k << 1 | 1);
            }
            pushUp(k);
        }
    }

    /**
     * 查询范围内最大的值
     * @param left
     * @param right
     * @return
     */
    public int search(int left, int right) {
        return search(0, left, right, 0, tmp.length - 1);
    }

    /**
     * 查询数据
     * @param k
     * @param left
     * @param right
     * @param pointLeft
     * @param pointRight
     * @return
     */
    private int search(int k, int left, int right, int pointLeft, int pointRight) {
        if (right == pointRight && left == pointLeft) {
            return tmp[k];
        } else {
            int mid = (left + right) / 2;
            int result = Integer.MIN_VALUE;
            if (left <= mid) {
                result = Math.max(result, search(k << 1, left, right, pointLeft, mid));
            } else {
                result = Math.max(result, search(k << 1 | 1, left, right, mid + 1, pointRight));
            }
            return result;
        }
    }

    private void pushUp(int k) {
        tmp[k] = Math.max(tmp[k << 2], tmp[k << 2 | 1]);
    }

}
