package com.gmy.leetcode.monostone_stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/online-stock-span
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StockSpanner {

    private List<Integer> priceList;
    private List<Integer> changeNum;
    private Deque<Integer> deque;
    private int index;

    public StockSpanner() {
        this.priceList = new ArrayList<>();
        this.changeNum = new ArrayList<>();
        this.deque = new LinkedList<>();
        this.index = 0;
    }

    public int next(int price) {
        priceList.add(price);
        int res = 1;
        while (!deque.isEmpty() && price >= priceList.get(deque.peek())) {
            res += changeNum.get(deque.pop());
        }
        changeNum.add(res);
        deque.push(index++);
        return res;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

}
