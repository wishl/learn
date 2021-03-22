package com.gmy.leetcode.numtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给你一个二维整数数组rectangles，其中rectangles[i] = [li, hi]表示第i个矩形长为li高为hi。给你一个二维整数数组points，
 * 其中points[j] = [xj, yj]是坐标为(xj, yj)的一个点。
 * 第i个矩形的 左下角在(0, 0)处，右上角在(li, hi)。
 *
 * 请你返回一个整数数组count，长度为points.length，其中count[j]是 包含 第j个点的矩形数目。
 *
 * 如果0 <= xj <= li 且0 <= yj <= hi，那么我们说第i个矩形包含第j个点。如果一个点刚好在矩形的 边上，这个点也被视为被矩形包含。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-number-of-rectangles-containing-each-point
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountRectangles {

    /**
     * 创建两个树状数组 然后根据index寻找sum，获取min
     * @param rectangles
     * @param points
     * @return
     */
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Map<Integer, List<Integer>> integerListMap = transToMap(rectangles);
        int[] result = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            List<Integer> lengths = getLengths(points[i][1], integerListMap);
            if (lengths == null || lengths.size() == 0) {
                result[i] = 0;
                continue;
            }
            ArrayBit arrayBit = new ArrayBit(lengths);
            Integer max = lengths.stream().max(Integer::compare).get();
            int sum = arrayBit.sum(max);
            int sum1 = arrayBit.sum((points[i][0] - 1) > max ? max : (points[i][0] - 1));
            result[i] = sum - sum1;
        }
        return result;
    }

    private Map<Integer, List<Integer>> transToMap(int[][] rectangles) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            List<Integer> length = result.getOrDefault(rectangles[i][1], new ArrayList<>());
            length.add(rectangles[i][0]);
            result.put(rectangles[i][1], length);
        }
        return result;
    }

    private List<Integer> getLengths(int high, Map<Integer, List<Integer>> integerListMap) {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : integerListMap.entrySet()) {
            Integer key = entry.getKey();
            if (key >= high) {
                result.addAll(entry.getValue());
            }
        }
        return result;
    }

    class ArrayBit {

        private int[] nums;

        public ArrayBit(int[] nums) {
            this.nums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

        public ArrayBit(List<Integer> list) {
            Integer max = list.stream().max(Integer::compareTo).get();
            this.nums = new int[max + 1];
            for (int i = 0; i < list.size(); i++) {
                add(list.get(i), 1);
            }
        }

        public void add(int index, int num) {
            for (int i = index; i < nums.length; i += lowBit(i)) {
                nums[i] += num;
            }
        }

        public int sum(int index) {
            if (index <= 0) {
                return 0;
            }
            int result = 0;
            for (int i = index; i > 0; i -= lowBit(i)) {
                result += nums[i];
            }
            return result;
        }

        private int lowBit(int x) {
            return x & -x;
        }
    }

    public static void main(String[] args) {
        CountRectangles countRectangles = new CountRectangles();
//        int[] ints = countRectangles.countRectangles(new int[][]{{4, 7}, {4, 9}, {8, 5}, {6, 2},{6, 4}}, new int[][]{{4, 2}, {5, 6}});
//        [[4,7],[4,9],[8,5],[6,2],[6,4]]
//[[4,2],[5,6]]
        int[] ints = countRectangles.countRectangles(new int[][]{{7, 1}, {2, 6}, {1, 4}, {5, 2}, {10, 3}, {2, 4}, {5, 9}},
                new int[][]{{10, 3}, {8, 10}, {2, 3}, {5, 4}, {8, 5}, {7, 10}, {6, 6}, {3, 6}});
        System.out.println(Arrays.toString(ints));
    }
}
