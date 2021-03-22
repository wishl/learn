package com.gmy.leetcode.numtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReconstructQueue {

    /**
     * 从小往大插入 每次插入时保证前面有K个空挡 这样后面的人再进入空挡的时候可以满足当前人的前缀需求了
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });
        int[][] res = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            int count = person[1] + 1;
            for (int j = 0; j < res.length; j++) {
                if (res[j] == null) {
                    count--;
                    if (count == 0) {
                        res[j] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

//

    public static void main(String[] args) {
        int[][] nums = new int[][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        ReconstructQueue queue = new ReconstructQueue();
        int[][] ints = queue.reconstructQueue(nums);
        System.out.println(Arrays.deepToString(ints));
    }
    
}
