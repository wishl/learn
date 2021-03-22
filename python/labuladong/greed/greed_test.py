# -*- coding:utf8 -*-

"""
https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tan-xin-lei-xing-wen-ti/tan-xin-suan-fa-zhi-qu-jian-tiao-du-wen-ti
"""
# 贪心算法
from typing import List


def take_second(elem):
    return elem[1]


def interval_schedule(intvs: List[List[int]]) -> int:
    # 根据第二个数排序
    intvs.sort(key=take_second)
    count = 1
    end = intvs[0][1]
    for i in range(1, len(intvs)):
        start = intvs[i][0]
        if start >= end:
            count += 1
            end = intvs[i][1]
    return count


def main():
    intvs = [[1, 2], [2, 3], [3, 4], [1, 3]]
    print(interval_schedule(intvs))


if __name__ == '__main__':
    main()
